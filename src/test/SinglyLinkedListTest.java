package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dataStructure.SinglyLinkedList.SinglyLinkedList;

public class SinglyLinkedListTest {

	@Test
	public void testAddHead() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.addAtHead(20);
		sll.addAtHead(30);
		sll.addAtHead(40);
		sll.addAtHead(50);
		sll.addAtHead(60);
		
		String expectedResult = "[60,50,40,30,20]";
		assertTrue(expectedResult.equals(sll.toString()));
	}

}
