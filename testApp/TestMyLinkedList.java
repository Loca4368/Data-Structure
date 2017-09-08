package testApp;

import java.util.Iterator;

import myList.MyLinkedList;
public class TestMyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println("Hello World!");
		
		MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
		

		myLinkedList.add("Ming");
		myLinkedList.remove(1);
		myLinkedList.add(1,"Ming");
		System.out.println("Current List size:"+ myLinkedList.size());
		System.out.println("Element in index 1:"+myLinkedList.get(1));
		System.out.println("First element:"+myLinkedList.getFirst());
		System.out.println("Last element:"+myLinkedList.getLast());
	

		System.out.println("Element Ming located in index:"+myLinkedList.indexOf("Ming"));
		System.out.println("Does list contains element Ming? "+myLinkedList.contains("Ming"));
		System.out.println(myLinkedList.toString());
		
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
