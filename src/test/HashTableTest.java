package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dataStructure.HashTable.HashTable;

public class HashTableTest {

	@Test
	public void testPut() {
		
		HashTable hashTable = new HashTable();
		hashTable.put(10, 1);
		hashTable.put(20, 2);
		hashTable.put(20, 7);// override value because of key duplication
		
		assertEquals(2, hashTable.size());
	}
	@Test
	public void testGett() {
		
		HashTable hashTable = new HashTable();
		hashTable.put(10, 1);
		hashTable.put(40, 2);
		
		assertEquals(2, hashTable.get(40));
	}
	@Test
	public void testRemoveWithKey() {
		
		HashTable hashTable = new HashTable();
		hashTable.put(10, 1);
		hashTable.put(40, 2);
		hashTable.put(70, 8);
		
		assertTrue(hashTable.remove(10));
		assertEquals(2, hashTable.size());
	}
	@Test
	public void testRemoveWithKeyAndValue() {
		
		HashTable hashTable = new HashTable();
		hashTable.put(10, 1);
		hashTable.put(40, 2);
		hashTable.put(70, 8);
		
		assertFalse(hashTable.remove(10,3));
		assertTrue(hashTable.remove(10,1));
		assertEquals(2, hashTable.size());
	}
	@Test
	public void testRemoveAll() {
		
		HashTable hashTable = new HashTable();
		hashTable.put(10, 1);
		hashTable.put(40, 2);
		hashTable.put(70, 8);
		
		hashTable.removeAll();
		assertEquals(0, hashTable.size());
	}
}
