package test;

import static org.junit.Assert.*;
import java.util.Random;

import org.junit.Test;

import sorting.bubblesort.BubbleSort;

public class BubbleSortTest {

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
	public void testRunningTime() {
		BubbleSort bubbleSort = new BubbleSort();
		int length = 1000;
		int a[] = generateArray(length);
		int b[] = new int[length];
		int c[] = new int[length];
		System.arraycopy(a, 0, b, 0, length);
		System.arraycopy(a, 0, c, 0, length);
		long t1 = System.nanoTime();
		bubbleSort.bubbleSort(a);
		long t2 = System.nanoTime();
		
		long time1 = t2-t1;
		
		t1 = System.nanoTime();
		bubbleSort.bubbleSortImprove1(b);
		t2 = System.nanoTime();
		
		long time2 = t2-t1;

		t1 = System.nanoTime();
		bubbleSort.bubbleSortImprove2(c);
		t2 = System.nanoTime();
		
		long time3 = t2-t1;
		
		assertTrue(time3 <= time1);
		assertTrue(time2 <= time1);
		
	}

}
