package test;

import static org.junit.Assert.*;
import genericFunction.Generic;
import genericFunction.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.Iterator;

import org.junit.Test;

public class GenericTest {

	@Test
	public void testConditionalRemove() {
		ArrayList<String> listString = new ArrayList<String>() {
			{
				add("Hello"); add("Madam"); add("Goodbye"); add("see you tomorrow");
			}
		};
		ArrayList<String> listStringExpected = new ArrayList<String>() {
			{
				add("Goodbye"); add("see you tomorrow");
			}
		};
		final class stringLength5Condition implements Predicate<String> {

			@Override
			public boolean test(String s) {
				// TODO Auto-generated method stub
				return s.length() == 5;
			}
			
		}
		
		ArrayList<String> resultListString = (ArrayList<String>) Generic.conditionalRemove(listString, new stringLength5Condition());
		assertTrue(listStringExpected.size() == resultListString.size());
		Iterator<String> it1 = resultListString.iterator();
		Iterator<String> it2 = listStringExpected.iterator();
		while(it1.hasNext() && it2.hasNext() )
		{
			assertTrue(it1.next().equals(it2.next()));
		}
		
		final class stringContainKCondition implements Predicate<String> {

			@Override
			public boolean test(String s) {
				// TODO Auto-generated method stub
				return s.contains("k") || s.contains("K");
			}
			
		}
		
		ArrayList<String> list1 = new ArrayList<String>() {
			{
				add("This is"); add("a key"); add("member");
			}
		};
		ArrayList<String> list1Expected = new ArrayList<String>() {
			{
				add("This is"); add("member");
			}
		};
		ArrayList<String> list1Result = (ArrayList<String>) Generic.conditionalRemove(list1, new stringContainKCondition());
		
		assertTrue(list1Expected.size() == list1Result.size());
		it1 = list1Expected.iterator();
		it2 = list1Result.iterator();
		while(it1.hasNext() && it2.hasNext())
		{
			assertTrue(it1.next().equals(it2.next()));
		}
		
		ArrayList<Employee> listEmpl = new ArrayList<Employee>() {
			{
				add(new Employee("Josh", 100000)) ; add(new Employee("Paul", 200000)) ; add(new Employee("Peter", 50000));
			}
		};
		ArrayList<Employee> listEmplExpected = new ArrayList<Employee>() {
			{
				add(new Employee("Josh", 100000)) ; add(new Employee("Paul", 200000));
			}
		};
		final class EmployeeSalaryCondition implements Predicate<Employee> {

			@Override
			public boolean test(Employee e) {
				// TODO Auto-generated method stub
				return e.getSalary() < 60000;
			}
			
		}
		ArrayList<Employee> listEmplResult = (ArrayList<Employee>) Generic.conditionalRemove(listEmpl, new EmployeeSalaryCondition());
		assertTrue(listEmplExpected.size() == listEmplResult.size());
		Iterator<Employee> itEmpl1 = listEmplExpected.iterator();
		Iterator<Employee> itEmpl2 = listEmplResult.iterator();
		while(itEmpl1.hasNext() && itEmpl2.hasNext())
		{
			assertTrue(itEmpl1.next().compareTo(itEmpl2.next()) == 0);
		}
		
		ArrayList<Integer> listInt = new ArrayList<Integer>() {
			{
				add(20); add(30); add(40); add(100); add(110); add(120); add(130);
			}
		};
		ArrayList<Integer> listIntExpected = new ArrayList<Integer>() {
			{
				add(20); add(30); add(40); add(100);
			}
		};
		
		final class IntGreater100Condition implements Predicate<Integer>
		{

			@Override
			public boolean test(Integer Int) {
				// TODO Auto-generated method stub
				return Int > 100;
			}
			
		}
		ArrayList<Integer> listIntResult = (ArrayList<Integer>) Generic.conditionalRemove(listInt, new IntGreater100Condition());
		Iterator<Integer> it1Int = listIntExpected.iterator();
		Iterator<Integer> it2Int = listIntResult.iterator();
		assertTrue(listIntExpected.size() == listIntResult.size());
		while(it1Int.hasNext() && it2Int.hasNext())
		{
			assertTrue(it1Int.next() == it2Int.next());
		}
	}

