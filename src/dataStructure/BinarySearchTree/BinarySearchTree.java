package dataStructure.BinarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {

	private BinaryNode root;
	
	public BinarySearchTree()
	{
		this.root = null;
	}
	
	// utility function, using inside only
	private String arrayToString(ArrayList<E> arrayList)
	{
		String str ="[";
		for(int i = 0; i < arrayList.size(); ++i)
		{
			str = str + arrayList.get(i) + ((i != arrayList.size()-1) ? ", ": "]" );
		}
		return str;
	}
	// creating whole Binary tree.
	public void buildBinaryTree(ArrayList<E> arrayList)
	{
		System.out.println("Build Binary Tree from array :" + arrayToString(arrayList));
		for(int i = 0 ; i < arrayList.size(); ++i)
		{
			insert(arrayList.get(i));
		}
	}
	// insert node , mean each step building the binary tree
	public void insert(E data)
	{
		this.root = insert(data, this.root);
	}
	
	// utility function , using inside only
	private BinaryNode insert(E data, BinaryNode rootInput)
	{
		if(rootInput == null)
		{
			rootInput = new BinaryNode(data);
		}
		else if(data.compareTo(rootInput.getData()) > 0)
		{
			BinaryNode rightNode = rootInput.getRight();
			rightNode = insert(data, rightNode);
			rootInput.setRight(rightNode);
		}
		else if(data.compareTo(rootInput.getData()) < 0)
		{
			BinaryNode leftNode = rootInput.getLeft();
			leftNode = insert(data, leftNode);
			rootInput.setLeft(leftNode);
		}
		else
		{
			// duplicate; according to Lerman Professor, ignore this case
		}
		return rootInput;
	}
	
	// LeftRootRight
	public void printInOrder()
	{
		System.out.println("Traversing Binary Tree accoding Left Root Right");
		if(this.root == null)
		{
			return;
		}
		printInOrder(this.root);
		System.out.println();
	}
	//utility function , using inside only
	private void printInOrder(BinaryNode rootInput)
	{
		if(rootInput != null)
		{
			printInOrder(rootInput.getLeft());
			System.out.print(rootInput.getData() + " ");
			printInOrder(rootInput.getRight());
		}
	}
	
	// RightRootLeft
	public void printPreOrder()
	{
		System.out.println("Traversing Binary Tree according Right Root Left");
		if(this.root == null)
		{
			return;
		}
		printPreOrder(this.root);
		System.out.println();		
	}
	
	// utility function , using inside only
	private void printPreOrder(BinaryNode rootInput)
	{
		if(rootInput != null)
		{
			printPreOrder(rootInput.getRight());
			System.out.print(rootInput.getData() + " ");
			printPreOrder(rootInput.getLeft());
		}
	}
	
	// LeftRightRoot
	public void printPostOrder()
	{
		System.out.println("Traversing Binary Tree accorsing Left Right Root");
		if(this.root == null)
		{
			return;
		}
		printPostOrder(this.root);
		System.out.println();
	}
	// utility function, using inside only
	private void printPostOrder(BinaryNode rootInput)
	{
		if(rootInput != null)
		{
			printPostOrder(rootInput.getLeft());
			printPostOrder(rootInput.getRight());
			System.out.print(rootInput.getData() + " ");
		}
	}
	
	// utility function, using inside only
	private int countNodes(BinaryNode rootInput)
	{
		if(rootInput == null)
			return 0;
		if(rootInput.getLeft() == null && rootInput.getRight() == null)
		{
			return 1;
		}
		
		return countNodes(rootInput.getLeft()) + countNodes(rootInput.getRight()) + 1;
	}
	public int countNodes()
	{
		int count = 0;
		count = countNodes(this.root);
		return count;
	}
	
	// utility function, used inside only
	private int countLeaves(BinaryNode rootInput)
	{
		if(rootInput == null)
			return 0;
		
		if(rootInput.getLeft() == null && rootInput.getRight() == null)
		{
			return 1;
		}
		return countLeaves(rootInput.getLeft()) + countLeaves(rootInput.getRight());
	}
	public int countLeaves()
	{
		int count = 0;
		count = countLeaves(this.root);
		return count;
	}
	
	public int getHeightOfTree()
	{
		return getHeightOfTree(this.root);
	}
	// utility function, used inside only
	private int getHeightOfTree(BinaryNode rootInput)
	{
		if(rootInput == null)
		{
			return 0;
		}
		else
		{
			
		}
		return max(getHeightOfTree(rootInput.getRight()) , getHeightOfTree(rootInput.getLeft() ) ) + 1 ;
	}
	
	// utility function , used inside only
	private int max(int value1 , int value2)
	{
		return (value1 > value2) ? value1 : value2;
	}
	
	public int countEvenNode()
	{
		return countEvenNode(this.root);
	}
	
	// utility function, used inside only
	private int countEvenNode(BinaryNode rootInput)
	{
		if(rootInput == null)
			return 0;
		
		return (((Integer)rootInput.getData() % 2 == 0) ? 1: 0) + countEvenNode(rootInput.left) + countEvenNode(rootInput.right);
	}
	class BinaryNode 
	{
		private E data;
		private BinaryNode left;
		private BinaryNode right;
		public BinaryNode()
		{
			this.left = null;
			this.right = null;
		}
		
		public BinaryNode(E data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public BinaryNode getLeft()
		{
			return this.left;
		}
		
		public void setLeft(BinaryNode left)
		{
			this.left = left;
		}
		
		public BinaryNode getRight()
		{
			return this.right;
		}
		public void setRight(BinaryNode right)
		{
			this.right = right;
		}
		public E getData()
		{
			return this.data;
		}
	}
}
