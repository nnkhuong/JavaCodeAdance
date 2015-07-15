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
		System.out.println("---------------------");
		for(Integer evenNode : result)
		{
			System.out.println(evenNode);
		}
		//assertEquals(4, bst.getHeightOfTree());		
	}

}
