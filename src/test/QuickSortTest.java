package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import sorting.QuickSort;

public class QuickSortTest {

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
	public void testSortingCorrectness() {
		int length = 1000;
		int a[] = generateArray(length);
		int b[] = new int[length];
		int c[] = new int[length];
		
		System.arraycopy(a, 0, b, 0, length);
		System.arraycopy(a, 0, c, 0, length);
		
		QuickSort quickSort = new QuickSort();
		long t1 = System.nanoTime();
		quickSort.sort(a, QuickSort.MODE.LEFT);
		long t2 = System.nanoTime();
		long time1 = t2-t1;
		
		t1 = System.nanoTime();
		quickSort.sort(b, QuickSort.MODE.RIGHT);
		t2 = System.nanoTime();
		long time2 = t2-t1;
		
		t1 = System.nanoTime();
		quickSort.sort(c, QuickSort.MODE.MEDIAN);
		t2 = System.nanoTime();
		long time3 = t2-t1;
		
		for(int i = 0 ; i < length; ++i)
		{
			assertTrue(a[i] == b[i] && b[i] == c[i]);
		}
		assertTrue(time3 < time1);
		assertTrue(time3 < time2);
	}

}
