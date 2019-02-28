import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem_Three {
	
	Problem_Three(String name){
		File file = new File(name);
		String text = null;
		ArrayList<String> original = new ArrayList<String>();
		ArrayList<Integer> originalTwo = new ArrayList<Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			 while((text = reader.readLine()) != null) {
					
				original.addAll(Arrays.asList(text.split(" ")));
				for(int i = 0; i < original.size(); i++) {
					originalTwo.add(Integer.parseInt(original.get(i)));
				}
				System.out.println(jollySorter(originalTwo));
				
				original.clear();
				originalTwo.clear();
			 }
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public ArrayList<Integer> jollySorter(ArrayList<Integer> original){
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		//order original
		int x = original.size();
		Collections.sort(original);
		sorted.add(original.get(0));
		//sorted.add(original.get(1));
		for(int i = 2; i < x; i+=2) {
			sorted.add(original.get(i));
			sorted.add(original.get(i - 1));
		}
		
		if(x % 2 == 0) {
			sorted.add(original.get(x - 1));
		}
		
		return sorted;
		
	}
	
}
