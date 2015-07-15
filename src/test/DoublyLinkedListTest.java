package test;
import static org.junit.Assert.*;

import org.junit.Test;

import dataStructure.DoublyLinkedList.*;
public class DoublyLinkedListTest {
	
	@Test
	public void testAddFront() {
		
		DoublyLinkedList<Integer> dllist = new DoublyLinkedList<Integer>();
		dllist.addFront(2);
		dllist.addFront(3);
		dllist.addFront(4);
		dllist.addFront(5);
		dllist.addFront(6);
		dllist.addFront(7);
		
		String expectedResult = "[7,6,5,4,3,2]";
		
		assertTrue(expectedResult.equals(dllist.toString() ));
	}
	@Test
	public void testAddLast() {
		DoublyLinkedList<Integer> dllist = new DoublyLinkedList<Integer>();	
		dllist.addLast(10);
		dllist.addLast(20);
		dllist.addLast(30);
		dllist.addLast(40);
		dllist.addLast(50);
		dllist.addLast(60);
		
		String expectedResult = "[10,20,30,40,50,60]";
		assertTrue(expectedResult.equals(dllist.toString()));
	}
	@Test
	public void testAddPre()
	{
		DoublyLinkedList<Integer> dllist = new DoublyLinkedList<Integer>();
		dllist.addFront(2);
		dllist.addFront(3);
		dllist.addFront(4);
		dllist.addFront(5);
		dllist.addFront(6);
		dllist.addFront(7);
		dllist.addLast(10);
		dllist.addLast(20);
		dllist.addLast(30);
		dllist.addLast(40);
		dllist.addLast(50);
		dllist.addLast(60);
		
		dllist.addPre(2, 100);
		
		String expectedResult = "[7,6,100,5,4,3,2,10,20,30,40,50,60]";
		assertTrue(expectedResult.equals(dllist.toString()));
	}
	@Test
	public void testAtAfter()
	{
		DoublyLinkedList<Integer> dllist = new DoublyLinkedList<Integer>();
		dllist.addFront(2);
		dllist.addFront(3);
		dllist.addFront(4);
		dllist.addFront(5);
		dllist.addFront(6);
		dllist.addFront(7);
		dllist.addLast(10);
		dllist.addLast(20);
		dllist.addLast(30);
		dllist.addLast(40);
		dllist.addLast(50);
		dllist.addLast(60);
		
		dllist.addAfter(5, 100);
		
		String expectedResult = "[7,6,5,4,3,2,100,10,20,30,40,50,60]";
		assertTrue(expectedResult.equals(dllist.toString()));		
	}
	@Test
	public void testdeleteAtFront()
	{
		DoublyLinkedList<Integer> dllist = new DoublyLinkedList<Integer>();
		dllist.addFront(2);
		dllist.addFront(3);
		dllist.addFront(4);
		dllist.addFront(5);
		dllist.addFront(6);
		dllist.addFront(7);
		dllist.addLast(10);
		dllist.addLast(20);
		dllist.addLast(30);
		dllist.addLast(40);
		dllist.addLast(50);
		dllist.addLast(60);
		
		dllist.deleteAtFront();
		
		String expectedResult = "[6,5,4,3,2,10,20,30,40,50,60]";
		assertTrue(expectedResult.equals(dllist.toString()));
	}
	@Test
	public void testdeleteAtLast()
	{
		DoublyLinkedList<Integer> dllist = new DoublyLinkedList<Integer>();
		dllist.addFront(2);
		dllist.addFront(3);
		dllist.addFront(4);
		dllist.addFront(5);
		dllist.addFront(6);
		dllist.addFront(7);
		dllist.addLast(10);
		dllist.addLast(20);
		dllist.addLast(30);
		dllist.addLast(40);
		dllist.addLast(50);
		dllist.addLast(60);
		
		dllist.deleteAtLast();
		
		String expectedResult = "[7,6,5,4,3,2,10,20,30,40,50]";
		assertTrue(expectedResult.equals(dllist.toString()));
	}
	@Test
	public void testdeleteAtPosition()
	{
		DoublyLinkedList<Integer> dllist = new DoublyLinkedList<Integer>();
		dllist.addFront(2);
		dllist.addFront(3);
		dllist.addFront(4);
		dllist.addFront(5);
		dllist.addFront(6);
		dllist.addFront(7);
		dllist.addLast(10);
		dllist.addLast(20);
		dllist.addLast(30);
		dllist.addLast(40);
		dllist.addLast(50);
		dllist.addLast(60);
		
		dllist.deleteAtPosition(8);
		
		String expectedResult = "[7,6,5,4,3,2,10,20,40,50,60]";
		assertTrue(expectedResult.equals(dllist.toString()));
	}
	@Test
	public void testToStringBackWard()
	{
		DoublyLinkedList<Integer> dllist = new DoublyLinkedList<Integer>();
		dllist.addFront(2);
		dllist.addFront(3);
		dllist.addFront(4);
		dllist.addFront(5);
		dllist.addFront(6);
		dllist.addFront(7);
		dllist.addLast(10);
		dllist.addLast(20);
		dllist.addLast(30);
		dllist.addLast(40);
		dllist.addLast(50);
		dllist.addLast(60);
		
		String expectedResult = "[60,50,40,30,20,10,2,3,4,5,6,7]";
		assertTrue(expectedResult.equals(dllist.toStringBackWard()));
	}

}
