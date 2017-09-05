package testApp;

import java.util.Iterator;
import java.util.NoSuchElementException;

import myList.*;
public class TestDataStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList<Integer> myList= new MyArrayList<Integer>(3);
		
		myList.add(1,1);
		myList.add(2,2);
		myList.add(3,3);
		myList.add(4,4);
		myList.remove(4);
		
		System.out.println("Current Size:" + myList.size());
		System.out.println("Index 3 Valu:"+ myList.get(3));
		System.out.println("Contains 2?:"+ myList.contains(2));
		
		//Demo on catch Exception
		try
		{	
			//Will throw NoSuchElementException
			myList.get(9);
		}
		
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("NoSuchElementException"+e.getMessage());
		}
		
		//Test toString
		System.out.println(myList.toString());
		
		//Test Iterator
		Iterator<Integer> myIterator = myList.iterator();
		while(myIterator.hasNext())
		{
			System.out.println(myIterator.next());
		}
		
	}

}
