
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class NthHighestSalary {
	
public static void main(String[] args) {
	//Without duplicate value
	Map<String, Integer> salaryMap = new HashMap<>();
	salaryMap.put("Ankan",1000);
	salaryMap.put("Bishal", 1200);
	salaryMap.put("Robin", 800);
	salaryMap.put("Vinod", 600);
	salaryMap.put("Pradeep", 1500);
	
	//With Duplicate value
	Map<String, Integer> salaryMap2 = new HashMap<>();
	salaryMap2.put("Ankan",1000);
	salaryMap2.put("Bishal", 1200);
	salaryMap2.put("Robin", 1200);
	salaryMap2.put("Vinod", 600);
	salaryMap2.put("Pradeep", 1500);
	salaryMap2.put("Abhishek", 600);
	
	//Second highest salary  
	 //System.out.println(getNthHighestSalary(2, salaryMap));
	
	System.out.println(getNthHighestSalary1(2, salaryMap2));

	
	 
}

//If duplicate data is not there
public static Entry<String, Integer> getNthHighestSalary(int n, Map<String, Integer> salaryMap){
	Entry<String, Integer> nthHighestsalary = salaryMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toCollection(LinkedList::new)).get(n-1);
	return nthHighestsalary;
}

//If duplicate data is present
public static Entry<Integer, List<String>> getNthHighestSalary1(int n, Map<String, Integer> salaryMap){
	
	Map<Integer, List<String>> newMap = salaryMap.entrySet().stream().collect(
			Collectors.groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey, Collectors.toList())
			));
	//System.out.println(newMap);
	//Now we need to sort the map in reverse order and get secondHighestSalary
	Entry<Integer, List<String>> nthHighestSalary = newMap.entrySet().stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(n-1);
	return nthHighestSalary;
}

}
