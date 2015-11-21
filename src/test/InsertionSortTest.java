package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import sorting.bubblesort.BubbleSort;
import sorting.insertionsort.InsertionSort;

public class InsertionSortTest {

	int[] generateArray(int length)
	{
		int a[] = new int[length];
		Random random = new Random();
		for(int i = 0 ; i < length ; ++i)
		{
			a[i] = random.nextInt(Integer.MAX_VALUE);
		}
		return a;
	}
	@Test
	public void testSortingCorrestness() {
		InsertionSort insertionSort = new InsertionSort();
		BubbleSort bubbleSort = new BubbleSort();
		int length = 1000;
		int a[] = generateArray(length);
		int b[] = new int[length];
		int c[] = new int[length];
		int d[] = new int[length];
		System.arraycopy(a, 0, b, 0, length);
		System.arraycopy(a, 0, c, 0, length);
		System.arraycopy(a, 0, d, 0, length);
		
		insertionSort.insertionSort(a);		
		bubbleSort.bubbleSort(b);
		bubbleSort.bubbleSortImprove1(c);
		bubbleSort.bubbleSortImprove2(d);
		
		for(int i = 0; i < length; ++i)
		{
			assertTrue(a[i] == b[i] && b[i] == c[i] && c[i] == d[i]);
		}
	}

}
