package myList;

import java.util.ConcurrentModificationException;
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
	private int modCounter = 0;
	
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
		
		this.modCounter ++;
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
		//Need to be reviewed
		if(index <= 0 || index > size())
			return false;
		return true;
	}
	
	//Get node by index
	private Node<T> getNode(int index, int lower, int upper)
	{
		if(index < lower || index > upper){
            throw new IndexOutOfBoundsException();
        }
		
		Node<T> target;
		//Scan from head in first Half 
		if(index < size()/2 )
		{
			target = head;
			for(int i=0; i<=index; i++)
			{
				target = target.next;
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

			}
		}
		
		//return the indexed node data
		return target;
	
	}
	
	private Node<T> getNode(int index)
	{
		return getNode(index, 0 ,size());
	}
	
	//Get index
	public int indexOf(T data)
	{
		//By default not result matches
		int result = -1;
		
		//Rest counter
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
				result = modCounter;
			}
		}
		
		return result;
	}
	
	//Contains 
	public boolean contains(T data)
	{
		return ((indexOf(data) == -1)? false: true);
	}
		
	
	//Get element by index
	public T get(int index)
	{
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
		
		//Get current first node
		Node<T> currentFirstNode= head.next;
		
		//Create an newNode base on the input  
		Node<T> newNode = new Node (data,head,currentFirstNode);
		
		head.next = newNode;
		currentFirstNode.prev = newNode;
		
		//Recorde size
		size++;
		}
		
	//Add element by index 
	public void add(int index, T data)
	{	
		Node<T> currentIndexNode = getNode(index-1);
		
		Node<T> newAddNode = new Node<T>(data, currentIndexNode,currentIndexNode.next);
		
		//Redirect Pointers
		currentIndexNode.next =newAddNode;
		
		currentIndexNode.next.prev  = newAddNode; 
		
		size++;
	}
	
	private Node<T> removeNode(int index)
	{
		if(!isIndexValid(index))
		{
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> currentIndexNode = getNode(index);
		
		currentIndexNode.next= currentIndexNode.prev.next;
		currentIndexNode.prev= currentIndexNode.next.prev;		
		
//		currentIndexNode.next = null;
//		currentIndexNode.prev = null;
		
		size--;
		return currentIndexNode;
	}
	
	
	//Remove by data
	public boolean remove(T data)
	{
		removeNode(indexOf(data));
		return true;
	}
	
	//Remove by index
	public T remove(int index)
	{
		return removeNode(index).data;
	}
	
	//For Iterator
	private T remove(Node<T> p){
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
        modCounter++;
        return p.data;
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
		
		//Increase size
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
		
	//Custom Iterator
	private class LinkedListIterator implements Iterator<T>{

        private Node<T> current = head.next;

        private int expectedModCount = modCounter;

        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != tail;
        }

        public T next() {
            if(modCounter != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove(){
            if(modCounter != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("[");
        Node<T> p = head.next;
        while(p!=tail.prev){
        	content.append(p.data);
        	content.append(", ");
            p = p.next;
        }
        content.append(p.data);
        content.append("]");
        return content.toString();
    }

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}