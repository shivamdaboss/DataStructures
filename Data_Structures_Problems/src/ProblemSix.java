import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProblemSix {
	ProblemSix(String name){
		String text;
		
		ArrayList<String> info = new ArrayList<String>();
		ArrayList<Integer> infoTwo = new ArrayList<Integer>();
		int start = 0;
		int goldenIndex = 0;
		File file = new File(name);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while((text = reader.readLine()) != null) {
				info.addAll(Arrays.asList(text.split(" ")));
				for(int i = 0; i < info.size(); i++) {
					infoTwo.add(Integer.parseInt(info.get(i)));
				}

				start = infoTwo.get(1);
				if(infoTwo.get(0) == 1) {
					//leap year
					goldenIndex = engine(infoTwo.get(2), infoTwo.get(3), infoTwo.get(0));
					for(int i = 0; i < goldenIndex - 1; i++) {
						start++;
						if(start == 8) {
							start = 1;
						}
					}
					
				}
				else {
					//regular year
					goldenIndex = engine(infoTwo.get(2), infoTwo.get(3), infoTwo.get(0));
					for(int i = 0; i < goldenIndex - 1; i++) {
						start++;
						if(start == 8) {
							start = 1;
						}
					}
				}
				System.out.print(text + " ");
				switch(start) {
					case 1: 
						System.out.println("Sunday");
						break;
					case 2: 
						System.out.println("Monday");
						break;
					case 3: 
						System.out.println("Tuesday");
						break;
					case 4: 
						System.out.println("Wednesday");
						break;
					case 5: 
						System.out.println("Thursday");
						break;
					case 6: 
						System.out.println("Friday");
						break;	
					case 7: 
						System.out.println("Saturday");
						break;
					
				}
				info.clear();
				infoTwo.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int engine(int month, int day, int leap) {
		int answer = 0;
		switch(month) {
			case 1:
				answer = day; // January
				break;
			case 2:
				answer =  31 + day; // Feb
				break;
			case 3:
				answer =  31 + 29+ day; //March 
				break;
			case 4: 
				answer =  31 + 29 + 31 + day;//April
				break;
			case 5: 
				answer =  31 + 29 + 31 + 30 + day;//May
				break;
			case 6:
				answer =  31 + 29  + 31 + 30 + 31 + day;//June
				break;
			case 7:
				answer =  31 + 29 + 31 + 30 + 31 + 30 + day;//July
				break;
			case 8:
				answer =  31 + 29 + 31 + 30 + 31 + 30 + 31 + day; //August
				break;
			case 9:
				answer =  31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + day;//September
				break;
			case 10:
				answer =  31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;//October
				break;
			case 11:
				answer =  31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;//november
				break;
			case 12:
				answer =  31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;//december
				break;
		}
		if(leap == 0 && month >= 3) {
			answer -= 1;
		}
		return answer;
		
	}
	
	

}
