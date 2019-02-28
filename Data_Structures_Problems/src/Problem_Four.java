import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem_Four {
	Problem_Four(String name){
		String text = null;
		String[] texts = new String[2];
		File file = new File(name);
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<Integer> c = new ArrayList<Integer>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while((text = reader.readLine()) != null) {
				a.addAll(Arrays.asList(text.split(" ")));
				for(int i = 0; i < a.size(); i ++) {
					c.add(Integer.parseInt(a.get(i)));
				}
				char[][] e = new char[c.get(0)][c.get(1)];
				for(int i = 0; i < e.length; i++) {
					for(int j = 0; j < e[i].length; j ++) {
						e[i][j] = 'o';
						if(j == c.get(4) && i == c.get(3)) {
							e[i][j] = 'x';
						}
					}
				}
				
				int k = c.get(3);
				int h = 0;
				for(int j = 0; j < c.get(2); j++) {
					while(h <= j) {
						e[k][c.get(4) + h] = 'x';
						e[k][c.get(4) - h] = 'x';
						h++;
					}
					h = 0;
					k++;
				}
				//making the second half of the diamond
				k = c.get(3) + c.get(2);
				h = 0;
				for(int j = c.get(2) - 2; j >= 0; j--) {
					while(h <= j) {
						e[k][c.get(4) + h] = 'x';
						e[k][c.get(4) - h] = 'x';
						h++;
					}
					h = 0;
					k++;
				}
				print(e);
				a.clear();
				c.clear();
				
			}
		} catch (IOException l) {
			l.printStackTrace();
		}
		
	}
	
	
	
	public void print(char[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j ++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		
	}
}
