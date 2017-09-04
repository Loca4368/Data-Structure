/*
 *@Description: Custom implementation on ArrayList
 *@Author:Ming
 * 
 */
package myList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable <T>{
	
	
	// Set Default ArrayList Size
    private static final int DEFAULT_CAPACITY = 10;
  
    // Actual Size
	private int size;
	
	//Use array as a base to construct ArrayList
	private T[] myArray;
	
	//Default Constructor
	public MyArrayList()
	{
		myArray = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	//Constructor with an int argument
	public MyArrayList(int capacity)
	{
		if (size < 0){
			throw new IllegalArgumentException("Default Size:" + DEFAULT_CAPACITY);
        }
		else{
			//Init arrayList 
			myArray = (T[]) new Object[capacity];
        }
	}
	
	//Get Index Element
	public T get(int index){
		
		//Throw exception when  index is out of bounds
		if(isIndexValid(index)){
			throw new IndexOutOfBoundsException();
		}
		return myArray[index];
	}
	
	
	//Add element by index
	public void add(int index, T element)
	{
		//Throw exception if index is out of bounds
		if(isIndexValid(index)){
			throw new IndexOutOfBoundsException();
		}
		
		//Extend ArrayList Size, If current number of element exceed current size of ArrayList
        if(myArray.length == size()){
            ensureCapacity(size() * 2 + 1);
        }
		
		// Move affected elements backward for 1 position 
		for(int i= size; i>index;i--)
		{
			myArray[i] = myArray[i-1];
		}
		
		//Use System.arraycopy to move element
//		System.arraycopy(element, index, element, index + 1,size - index);
		
		//Add new element to index position
		myArray[index] = element;
		
		//Increase array size by 1
		size++;
	}
	
	//By default, add new element to the last.
	public boolean add(T element)
	{
		add(size(),element);
	  	return true;
	  	
	}
	
	//Remove
	public void remove(int index)
	{
		//Throw exception when  index is out of bounds
		if(isIndexValid(index)){
			throw new IndexOutOfBoundsException();
		}
		// Move affected elements forward for 1 position 
		for(int i = index;i<size()-1;i++)
		{
			myArray[i] = myArray[i+1];
		}
		
		//Decrease size by 1
		size--;
	}
	
	//Check if contains specific element
	public boolean contains(T element)
	{
		boolean result = false;
		for(int i=0;i<size();i++)
		{
			if(myArray[i] == element)
				result = true;
		}
		return result;
	}
	
	//Get List Size
		public int size()
		{
			return size;
		}
	
	//Update element by index
	public void set(int index, T newElement)
	{
		//Throw exception when  index is out of bounds
		if(isIndexValid(index)){
			throw new IndexOutOfBoundsException();
		}
		//Assign new value 
		myArray[index] = newElement;
					
	}
	
	//Check arrayList if Empty
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	//Validate index
	public boolean isIndexValid(int index)
	{
		if(index < 0 || index >= size())
		{
			return false;
		}
		else
			return true;
	}
	
	//Clear List
	public void clear()
	{
		size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
	}

	//Extends ArirayList Size
	public void ensureCapacity(int newCapacity)
	{
		
		if(newCapacity < size){
            return;
        }
        T[] current = myArray;
     
        myArray = (T[])new Object[newCapacity];
        for(int i = 0;i<size();i++){
            myArray[i] = current[i];
        }
	}
	
	
	
	//Override Iterator
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}
	
	//Override Iterator<T>
	private class MyIterator implements Iterator<T>
	{
		int current = 0;

		public boolean hasNext() {
			return current <size();
		}

		public T next() {
            
			if(!hasNext()){
                throw new NoSuchElementException();
            }
            return myArray[current++];
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyArrayList [size=");
		builder.append(size);
		builder.append(", myArray=");
		builder.append(Arrays.toString(myArray));
		builder.append("]");
		return builder.toString();
	}
	
	

}
