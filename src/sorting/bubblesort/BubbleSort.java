package sorting.bubblesort;

public class BubbleSort {

	/* Sorting n element of array a
	 * Running time: O(n power of 2)
	 * In place: yes ( in-place means implement algorithm without taking temporary resource array)  
	 * */
	public void bubbleSort(int a[])
	{
		for(int i = 0; i < a.length; ++i)	// +O(n)
		{
			for(int j = 0; j < a.length-1; ++j) // +O(n)
			{
				if(a[j] > a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

	/* Improve bubble sort algorithm
	 * Used NOT_SORT flag (true/false) to cut the running time of outer loop, thus running time for outer loop less than O(n)
	 * Running time: less than O(n power of 2)
	 * In place: Yes
	 * */
	public void bubbleSortImprove1(int a[])
	{
		boolean NOT_SORT = true;
		while(NOT_SORT)								// less than O(n)
		{
			NOT_SORT = false;
			for(int i = 0; i < a.length-1; ++i)		// O(n)
			{
				if(a[i] > a[i+1])
				{
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					NOT_SORT = true;
				}
			}
		}
	}
	
	/*
	 * Improve mostly significant bubble sort algorithm
	 * Used NOT_SORT flag (true/false) to cut the running time of outer loop, thus running time this loop is less than O(n)
	 * and combine limitation length -j inner loop because large number already sort at the end of array. 
	 * Thus running time of inner loop is less than O(n)
	 * Running time: less than O(n power of 2) better than improvement 1
	 * In place: Yes
	 * */
	public void bubbleSortImprove2(int a[])
	{
		boolean NOT_SORT = true;
		int j = 1; // improvement
		while(NOT_SORT)						// less than O(n)
		{
			NOT_SORT = false;
			int range = a.length-j; // update range out of loop, because this operation will not count to inner loop running time
			for(int i = 0; i < range /*limited, cut down array for improving*/; ++i) // less than O(n)
			{
				if(a[i] > a[i+1])
				{
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					NOT_SORT = true;
				}
			}
			j++; // improvement
		}
		
	}

}
