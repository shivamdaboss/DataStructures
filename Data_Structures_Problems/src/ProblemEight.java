import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class ProblemEight {
	ProblemEight(String name){
		File file = new File(name);
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		try {
			DateTimeFormatter d = DateTimeFormatter.ofPattern("h:mm a 'on' M/d/uuuu");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			LocalDateTime now = LocalDateTime.now();
			String text = "";
			int count = 0;
			
			while((text = reader.readLine()) != null) {
				count++;
				a.addAll(Arrays.asList(text.split(" ")));
				for(int i = 0; i < a.size(); i++) {
					b.add(Integer.parseInt(a.get(i)));
				}
				
				
				System.out.println("Trip " + count);
				System.out.println("\tDeparture Date and Time: " + now.format(d));
				LocalDateTime later = now.plusDays(b.get(0)).plusHours(b.get(1)).plusMinutes(b.get(2));
				System.out.println("\tArrival Date and Time: " + later.format(d));
				b.clear();
				a.clear();
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
