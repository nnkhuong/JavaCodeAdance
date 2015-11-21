package sorting.insertionsort;


public class InsertionSort {
	
	/*Outer Loop from i = 1 to length. i is diving line, remove mark item, start shift at i
	 * Inner Loop from j=i down to 0 (and until one is smaller)
	 * Shift item right, go left one position
	 * Insert mark item 
	 * Running time: O(n power of 2)
	 * In place: yes
	 * */
	public void insertionSort(int a[])
	{
		// i is diving line
		for(int i = 1 ; i < a.length; ++i)		// O(n)
		{
			int temp = a[i]; // remove mark item
			int j = i ; // start shift at i
			while(j > 0 && temp < a[j-1]) // until mark item is smaller , less than O(n)
			{
				a[j] = a[j-1]; // shift item right
				--j; // go left position
			}
			a[j] = temp; // insert mark item
		}
	}
}
