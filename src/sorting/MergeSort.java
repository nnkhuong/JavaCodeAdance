package sorting;

public class MergeSort {
	
	private int store[];
	/*
	 * Divide array into 2 sub array and conquer
	 * Running time: O(nlogn)
	 * In place: no
	 * */
	public void mergeSort(int a[])
	{
		store = new int[a.length]; // not in place because of using temporary resource
		sort(a, 0, a.length-1);
	}
	private void sort(int a[], int startIndex, int endIndex)
	{
		if(startIndex == endIndex)
		{
			return;
		}
		
		// split 2 sub array
		int midIndex = (startIndex+endIndex)/2;
		sort(a, startIndex, midIndex);
		sort(a, midIndex+1, endIndex);
		merge(a, startIndex, midIndex,midIndex+1, endIndex);
	}
	private void merge(int a[], int startIndex, int midIndex, int midIndex_1, int endIndex)
	{
		int[] a1 = new int[midIndex-startIndex+1];
		System.arraycopy(a, startIndex, a1, 0, a1.length);
		int[] a2 = new int[endIndex-midIndex_1+1];
		System.arraycopy(a, midIndex_1, a2, 0, a2.length);
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < a1.length && j < a2.length)
		{
			if(a1[i] < a2[j])
			{
				store[k++] = a1[i++];
			}
			else
			{
				store[k++] = a2[j++];
			}
		}
		while(i < a1.length)
		{
			store[k++] = a1[i++];
		}
		while(j < a2.length)
		{
			store[k++] = a2[j++];
		}
		// the step is very importance
		//now k is total number of elements to rearrange
		//replace the range [startIndex,endIndex]= k in a array with 
		//the range [0,n-1] just created in storage
		for(i = 0; i <k ; ++i)
		{
			a[startIndex+i] = store[i];
		}

	}
}
