package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import sorting.bubblesort.BubbleSort;
import sorting.insertionsort.InsertionSort;
import sorting.selectionsort.SelectionSort;

public class SelectionSortTest {

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
	public void testSortingCorrecness() {
		InsertionSort insertionSort = new InsertionSort();
		BubbleSort bubbleSort = new BubbleSort();
		SelectionSort selectionSort = new SelectionSort();
		int length = 10;
		int a[] = generateArray(length);
		int b[] = new int[length];
		int c[] = new int[length];
		System.arraycopy(a, 0, b, 0, length);
		System.arraycopy(a, 0, c, 0, length);
		
		insertionSort.insertionSort(a);		
		bubbleSort.bubbleSort(b);
		selectionSort.selectionSort(c);
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		for(int i = 0; i < length; ++i)
		{
			assertTrue(a[i] == b[i] && b[i] == c[i]);
		}
	}

}
