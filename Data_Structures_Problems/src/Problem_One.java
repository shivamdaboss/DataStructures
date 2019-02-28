import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem_One {
	private String name;
	private BufferedReader reader;
	private File file;
	public Problem_One(String name){
		ArrayList<String> output = new ArrayList<String>();
		String text = "";
		File file = new File(name);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			ArrayList<String> firstSets = new ArrayList<String>();
			ArrayList<Integer> setOne = new ArrayList<Integer>();
			ArrayList<Integer> intersectionSetOne = new ArrayList<Integer>();
			int l = 0;
			int setCount = 0;
			while((text = reader.readLine()) != null) {
				//System.out.println(text);
				output.add(text);
				l++;
				
				if (l == 3) {
					setCount++;
					firstSets.clear();
					setOne.clear();
					intersectionSetOne.clear();
					
					for(int i = 0; i < output.size(); i++) {
						firstSets.addAll(Arrays.asList(output.get(i).split(" ")));
					}
					
					for(int i = 0; i < firstSets.size(); i++) {
						setOne.add(Integer.parseInt(firstSets.get(i)));
					}
					
					int count = 0;
					int goal = -1;
					for(int i = 0; i < setOne.size(); i++) {
						goal = setOne.get(i);
						for(int j = 0; j < setOne.size(); j++) {
							if(setOne.get(j) == goal) {
								count++;
							}
						}
						if (count >= 3 && !intersectionSetOne.contains(setOne.get(i))) {
							intersectionSetOne.add(setOne.get(i));
						}
						count = 0; 
					}
					if(intersectionSetOne.size() == 1) {
						System.out.print("Set " + setCount + " Intersection = {" + intersectionSetOne.get(0) + "}");
					}
					else {
						System.out.print("Set " + setCount + " Intersection = {");
						int min = intersectionSetOne.get(0);	
						int index = 0;
						for(int j = 0; j < intersectionSetOne.size(); j++) {
							for(int i =  0; i < intersectionSetOne.size(); i ++) {
								if(min > intersectionSetOne.get(i)) {
									index = i;
									min = intersectionSetOne.get(i);
								}
							}
							System.out.print(min + ", ");
							intersectionSetOne.remove(index);
							min = intersectionSetOne.get(0);	
							index = 0;
							if(intersectionSetOne.size() == 1) {
								System.out.println(intersectionSetOne.get(0) + "}");
								break;
							}
						}
					}
					l = 0;
					output.clear();
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
