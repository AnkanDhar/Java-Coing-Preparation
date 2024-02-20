package streamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StudentClassProblem {
public static void main(String[] args) {
	List<Student> students = Arrays.asList(
			new Student(1, "Ankan", 28, "M", "CS",Arrays.asList("1234","5678")),
			new Student(2,"Bishal", 25, "M", "ME",Arrays.asList("6734","9845")),
			new Student(3,"Abhishree", 22, "F","CS",Arrays.asList("9087","6745")),
			new Student(4,"Deepak",29,"M","CE",Arrays.asList("3451","5673")),
			new Student(5,"Arpita",25,"F","CE",Arrays.asList("7865","8906")),
			new Student(5,"Ram",25,"M","ME",Arrays.asList("6748","2093"))
			);
	
	//Find the student whose age in between 20 and 27 : 
	List<String> strings = students.stream().filter(x-> x.getAge()>=20 && x.getAge()<27).map(x->x.getName()).collect(Collectors.toList());
	//System.out.println(strings); // Bishal, Abhishree, Arpita
	
	//Sort the students according to their name whose gender is "M" : 
	List<String> str=students.stream().filter(x-> x.getGender().equals("M")).map(Student::getName).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	List<Student> str1 = students.stream().filter(x->x.getGender().equals("M")).sorted(Comparator.comparing(Student::getName).reversed()).collect(Collectors.toList());
	List<Student> str2 = students.stream().filter(x->x.getGender().equals("M")).sorted(Comparator.comparing(Student::getName,Comparator.reverseOrder())).collect(Collectors.toList());
	//System.out.println(str); //Deepak, Bishal, Ankan
	//System.out.println(str1);
	//System.out.println(str2);
	
	//Find all the dept names :
	List<String> depts = students.stream().map(x-> x.getDept()).distinct().collect(Collectors.toList());
	//System.out.println(depts);
	
	//Find all numbers 
	/*One2One-> map, One2Many-> flatmap Basically, if we need to use map function on collection of object,  
	like List<>,set<>, Array[] etc then we use flatmap function */ 
	List<String> numbers = students.stream().flatMap(x->x.getNumbers().stream()).collect(Collectors.toList());
	//System.out.println(numbers);
	
	//Group the students by dept name
	Map<String,List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getDept));
	//System.out.println(map);
	
	List<String> map2 = students.stream().collect(Collectors.groupingBy(Student::getDept)).entrySet().stream()
						.map(x->x.getKey()+" : "+x.getValue().stream().map(s->s.getName()).collect(Collectors.toCollection(LinkedList::new)))
						.collect(Collectors.toList());
	//System.out.println(map2);
	
	Map<Integer, List<String>> map3 = students.stream().collect(Collectors.groupingBy(Student::getAge,Collectors.mapping(Student::getName,Collectors.toList())));
	System.out.println(map3);
	
	//Now we need to sort the above array on the basis of age.
	List<Entry<Integer, List<String>>> list = map3.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList());
	//System.out.println(list);
}
	
}
