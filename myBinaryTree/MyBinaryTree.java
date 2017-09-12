package myBinaryTree;

import java.util.LinkedList;
import java.util.List;

public class MyBinaryTree {
	
	private int[] array = {1,2,3,4,5,6,7,8,9};
	
	private static List linkedList = null;
	
	//inner class Node
	private static class Node
	{
		private int data;
		private Node leftChildTree;
		private Node rightChildTree;
		
		private Node(int data)
		{
			this.data = data;
			this.leftChildTree = null;
			this.rightChildTree = null;
		}
	}
	//Construct Binary Tree
	public void createBinaryTree()
	{
		linkedList = new LinkedList ();
		
		//Covert each array element into node
		for(int arrayIndex = 0; arrayIndex<array.length; arrayIndex++)
		{
			linkedList.add(new Node(array[arrayIndex]));
			
		}
		
		//Construct Binary tree structure
		for(int parentIndex = 0; parentIndex<array.length/2 -1 ;parentIndex++)
		{
			Node newNode = (Node) linkedList.get(parentIndex);
			
			//Construct LeftSub Tree
			newNode.leftChildTree = (Node) linkedList.get(parentIndex*2+1);
			
			//Construct right Tree
			newNode.rightChildTree = (Node) linkedList.get(parentIndex*2+2);
		}
		
		//Last layer of binary tree
		//LeftSubStree
		int lastParentIndex = array.length / 2 -1;
		Node lastParentNode = (Node) linkedList.get(lastParentIndex);
		lastParentNode.leftChildTree = (Node) linkedList.get(lastParentIndex*2 +1);
		
		//RightSubStree
		if (array.length % 2 == 1)
			lastParentNode.rightChildTree = (Node) linkedList.get(lastParentIndex*2+2);
	}
	
	//Preorder Traversal:  D -> Left ->Right
	public static void preOrderTraverse(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " "); 
		preOrderTraverse(node.leftChildTree);
		preOrderTraverse(node.rightChildTree);
	}
	
	
	//Inorder Traversal: Left -> D ->Right
	public static void inOrderTraverse(Node node)
	{
		if(node == null)
			return;
		inOrderTraverse(node.leftChildTree);
		System.out.print(node.data + " ");
		inOrderTraverse(node.rightChildTree);
	}
	
	//Inorder Traversal Left -> Right -> D
	public static void postOrderTraverse(Node node)
	{
		if(node == null)
			return;
		postOrderTraverse(node.leftChildTree);
		postOrderTraverse(node.rightChildTree);
		System.out.print(node.data + " ");
	}

	//Test Binary Tree and traversal
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBinaryTree mbt = new MyBinaryTree();
		
		//Generate Binary Tree
		mbt.createBinaryTree();
		
		//Get root node
		Node root = (Node) linkedList.get(0);
		
		//Preorder Traversal
		System.out.print("Preorder Traversal:");
		mbt.preOrderTraverse(root);
		System.out.println();
		
		//Inorder Traversal
		System.out.print("Ineorder Traversal:");
		mbt.inOrderTraverse(root);
		System.out.println();
		//Posteorder Traversal
		System.out.print("Postorder Traversal:");
		mbt.postOrderTraverse(root);
		System.out.println();
	}
}
