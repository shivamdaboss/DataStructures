import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProblemTen {
	
	
	ProblemTen(String name){
		
		File file = new File(name);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String text;
			ArrayList<String[]> a = new ArrayList<String[]>();
			
			int count = 0;
			while((text = reader.readLine()) != null) {
				ArrayList<String> temp = new ArrayList<String>(Arrays.asList(text.split(",")));

				for(int i = 0; i < temp.size(); i++) {
					if(count == 0) {
						a.add(new String[5]);
					}
					a.get(i)[count] = temp.get(i);
				}
				
				count++;
			}
			
			String[][] notes = {{"E", "A", "D", "G", "B", "E"}, 
								{"F", "A#", "D#", "G#", "C", "F"}, 
								{"F#", "B", "E", "A", "C#", "F#"}, 
								{"G", "C", "F", "A#", "D", "G"}, 
								{"G#", "C#", "F#", "B", "D#", "G#"}};
			
			String[][] answers = new String[31][a.size() + 1];
			//formatting answers array
			for(int i = 0; i < answers.length; i++) {
				for(int j = 0; j < answers[i].length; j++) {
					answers[i][j] = "";
				}
			}
			
			
			answers[0][0] = "Measure";
			for(Integer i = 1; i < a.size() + 1; i++) {
				answers[0][i] = i.toString();
			}
			int countTT = 1;
			for(int i = notes[0].length - 1; i >= 0; i--) {
				for(int j = notes.length - 1; j >= 0; j--) {
				 	answers[countTT][0] = notes[j][i];
					countTT++;
				}
			}

			String[][] b = new String[5][6];
			for(int h = 0; h < b[0].length; h++) {
				for(int j = b.length - 1; j >= 0; j--) {
					b[j][h] = "";
				}
			}
			//actual problem
			for(int i = 0; i < a.size(); i++) {
				//going through every single measure
				for(int j = 0; j < a.get(i).length; j++) {
					//going through every single line in the measure 
					for(int k = 0; k < a.get(i)[j].length(); k++) {
						//going through every character in the line in the measure
						if(a.get(i)[j].substring(k, k+1).equals("*") || a.get(i)[j].substring(k, k+1).equals("o") ) {
							b[j][k] = "O";
						}
					}
				}
				
				int countTTT = 1;
				for(int h = b[0].length - 1; h >= 0; h--) {
					for(int j = b.length - 1; j >= 0; j--) {
					 	answers[countTTT][i + 1] = b[j][h];
					 	countTTT++;
					}
				}    
				     
				for(int h = 0; h < b[0].length; h++) {
					for(int j = b.length - 1; j >= 0; j--) {
					 	b[j][h] = "";
					}
				}    
				     
			}        
			
			for(int i = 0; i < answers.length; i++) {
				for(int j = 0; j < answers[i].length; j++) {
					System.out.print(answers[i][j] + "\t");;
				}
				System.out.println();
			}
			
			
			

			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	void printer(ArrayList<String[]> a) {
		for(int i = 0; i < a.get(0).length; i++) {
			for(int j = 0; j < a.size(); j++) {
				System.out.print( a.get(j)[i]+ ", ");
			}
			System.out.println();
		}
	}
}