	@Test
	public void testMerge()
	{
		List<Integer> list1 = Arrays.asList(2, 4, 6);
		List<Integer> list2 = Arrays.asList(3, 5, 6, 7);
		List<String> list3 = Arrays.asList("Alice", "Tom");
		List<String> list4 = Arrays.asList("Bob", "Richard");
		List<Double> list5 = Arrays.asList(2.3, 4.5);
		List<Number> list6 = Arrays.asList(2, 5);
		List<String> list7 = Arrays.asList("A", "XYZ", "AXTU");
		
		List<Employee> listEmpl = new ArrayList<Employee>() {
			{
				add(new Employee("Josh", 100000)) ; add(new Employee("Paul", 200000)) ; add(new Employee("Peter", 50000));
			}
		};
		
		List<?> list12Expected = Arrays.asList(2, 3, 4, 5, 6, 6, 7);
		List<?> list12Result = Generic.merge(list1, list2, Generic.compByInt2Int);
		Iterator<?> it12Expected = (Iterator<?>) list12Expected.iterator();
		Iterator<?> it12Result = (Iterator<?>) list12Result.iterator();
		assertTrue(list12Expected.size() == list12Result.size());
		while(it12Expected.hasNext() && it12Result.hasNext())
		{
			assertEquals( it12Expected.next(), it12Result.next() );
		}
		

		List<?> list34Expected = Arrays.asList("Alice", "Bob", "Richard", "Tom");
		List<?> list34Result = Generic.merge(list3, list4, Generic.compByStr2Str);
		Iterator<?> it34Expected = (Iterator<?>) list34Expected.iterator();
		Iterator<?> it34Result = (Iterator<?>) list34Result.iterator();
		assertTrue(list34Expected.size() == list34Result.size());
		while(it34Expected.hasNext() && it34Result.hasNext())
		{
			assertTrue( it34Expected.next().equals(it34Result.next()) );
		}

		List<?> list56Expected = Arrays.asList(2, 2.3, 4.5, 5);
		List<?> list56Result = Generic.merge(list5, list6, Generic.compByDouble2Number);
		Iterator<?> it56Expected = (Iterator<?>) list56Expected.iterator();
		Iterator<?> it56Result = (Iterator<?>) list56Result.iterator();
		assertTrue(list56Expected.size() == list56Result.size());
		while(it56Expected.hasNext() && it56Result.hasNext())
		{
			assertTrue( it56Expected.next().equals(it56Result.next()) );
		}
		
		List<?> list17Expected = Arrays.asList("A", 2, "XYZ", "AXTU", 4, 6);
		List<?> list17Result = Generic.merge(list1, list7, Generic.compByInt2Str);
		Iterator<?> it17Expected = (Iterator<?>) list17Expected.iterator();
		Iterator<?> it17Result = (Iterator<?>) list17Result.iterator();
		assertTrue(list17Expected.size() == list17Result.size());
		while(it17Expected.hasNext() && it17Result.hasNext())
		{
			assertTrue( it17Expected.next().equals(it17Result.next()) );
		}

		List<?> list3EmployeeExpected = Arrays.asList("Alice", new Employee("Josh", 100000), new Employee("Paul", 200000),
				new Employee("Peter", 50000), "Tom");
		
		List<?> list3EmployeeResult = Generic.merge(list3, listEmpl, Generic.compByStringEmployee);
		Iterator<?> it3EmployeeExpected = (Iterator<?>) list3EmployeeExpected.iterator();
		Iterator<?> it3EmployeeResult = (Iterator<?>) list3EmployeeResult.iterator();
		assertTrue(list3EmployeeExpected.size() == list3EmployeeResult.size());
		while(it3EmployeeExpected.hasNext() && it3EmployeeResult.hasNext())
		{
			assertTrue( it3EmployeeExpected.next().equals(it3EmployeeResult.next()) );
		}		
	}

	


}
