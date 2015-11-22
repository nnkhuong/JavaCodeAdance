package sorting;

public class SelectionSort {

	/*
	 * Thru i = 0 to length of array, i also is dining line
	 * Thru j = i to length, find the minimum position
	 * Swap i and minimum position
	 * Running time: O(n power of 2)
	 * In place: yes
	 * */
	public void selectionSort(int a[])
	{
		for(int i = 0; i < a.length; ++i)		// O(n)
		{
			int minPos = minPos(i, a);			// less than O(n)
			if(a[i] > a[minPos])
			{
				int temp = a[i];
				a[i] = a[minPos];
				a[minPos] = temp;
			}
		}
	}
	private int minPos(int i, int a[])
	{
		int min = a[i];
		int minPos = i;
		for(int j = i; j < a.length; ++j)
		{
			if(min > a[j])
			{
				min = a[j];
				minPos = j;
			}
		}
		return minPos;
	}
}
