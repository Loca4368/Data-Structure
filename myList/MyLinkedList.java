package myList;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable <T>{

	
	private LinkedList<T> myLinkedList = new LinkedList<T> ();
	
	//Class for Construct  Node
	private static class Node<T>{
	
		//Node value
		public T data;;
		
		//Point to previous node 
		public Node<T> prev;
		
		//Point next node
		public Node<T> next;
		
		public Node(T data, Node<T> prev,Node<T> next)
		{
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	//head and tail marker
	private Node<T> head;
	
	private Node<T> tail;
	
	//For recording number of list elements
	private int size;
	
	//For counting times during traversal
	private int modCounter;
	
	//Constructor 
	public MyLinkedList()
	{
		clear();
	}
	
	//Clear and reset LinkedList
	public void clear()
	{
		head = new Node(null, null, null);
		tail= new Node(null,head,null);
		
		head.next = tail;
		
		this.modCounter = 0;
		this.size = 0;
	}
	
	//Get number of elements in list
	public int size()
	{
		return size;
	}
	
	//Check if list is empty
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	//Validate index
	public boolean isIndexValid(int index)
	{
		if(index <= 0 || index > size())
			return false;
		return true;
	}
	
	//Get node by index
	private Node<T> getNode(int index)
	{
		
		if(!isIndexValid(index))
		{
			throw new IndexOutOfBoundsException();
		}
		
		modCounter = 0;
		
		Node<T> target;
		//Scan from head in first Half 
		if(index < size()/2)
		{
			//Scan from head;
			target = head;
			for(int i=0; i<=index; i++)
			{
				target = target.next;
				modCounter++;
			}
			
		}
		
		//Scan from tail in latter Half
		else
		{
			//Scan from head;
			target = tail;
			for(int i=size(); i>=index; i--)
			{
				target = target.prev;
				modCounter++;
			}
			
			;
		}
		
		//return the indexed node data
		return target;
	
	}
	
	//Get index
	public int indexOf(T data)
	{
		//By default not result matches
		int result = -1;
		
		modCounter = 0;
		
		//Scan from head
		Node<T> target = head;
		
		for(int i=0; i<size();i++)
		{
			target = target.next;
			modCounter++;
			//If matches
			if(target.data == data)
			{
//				return result = modCounter;
				result = modCounter;
				break;
			}
		}
		
		return result;
	}
	
	//Contains 
	public boolean contains(T data)
	{
		return (-1 == (indexOf(data))? false: true);
	}
		
	
	//Get element by index
	public T get(int index)
	{
		if(!isIndexValid(index))
		{
			throw new IndexOutOfBoundsException("Index Out of Bounds");
		}
		//Call private getNode() method
		return getNode(index).data;
	}
	
	//Get data of first node
	public T getFirst()
	{
		if(isEmpty())
		{
			return null;
		}
		return head.next.data;
	}
	
	//Get data of last node
	public T getLast()
	{
		if(isEmpty())
		{
			return null;
		}
		return tail.prev.data;
	}
	
	//Set by index
	public void set(int index, T newData)
	{
		getNode(index).data = newData;
	}
	
	//Add to first index by default
	public void add(T data){
		
		//Create an newNode base on the input  
		Node<T> newNode = new Node(data,null,null);
		
		//Get current first node
		Node<T> currentFirstNode= head.next;
		
		//Redirect 4 pointers
		newNode.prev = head;
		newNode.next = currentFirstNode;
		
		head.next = newNode;
		currentFirstNode.prev = newNode;
		
		//Recorde size
		size++;
		}
		
	//Add element by index 
	public void add(int index, T data)
	{
		if(!isIndexValid(index))
		{
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> currentIndexNode = getNode(index);
		
		Node<T> currentPrevNode = currentIndexNode.prev;
		
		Node<T> newAddNode = new Node<T>(data, null,null);
		
		//Redirect Pointers
		newAddNode = currentPrevNode.next;
		newAddNode = currentIndexNode.prev;
		
		currentPrevNode = newAddNode.prev;
		currentIndexNode = newAddNode.next;
		
		size++;
	}
	
	
	//Remove by data
	public boolean remove(T data)
	{
		boolean result;
		//Scan from head in first Half 
		Node<T> target = head;
		for(int i=0; i<=size(); i++)
		{
			target = target.next;
			if(target.data == data)
			{
				result = true;
			}
		}
		return false;
	}
	
	//Remove by index
	public void remove(int index)
	{
		if(!isIndexValid(index))
		{
			throw new IndexOutOfBoundsException();
		}	
		Node<T> currentIndexNode = getNode(index);
		Node<T> currentPrevNode = currentIndexNode.prev;
		Node<T> currentNexNode = currentIndexNode;
		currentNexNode = currentPrevNode.next;
		currentPrevNode = currentNexNode.prev;	
		
		size--;
	}
	
	//For Duque implementation
	public void push(T newData)
	{
		//Create an newNode base on the input  
		Node<T> newNode = new Node(newData,null,null); 
		
		//Get current first node
		Node<T> currentFirstNode= head.next;
		
		//Redirect 4 pointers
		newNode.prev = head;
		newNode.next = currentFirstNode;
		
		head.next = newNode;
		currentFirstNode.prev = newNode;
		
		//Recorde
		size++;
	}
	
	
	//Check the first Elementy6y
	public T peak()
	{
		return head.next.data;
	}
		
	//Default remove first element
	public T pop()
	{
		if(isEmpty())
		{
			//
			throw new EmptyStackException();
		}
		//get first node
		Node<T> firstNode = head.next;
		Node<T> secondNode = firstNode.next;
		
		//get first node data for return;
		T result =  firstNode.data;
			
		//Redirect pointers
		head = secondNode.prev;
		secondNode = head.next;	
		firstNode.next = head.next; 
		tail = firstNode.next.next;
			
		size--;
		
		return result;
	}
		
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator <T> ();
	}
	
	//Custom Iterator
	private class MyIterator <T> implements Iterator <T>
	{
		//Create a reference type of Node <T>, and point to head
		@SuppressWarnings("unchecked")
		Node<T> current = (Node<T>) head;

		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return current.next != tail;
		}

		public T next() {
			// TODO Auto-generated method stub
			T data = null;
			if(!hasNext())
			{
				throw new IndexOutOfBoundsException();
			}
			data = current.data;
			current = current.next;
			return data;
		}
		
	}

	@Override
	public String toString() {
		Iterator<T> myIterator = this.iterator();
		StringBuilder builder = new StringBuilder();
		builder.append("MyLinkedList [");
		if (!myIterator.hasNext())
            return "[]";
		for (;;) {
			T data = myIterator.next();
			builder.append(data == this ? "(this Collection)" : data);
			if (! myIterator.hasNext())
				return builder.append(']').toString();
			builder.append(',').append(' ');
            }
	
	}



}