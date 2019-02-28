import java.util.Arrays;
import java.util.Collections;

public class Bowler implements Comparable<Bowler>{
	private String lastName;
	private String firstName;
	private int score;
	Bowler(String lastName, String firstName, int score){
		this.lastName = lastName;
		this.firstName = firstName;
		this.score = score;
	}
	@Override
	public int compareTo(Bowler o) {
		String[] str = new String[2];
		if(!lastName.toLowerCase().equals(o.getLastName().toLowerCase())) {
			return -1 * lastName.toLowerCase().compareTo(o.getLastName().toLowerCase());
		}
		else {
			return -1 * firstName.toLowerCase().compareTo(o.getFirstName().toLowerCase());
		}
		
		
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public int getScore() {
		return score;
	}
	
	public String toString() {
		return "| " + lastName + ", " + firstName + " |";
	}
}
