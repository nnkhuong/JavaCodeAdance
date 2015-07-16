package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dataStructure.BinarySearchTree.BinarySearchTree;

public class BinarySearchTreeTest {

	@Test
	public void testCountNodes()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(30);
		array.add(23);
		array.add(45);
		array.add(6);
		array.add(47);
		array.add(50);
		array.add(29);
		array.add(10);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		
		assertEquals(8, bst.countNodes());
	}
	@Test
	public void testCountLeaves()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(30);
		array.add(23);
		array.add(45);
		array.add(6);
		array.add(47);
		array.add(50);
		array.add(29);
		array.add(10);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		
		assertEquals(3, bst.countLeaves());
	}
	@Test
	public void testCountEvenNode()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(30);
		array.add(23);
		array.add(45);
		array.add(6);
		array.add(47);
		array.add(50);
		array.add(29);
		array.add(10);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		
		assertEquals(4, bst.countEvenNode());
	}
	@Test
	public void testGetHeigth()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(30);
		array.add(23);
		array.add(45);
		array.add(6);
		array.add(47);
		array.add(50);
		array.add(29);
		array.add(10);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		
		assertEquals(4, bst.getHeightOfTree());		
	}
	@Test
	public void testCollectEvenNodes()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(30);
		array.add(23);
		array.add(45);
		array.add(6);
		array.add(47);
		array.add(50);
		array.add(29);
		array.add(10);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		bst.collectEvenNodes(result);
		
		for(Integer evenNode : result)
		{
			assertTrue(evenNode % 2 == 0);
		}	
	}
	@Test
	public void testIsAllEvenNodes()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(30);
		array.add(23);
		array.add(45);
		array.add(6);
		array.add(47);
		array.add(50);
		array.add(29);
		array.add(10);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		
		assertFalse(bst.isAllEvenNumber());
	}
	@Test
	public void testIsAllEvenNodes_Various_1()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(30);
		array.add(22);
		array.add(44);
		array.add(6);
		array.add(46);
		array.add(50);
		array.add(26);
		array.add(10);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		
		assertTrue(bst.isAllEvenNumber());
	}
	@Test
	public void testMaxNode()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(30);
		array.add(22);
		array.add(44);
		array.add(6);
		array.add(46);
		array.add(50);
		array.add(26);
		array.add(10);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		
		assertEquals(50, bst.maxNode());
	}
	@Test
	public void testMinNode()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(30);
		array.add(22);
		array.add(44);
		array.add(6);
		array.add(46);
		array.add(50);
		array.add(26);
		array.add(10);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		
		assertEquals(6, bst.minNode());
	}
	@Test
	public void testPostOrDer()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(15);
		array.add(12);
		array.add(9);
		array.add(56);
		array.add(1);
		array.add(16);
		array.add(19);
		array.add(22);
		array.add(3);
		array.add(100);
		array.add(2);
		array.add(25);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.buildBinaryTree(array);
		bst.printPostOrder();
		//assertEquals(6, bst.minNode());
	}
}
