
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringProblem {
public static void main(String[] args) {
	String str = "I am Ankan Dhar";
	
	//find the first non-repeated character
			String firstNonRepetedChar = Arrays.stream(str.toLowerCase().split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,Collectors.counting()))
					.entrySet().stream().filter(x->x.getValue()==1 && !x.getKey().equals(" ")).map(x->x.getKey()).findFirst().get();
			System.out.println("First Non repeted char : "+firstNonRepetedChar);
			
	//find First repeated Character 		
			String firstRepeatedChar = Arrays.stream(str.toLowerCase().split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
					.entrySet().stream().filter(x -> x.getValue()>1 && !x.getKey().equals(" ")).map(x ->x.getKey()).findFirst().get();
			System.out.println("First repeated Character : "+firstRepeatedChar);
			
	//find only duplicate elements with its count from the String
			Arrays.stream(str.toLowerCase().split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
					.entrySet().stream().filter(x -> x.getValue()>1 && !x.getKey().equals(" ")).forEach(x-> System.out.println(x.getKey()+" : "+x.getValue()));	
	
	
	
}
}
