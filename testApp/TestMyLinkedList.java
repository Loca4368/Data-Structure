package testApp;

import myList.MyLinkedList;
public class TestMyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println("Hello World!");
		
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		
		myLinkedList.add(1);
		myLinkedList.remove(1);
		myLinkedList.add(1);
		myLinkedList.add(2);
		System.out.println("Current List size:"+ myLinkedList.size());
		System.out.println("First element is:"+myLinkedList.getFirst());
		System.out.println("Last element:"+myLinkedList.getLast());
		System.out.println("Element 1 located in index:"+myLinkedList.indexOf(1));
		System.out.println("Does list contains element 2? "+myLinkedList.contains(2));
		
		//Handle exception
		/*
		try{
			myLinkedList.remove(1);
			myLinkedList.get(1);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
		*/
		
//		System.out.println(myLinkedList.toString());
		
		//Test on push() pop(), clear()..
		/*
		myLinkedList.push(1);
		myLinkedList.push(2);
		
		System.out.println("Size:"+ myLinkedList.size());
		System.out.println("Pop first element:"+myLinkedList.pop());
		System.out.println("Pop first element:"+myLinkedList.pop());
		
		myLinkedList.clear();
		System.out.println("Clear List.....................");
		
		myLinkedList.push(5);
		System.out.println("Size:"+ myLinkedList.size());
		System.out.println("Pop first element:"+myLinkedList.pop());
		myLinkedList.push(5);
		System.out.println("Size:"+ myLinkedList.size());
		System.out.println("Check First element:"+myLinkedList.peak());
		*/
	}

}
