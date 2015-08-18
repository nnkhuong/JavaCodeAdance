package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class LambdaLibrary {
	
	static Function<int[], Integer> FIND_MAX =  arrayInt -> 
		IntStream.of(arrayInt)
		.map(x->x).max().getAsInt();
			
	static Function<List<Integer>, Integer> SUM_EVEN_STREAM = list -> 
		list.stream().filter(x -> x%2 == 0).reduce(0, (a,b) -> a+b);
		
	static Function<List<Integer>, Long> COUNT_EVEN_STREAM = list -> 
		list.stream().filter(x -> x%2 == 0).map(x->x).count();
		
	static Function<List<Integer>, Long> COUNT_PRIEMS = list -> 
		list.stream().filter(x -> (x < 2) ? false : IntStream.rangeClosed(2, x/2).noneMatch( i -> x%i == 0)).map(x->x).count();
		
	static Function<List<Integer>, Integer> COUNT_PRIEMS_MAX = list ->
		list.stream().filter(x -> (x< 2) ? false : IntStream.rangeClosed(2, x/2).noneMatch( i -> x%i == 0)).map(x->x).max(Integer::compare).get();
		
	static BiFunction<List<Integer>, Integer, Integer> SUM_WITH_COND = (list, x) ->
		list.stream().filter(e -> e > x).reduce(0, (a,b) -> a+b);
	
	static BiFunction<List<Integer>, Integer, Long> COUNT_WITHCOND = (list, x) ->
		list.stream().filter(e -> e>x).map(e->e).count();
		
	static Function<int[], Integer> SUM_OF_SQUARE = arrayInt ->
		IntStream.of(arrayInt)
		.map(x->x).reduce(0, (a,b) -> a + b*b);
	
	static Function<int[], int[]> EVEN_NUM = arrayInt -> 
		IntStream.of(arrayInt)
		.map(integer -> integer)
		.filter(integer -> integer % 2 == 0)
		.toArray();
	
	static Function<Integer , Integer>  SUM_DIGIT= integer -> {
		String str = integer+"";
		Integer sum = IntStream.iterate(0, i-> i+1).limit(str.length())
		.map(x-> Character.getNumericValue(str.charAt(x))).reduce(0, (a,b) -> a+b);
		
		return sum;
	};
	
	// Obtain sublist in reverse-sorted order of all integers
	// greater than 25(x), sum of whose digits mod 9(y) is less than 5(z)
	static QuadFunction<List<Integer> , Integer, Integer, Integer, List<Integer> > DIGIT = (list, x, y, z) ->
		list.stream()
		.filter(integer -> integer > x && SUM_DIGIT.apply(integer) % y < z)
		.sorted()
		.collect(Collectors.toList());
	
	static BiFunction<List<Integer>, String, Long> COUNT_OCCUR = (list, str) -> {
		int elements = str.split(",").length;
		Long count = Stream
				.iterate(0, i -> i + 1)
				.limit(list.size() - elements)
				.map(i -> list.subList(i, i + elements))
				.filter(x -> x.toString().replaceAll(" ", "")
						.equals("[" + str + "]")).count();
		return count;
	};
	
		
	static BiFunction<List<Integer>, int[], Long> COUNT_OCCUR_SUBARRAY = (list, array) -> {
		int elements = array.length;
		String str = Arrays.toString(array);
		System.out.println(str);
		Long count = Stream
				.iterate(0, i -> i + 1)
				.limit(list.size() - elements)
				.map(i -> list.subList(i, i + elements))
				.filter(x -> x.toString().equals(str)).count();
				
		return count;
	};
	
	// For Employee section
	// Get all Employee records for which name has length > 5 and birth
	// year is > 1970
	static TriFunction<List<Employee>, Integer, Integer, List<Employee>> SAMPLE = (list, lenOfName, birhtOfDay) -> 
		list.stream().filter(E -> E.getName().length() > lenOfName && E.getYearOfBirth() > birhtOfDay)
		.collect(Collectors.toList());
	
	// Find all name/salary pairs extracted from a list of Employees
	// for which salary > 55000 and less than 120000, in ascending
	// order of name, then descending order of salary
	static TriFunction<List<Employee>, Integer, Integer, List<Employee>> EMP_SORT = (list, salaryMin, salaryMax) ->
		list.stream().filter(e -> e.getSalary() >= salaryMin && e.getSalary() <= salaryMax)
		.sorted(Comparator.comparing(Employee::getName).thenComparing(E -> - E.getSalary()))
		.collect(Collectors.toList());
	
	// Find all transactions from year 2011 and sort them by value (small to high).
	static BiFunction<List<Transaction> , Integer, List<Transaction> > TRANS = (list, year) ->
	list.stream().filter(t -> t.getYear() == year).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

	// Find all traders from Cambridge and sort them by name.
	static BiFunction<List<Transaction>, String, List<Transaction>> TRADER = (list, name) ->
		list.stream().filter(t -> t.getTrader().getName().equals(name))
		.sorted(Comparator.comparing(t -> t.getTrader().getCity())).collect(Collectors.toList());
		
	// user Stream with Generic Function
	public static <T> int countOccurence(T array[], T tag)
	{
		int count = 0 ;
		count = (int)Stream.of(array).filter(E -> E.equals(tag)).count();
		return count;
	}
}
