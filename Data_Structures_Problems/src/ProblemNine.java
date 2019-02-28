import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ProblemNine {
	File file;
	ProblemNine(String name){
		file = new File(name);
		String text = "";
		int size = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((text = reader.readLine()) != null) {
				size = Integer.parseInt(text);
				String[][] x = new String[size][size];
				print(spiral(x));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	void print(String[][] array) {
		System.out.println(array.length);
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + ' ');
			}
			System.out.println();
		}
		System.out.println();
	}
	
	String[][] spiral(String[][] array){
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = "-";
			}
		}
		int count = 0;
		
		//making the squares
		//horizontal bars
		for(int i = array.length - 1; i > 0; i-= 2) {
			for(int j = count; j < array.length - count;j++) {
				array[i][j] = "*";
			}
				count+= 2;
		}
		count = 0;
		for(int i = 0; i < array.length; i+= 2) {
			for(int j = count; j < array.length - count;j++) {
				array[i][j] = "*";
			}
				count+= 2;
		}
		
		//vertical bars
		count = 0;
		for(int i = array.length - 1; i > 0; i-= 2) {
			for(int j = count; j < array.length - count;j++) {
				array[j][i] = "*";
			}
				count+= 2;
		}
		count = 0;
		for(int i = 0; i < array.length; i+= 2) {
			for(int j = count; j < array.length - count;j++) {
				array[j][i] = "*";
			}
				count+= 2;
		}
		
		
		for(int i = 0; i < array.length / 2; i += 2) {
			array[i + 1][i] = "-";
			if(array.length/2 - i >= 2 && array.length%2 == 1) {
				array[i+2][i+1] = "*";
			}
			else if(array.length/2 - i >= 3 && array.length%2 == 0) {
				array[i+2][i+1] = "*";
			}
		}
		
		
		
		return array;
	}
	
	
}
