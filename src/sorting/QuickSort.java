package sorting;

public class QuickSort {
	
	public static enum MODE
	{
		LEFT, RIGHT, MEDIAN
	}
	public void sort(int a[], MODE mode)
	{
		switch(mode)
		{
			case LEFT:
				sortWithLeftPivot(a, 0, a.length-1);
				break;
				
			case RIGHT:
				sortWithRightPivot(a, 0, a.length-1);
				break;

			case MEDIAN:
				sortWithMedianPivot(a, 0, a.length-1);
				break;
				
			default:
				break;
		}
	}
	/*
	 * Divide and conquer array
	 * pivot = a[left]
	 * i starts from left position and increment by 1 if a[i] < pivot
	 * j starts from right position and decrement by 1 if a[j] > pivot
	 * swap a[i] and a[j] when i < j
	 * Running time: O(nlogn)
	 * Worst case : O(n power of 2) if smallest or largest always happens at left most
	 * Pivot is selected at left pivot
	 * */
	public void sortWithLeftPivot(int a[], int left, int right)
	{
		int i = left, j = right, pivot = a[left];
		while(i < j)
		{
			while(i < right && a[i] < pivot)
				++i;
			while(j > left && a[j] > pivot)
				--j;
			
			if(i <= j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				++i;
				--j;
			}
		}
		if(j > left)
			sortWithLeftPivot(a, left, j);
		if(i < right)
			sortWithLeftPivot(a, i, right);
	}
	
	/*
	 * Divide and conquer array
	 * pivot = a[right]
	 * i starts from left position and increment by 1 if a[i] < pivot
	 * j starts from right position and decrement by 1 if a[j] > pivot
	 * swap a[i] and a[j] when i < j
	 * Running time: O(nlogn)
	 * Worst case : O(n power of 2) if smallest or largest always happens at right most
	 * Pivot is selected at right pivot
	 * */
	public void sortWithRightPivot(int a[], int left, int right)
	{
		int i = left, j = right, pivot = a[right];
		while(i < j)
		{
			while(i < right && a[i] < pivot)
				++i;
			while(j > left && a[j] > pivot)
				--j;
			
			if(i <= j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				++i;
				--j;
			}
		}
		if(j > left)
			sortWithLeftPivot(a, left, j);
		if(i < right)
			sortWithLeftPivot(a, i, right);
		
	}
	
	/* 
	 * Divide and conquer array
	 * pivot = median
	 * i starts from left position and increment by 1 if a[i] < pivot
	 * j starts from right position and decrement by 1 if a[j] > pivot
	 * swap a[i] and a[j] when i < j
	 * Running time: O(nlogn)
	 * Worst case : avoid most significant smallest/largest happens at leftmost/rightmost, improving running time
	 * Pivot is selected by median of (left, center, right) 
	 * example: left = 44, right = 60, center = 15. Thus pivot = 44
	 * */
	public void sortWithMedianPivot(int a[], int left, int right)
	{
		int mid = (left+right)/2;
		int max = (max(max(a[left], a[mid]), a[right]));
		int min = (min(min(a[left], a[mid]), a[right]));
		
		int i = left, j = right, pivot = (a[left] + a[mid] + a[right]) - max - min;
		
		while(i < j)
		{
			while(i < right && a[i] < pivot)
				++i;
			while(j > left && a[j] > pivot)
				--j;
			
			if(i <= j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				++i;
				--j;
			}
		}
		if(j > left)
			sortWithLeftPivot(a, left, j);
		if(i < right)
			sortWithLeftPivot(a, i, right);		
	}
	private int min(int a, int b)
	{
		return (a < b) ? a : b;
	}
	private int max(int a, int b)
	{
		return (a > b) ? a : b;
	}
}
