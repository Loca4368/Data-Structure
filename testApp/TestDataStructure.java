package testApp;

import java.util.Iterator;

import myList.*;
public class TestDataStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList<Integer> myList= new MyArrayList<Integer>(3);
		
		myList.add(1);
		myList.add(2);
		myList.add(2, 3);
		myList.add(4);
		myList.add(5);
		
		System.out.println(myList.size());
		System.out.println(myList.toString());
		
		//Test Iterator
		Iterator<Integer> myIterator = myList.iterator();
		while(myIterator.hasNext())
		{
			System.out.println(myIterator.next());
		}
		
	}

}
