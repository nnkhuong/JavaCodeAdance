package genericFunction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;



public class Generic {

	/*
	 * Write the most general possible version of this method.
	 * - the method conditionalRemove, which removes from an ArrayList of Strings all those Strings
	 * that have length exactly equal to 5
	 * - Things to generalize:
		1. From String to the most general type possible
		2. From the Predicate type shown in the sample code to the most general type of Predicate
		(you may need to include a Predicate as a second argument to your conditionalRemove method)
		In a main method, show that your conditionalRemove is capable of
			A. Removing all Strings in an ArrayList of Strings in which the letter ‘k’ occurs
			B. Removing all Employees in an ArrayList of Employees whose salary is < 60,000
			C. Remove all Integers in an ArrayList of Integers which are greater than 100
	 * */
	
	public static <T> List<T> conditionalRemove(ArrayList<T> list, Predicate<T> byCond) {
		
		ArrayList<T> removed = new ArrayList<T>();
		for (T s : list) {
			if (! byCond.test(s)) {
				removed.add(s);
			}
		}
		list =  removed;
		return list;
	}
	
	/*
	 * A merge function is a function that merges two sorted lists into a single sorted list.
	Example: Merging the lists [2, 4, 6], [3, 5, 6, 7] produces [2, 3, 4, 5, 6, 6, 7]
	Example: Merging the lists [“Alice”, “Tom”], [“Bob”, “Richard”] produces [“Alice”, “Bob”, “Richard”, “Tom”]
	Example: Merging the lists [2.3, 4.5], [2,5] produces [2, 2.3, 4.5, 5]
	Example: Merging the lists [“A”, “XYZ”, “AXTU”] and [2, 4, 6] (where the first list is sorted by word length, 
	and in the merge operation, if a string length in the first list is the same as a number in the second list, 
	the string comes first) produces [“A”, 2, “XYZ”, “AXTU”, 4, 6].
	Implement the most general possible merge function, assuming that input lists are in sorted order 
	(according to a natural or a specified ordering). Your merge method should be flexible enough to correctly merge the lists shown 
	in the examples above, and much more. Carry out your implementation in the class Merge that has been provided. The main method 
	includes the data shown in the examples. Fill out the main method further by using this data to validate your implementation
	*/
	public static <T, S> List<?> merge(List<T> list1, List<S> list2, BiComparator<T, S> comp) 
	{
		List<Object> result = new ArrayList<>(list1.size() + list2.size());

		// here the logic is a little complex, dont' want to use list1.get(index) because of performance
		Iterator<T> it1 = list1.iterator();
		Iterator<S> it2 = list2.iterator();
		boolean it1HasNext = it1.hasNext();
		boolean it2HasNext = it2.hasNext();
		
		T value1 = (T)null;
		S value2 = (S)null;
		if(it1HasNext)
			value1 = it1.next();
		if(it2HasNext)
			value2 = it2.next();
		
		while(it1HasNext && it2HasNext)
		{
			if(comp.compare(value1, value2) <= 0)
			{
				result.add(value1);
				it1HasNext = it1.hasNext();
				if(it1HasNext)
					value1 = it1.next();
			}
			else
			{
				result.add(value2);
				it2HasNext = it2.hasNext();
				if(it2HasNext)
					value2 = it2.next();
			}
			
		}
		if(it1HasNext && value1 != null)
			result.add(value1);
		if(it2HasNext && value2 != null)
			result.add(value2);
		while(it1.hasNext())
			result.add(it1.next());
		while(it2.hasNext())
			result.add(it2.next());
		
		return result;
	}

	private interface BiComparator<T, S>
	{
		public int compare(T t, S s);
	}

	public static final BiComparator<Integer, Integer> compByInt2Int = new BiComparator<Integer, Integer>() {
		
		@Override
		public int compare(Integer o1Int, Integer o2Int) {
			
			return o1Int - o2Int;
		}
	};
	
	public static final BiComparator<Integer, String> compByInt2Str = new BiComparator<Integer, String>() {

		@Override
		public int compare(Integer t, String s) {
			// TODO Auto-generated method stub
			if(t >= s.length())
				return 1;
			return -1;
		}
		
	};
	
	public static final BiComparator<String, Integer> compByStr2Int = new BiComparator<String, Integer>() {

		@Override
		public int compare(String t, Integer s) {
			// TODO Auto-generated method stub
			if(t.length() > s)
				return 1;
			return -1;
		}
		
	};
	
	public static final BiComparator<String, String> compByStr2Str = new BiComparator<String, String>() {

		@Override
		public int compare(String s1, String s2) {
			// TODO Auto-generated method stub
			
			return s1.compareTo(s2);
		}
		
	};
	public static final BiComparator<Double, Number> compByDouble2Number = new BiComparator<Double, Number>() {
		
		@Override
		public int compare(Double o1Double, Number o2Number) {
			
			return o1Double.compareTo(o2Number.doubleValue());
		}
	};
	
	public static final BiComparator<String, Employee> compByStringEmployee = new BiComparator<String, Employee>() {
		
		@Override
		public int compare(String s, Employee e) {
			return s.compareTo(e.getName());
		}
	};
	
}
