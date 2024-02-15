
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayProblem {

	public static void main(String[] args) {
		int [] arr = {10,12,50,25,43,76,13,12,43,76};  //12,43
		int [] arr2 = {100,300,450,123,432,987,456,908};
		String str = "Ankan Dhar  ";

		//find all the even numbers
		List<Integer> even = Arrays.stream(arr).boxed().filter(x->x%2==0).collect(Collectors.toList());
		System.out.println("Even numbers of the array : "+even);
		 
		//Numbers starting with one
		List<String> nums = Arrays.stream(arr).boxed().map(x-> x+"").filter(x-> x.startsWith("1")).collect(Collectors.toList());
		System.out.println("Numbers starting with 1 in the array : "+nums);
		
		//Find duplicate element in the array
		List<Integer> duplicates = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
			.entrySet().stream().filter(x->x.getValue()>1).map(x->x.getKey()).collect(Collectors.toList());
		System.out.println("Duplicate elements of the array : "+duplicates);
		
		//Remove duplicate element from an array
		List<Integer> unique = Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder()).distinct().collect(Collectors.toList());
		System.out.println("Array after removing duplicate elements : "+unique);
		
		// Find second highest and lowest number of an array
		Integer secondHighest = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).distinct().skip(1).findAny().get();
		System.out.println("Second Highest element of the array : "+secondHighest);
		
		Integer secondLowest = Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder()).distinct().skip(1).findFirst().get();
		System.out.println("Second Lowest element of the array : "+secondLowest);
		
		 //Find the total number of elements of an array
		 long count = Arrays.stream(arr).count();
		 System.out.println("total number of elements in the array : "+count);
		 
		 //Maximum element of the array:
		 int highestElement = Arrays.stream(arr).max().getAsInt();
		 System.out.println("Highest element of the array : "+highestElement);
		 
		 int minimumElement = Arrays.stream(arr).min().getAsInt();
		 System.out.println("Minimum element of the array : "+minimumElement);
		 
		 //perform cube on list elements and filter numbers greater than 5000
		 List<Integer> cubes  = Arrays.stream(arr).boxed().map(x-> x*x*x).filter(x-> x>5000).collect(Collectors.toList());
		 System.out.println("Cubes which are grater than 5000: "+cubes);
		 
		 //Concate two array and sort it and print distinct element :
		List<Integer> list = IntStream.concat(Arrays.stream(arr),Arrays.stream(arr2)).boxed().sorted(Comparator.naturalOrder()).distinct().collect(Collectors.toList());
		System.out.println("Concatinated list is : "+list);
	}
}
