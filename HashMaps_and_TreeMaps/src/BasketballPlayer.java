
public class BasketballPlayer implements Comparable<BasketballPlayer>{
	private String name;
	private Integer uniformNumber;
	private String position;
	private Integer age;
	private String height;
	private Integer heighT;
	private Integer weight;
	private String university;
	private String salary;
	private Integer Salary;
	private String team;
	BasketballPlayer(Integer uniformNumber, String name, String position, Integer age, String height, Integer weight, String university, String salary, String team){
		this.name = name;
		this.uniformNumber = uniformNumber;
		this.position = position;
		this.age = age;
		this.height = height;
		heighT = heightConvert(height);
		this.weight = weight; 
		this.university = university;
		this.salary = salary;
		Salary = salaryConvert(salary);
		this.team = team;
		
	}
	
	public Integer getUniformNumber(){
		return uniformNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPosition() {
		return position;
	}
	
	public Integer getAge() {
		return age;
	}
	public Integer getHeight() {
		return heighT;
	}
	public Integer getWeight() {
		return weight;
	}
	public String getUni() {
		return university;
	}
	
	public Integer getSalary() {
		return Salary;
	}
	public String getTeam() {
		return team;
	}
	
	
	public Integer heightConvert(String x) {
		return Integer.parseInt(x.substring(0, 1)) * 12 + Integer.parseInt(x.substring(2));
	}
	
	public Integer salaryConvert(String x) {	
		return Integer.parseInt(x.replaceAll("[^\\d.]", ""));
	}

	@Override
	public int compareTo(BasketballPlayer o) {
	
		if(!position.equals(o.getPosition())) {
			return position.compareTo(o.getPosition());
		}
		else if(heighT != o.getHeight()) {
			return heighT.compareTo(o.getHeight());
			
		}
		else if(weight != o.getWeight()) {
			return weight.compareTo(o.getWeight());
			
		}
		else if(uniformNumber != o.getUniformNumber()) {
			return uniformNumber.compareTo(o.getUniformNumber());
			
		}
		else if(Salary != o.getSalary()) {
			return Salary.compareTo(o.getSalary());
			
		}
		else if(!university.equals(o.getUni())) {
			return university.compareTo(o.getUni());
		}
		else {
			return age.compareTo(o.getAge());
		}

	}
	
	public String toString() {
		return "( " + name + " )"; 
	}
}
