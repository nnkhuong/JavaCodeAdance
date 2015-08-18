package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();
		// Print all Employee records for which name has length > 5 and birth
		// year is > 1970
		System.out.println(LambdaLibrary.SAMPLE.apply(sampleData, 5, 1970));

		System.out.println("\nQuery 1");
		int[] testItem1 = { 1, -1, 2, 3, -17, 24, 4 * 12, 58 - 16 };
		// Compute maximum value of an array of integers
		System.out.println(LambdaLibrary.FIND_MAX.apply(testItem1));

		System.out.println("\nQuery 2");
		int[] testItem2 = { -1, -3, 5, 11, 213 };
		// Compute sum of squares of an input array of integers
		System.out.println(LambdaLibrary.SUM_OF_SQUARE.apply(testItem2));

		System.out.println("\nQuery 3");
		int[] testItem3 = { -351, 2342, 46 * 23, 17 * 17, 15 * 14, 4002, 12 };
		// Extract sub-array of even integers from an array of integers
		System.out.println(Arrays.toString(LambdaLibrary.EVEN_NUM.apply(testItem3)));

		System.out.println("\nQuery 4");
		// Obtain sublist in reverse-sorted order of all integers
		// greater than 25, sum of whose digits mod 9 is less than 5
		List<Integer> testItem4 = new ArrayList<Integer>() {
			{
				add(53);
				add(75);
				add(20);
				add(13);
				add(44);
				add(201);
				add(-512);
				add(402);
				add(21);
				add(55);
				add(76);
				add(11);
				add(33);
			}
		};
		System.out.println(LambdaLibrary.DIGIT.apply(testItem4,25, 9, 5));
		
		System.out.println("\nQuery 5");
		List<Integer> testItem5 = Arrays.asList(3, 5, 4, 5, 3, 4, 5, 3, 3, 3, 0, 3, 5, 3, 4, 5, 3, 4, 3, 4, 5, 3, 4, 5);
		// Compute num occurrences of sequence 3, 4, 5 in input list
		System.out.println(LambdaLibrary.COUNT_OCCUR.apply(testItem5, "3,4,5"));
		int array[] = {3,4,5};
		System.out.println(LambdaLibrary.COUNT_OCCUR_SUBARRAY.apply(testItem5, array));
				
		System.out.println("\nQuery 6");
		List<Employee> testItem6 = EmployeeTestData.getList();
		// Find all name/salary pairs extracted from a list of Employees
		// for which salary > 55000 and less than 120000, in ascending
		// order of name, then descending order of salary
		System.out.println(LambdaLibrary.EMP_SORT.apply(testItem6, 55000, 120000));

		System.out.println("\nQuery 7");
		// Find all transactions from year 2011 and sort them by value (small to
		// high).
		List<Transaction> testItem7 = TraderTransactTestData.getTransactions();
		System.out.println(LambdaLibrary.TRANS.apply(testItem7, 2011));

		System.out.println("\nQuery 8");
		// Find all traders from Cambridge and sort them by name.
		List<Transaction> testItem8 = testItem7;
		System.out.println(LambdaLibrary.TRADER.apply(testItem8, "Cambridge"));
		
		Employee[] arrayEmployee = {new Employee("khuong"), new Employee("Dung"), 
				new Employee("Dung"), new Employee("khuong"), new Employee("khuong") } ;
		
		Employee testEmployee = new Employee("khuong");
		System.out.println("Employee Khuong occurence :" + LambdaLibrary.countOccurence(arrayEmployee, testEmployee));


	}
}