package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import sorting.BubbleSort;
import sorting.MergeSort;

public class MergeSortTest {

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
	public void testRunningTimeWithBubbleSort() {
		int length = 1000;
		int a[] = generateArray(length);
		int b[] = new int[length];
		System.arraycopy(a, 0, b, 0, length);
		
		MergeSort mergeSort = new MergeSort();
		BubbleSort bubbleSort = new BubbleSort();
		
		long t1 = System.nanoTime();
		mergeSort.mergeSort(a);
		long t2 = System.nanoTime();
		long time1 = t2-t1;
		
		t1 = System.nanoTime();
		bubbleSort.bubbleSort(b);
		t2 = System.nanoTime();
		long time2 = t2-t1;
		
		for(int i = 0; i < length; ++i)
		{
			assertTrue(a[i] == b[i]);
		}
		assertTrue(time1 < time2);
	}

}
