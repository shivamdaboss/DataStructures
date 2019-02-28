import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProblemSeven {
	ProblemSeven(String name){
		File file = new File(name);
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> ab = new ArrayList<String>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		String gold = "";
		int total = 0;
		ArrayList<Integer> b = new ArrayList<Integer>();
		int goldenIndex  = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String text;
			while ((text = reader.readLine()) != null) {
				a.addAll(Arrays.asList(text.split(" ")));
				goldenIndex = Integer.parseInt(a.get(1));
				gold = a.get(0);
				ab.addAll(Arrays.asList(gold.split("")));
				for(int i = 0; i < ab.size(); i++) {
					b.add(Integer.parseInt(ab.get(i)));
				}
				//System.out.println(b);
				if(b.size() == 1) {
					if(b.get(0) < goldenIndex) {
						total = b.get(0);
					}
				}
				else if(b.size() == 2) {
					if(10*b.get(0) + b.get(1) <= goldenIndex) {
						c.add(10*b.get(0) + b.get(1) );
					}
					if(b.get(0) + b.get(1) <= goldenIndex) {
						c.add(b.get(0) + b.get(1));
					}
					Collections.sort(c);
					total = c.get(c.size() -1);
				}
				else if(b.size() == 3) {
					if(100*b.get(0) + 10*b.get(1) + b.get(2) <= goldenIndex) {
						c.add(100*b.get(0) + 10*b.get(1) + b.get(2));
					}
					if(10*b.get(0) + b.get(1) + b.get(2) <= goldenIndex) {
						c.add(10*b.get(0) + b.get(1) + b.get(2));
					}
					if(b.get(0) + 10*b.get(1) + b.get(2) <= goldenIndex) {
						c.add(b.get(0) + 10*b.get(1) + b.get(2));
					}
					if(b.get(0) + b.get(1) + b.get(2) <= goldenIndex) {
						c.add(b.get(0) + b.get(1) + b.get(2));
					}
					Collections.sort(c);
					total = c.get(c.size() -1);
				}
				else if(b.size() == 4) {
					if(b.get(0) + 100*b.get(1) + 10*b.get(2) + b.get(3) <= goldenIndex) {
						c.add(b.get(0) + 100*b.get(1) + 10*b.get(2) + b.get(3));
					}
					if(100*b.get(0) + 10*b.get(1) + b.get(2) + b.get(3) <= goldenIndex) {
						c.add(100*b.get(0) + 10*b.get(1) + b.get(2) + b.get(3));
					}
					if(b.get(0) + b.get(1) + b.get(2) + b.get(3) <= goldenIndex) {
						c.add(b.get(0) + b.get(1) + b.get(2) + b.get(3));
					}
					if(10*b.get(0) + b.get(1) + 10*b.get(2) + b.get(3) <= goldenIndex) {
						c.add(10*b.get(0) + b.get(1) + 10*b.get(2) + b.get(3));
					}
					if(1000*b.get(0) + 100*b.get(1) + 10*b.get(2) + b.get(3) <= goldenIndex) {
						c.add(1000*b.get(0) + 100*b.get(1) + 10*b.get(2) + b.get(3));
					}
					if(b.get(0) + 10*b.get(1) + b.get(2) + b.get(3) <= goldenIndex) {
						c.add(b.get(0) + 10*b.get(1) + b.get(2) + b.get(3));
					}
					if(b.get(0) + b.get(1) + 10*b.get(2) + b.get(3) <= goldenIndex) {
						c.add(b.get(0) + b.get(1) + 10*b.get(2) + b.get(3) );
					}
					if(10*b.get(0) + b.get(1) + 10*b.get(2) + b.get(3) <= goldenIndex) {
						c.add(10*b.get(0) + b.get(1) + 10*b.get(2) + b.get(3) );
					}
					Collections.sort(c);
					total = c.get(c.size() - 1);
				}
				
				System.out.println(total);
				c.clear();
				a.clear();
				ab.clear();
				b.clear();
				
			}
			
		}
	
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
