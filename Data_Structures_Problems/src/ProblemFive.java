import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProblemFive {
	private BufferedReader reader;

	ProblemFive(String name){
		String text = "";
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		String[][] board = new String[3][3];
		File file = new File(name);
		try {
			reader = new BufferedReader(new FileReader(file));
			int l = 0;
			while((text = reader.readLine()) != null) {
				output.add(text);
				l++;
				if(l == 3) {
					if(output.contains("X X X")) {
						System.out.println("X");
						l = 0;
						output.clear();
						temp.clear();
						continue;
						
					}
					else if(output.contains("O O O")) {
						System.out.println("O");
						l = 0;
						output.clear();
						temp.clear();
						continue;
					}
					
					// filling the board
					for(int i = 0; i < output.size(); i++) {
						temp.addAll(Arrays.asList(output.get(i).split(" ")));
					}
					int arb = 0;
					for(int i = 0; i < board.length; i++) {
						for(int j = 0; j < board[i].length; j++) {
							board[i][j] = temp.get(arb);
							arb++;
						}
					}
					
					//testing columns
					arb = 0;
					
					while(arb < 3) {
						if(board[0][arb].equals(board[1][arb]) && board[1][arb].equals(board[2][arb])) {
							if(board[0][arb].equals("X")) {
								System.out.println("X");
								l = 0;
								output.clear();
								temp.clear();
								break;
							}
							else{
								System.out.println("O");
								l = 0;
								output.clear();
								temp.clear();
								break;
							}
						}
						else {
							arb++;
						}
						
					
					}
					arb = 0;
					if(output.size() == 0) {
						
						continue;
					}
					
					//testing diagonals
					
					if((board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) || (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))) {
						
						if(board[0][arb].equals("X")) {
							System.out.println("X");
							l = 0;
							output.clear();
							temp.clear();
							continue;
						}
						else{
							System.out.println("O");
							l = 0;
							output.clear();
							temp.clear();
							continue;
						}
					}
					
					System.out.println("-");
					
					
					l = 0;
					output.clear();
					temp.clear();
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
