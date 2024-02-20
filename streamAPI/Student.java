
import java.util.List;

public class Student {

	private long id;
	private String name;
	private int age;
	private String gender;
	private String dept;
	private List<String> numbers;
	
	//Getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<String> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", dept=" + dept
				+ ", numbers=" + numbers + "]";
	}
	//No agr Constructor
	public Student() {
		
	}
  //All args constructor
	public Student(long id, String name, int age, String gender, String dept, List<String> numbers) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dept = dept;
		this.numbers = numbers;
	}
  
}
