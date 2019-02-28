import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	
	private static Stack<Book> bookStack = new Stack<Book>();
	
	public static void main(String[] args) {
		try {
			BufferedReader r = new BufferedReader(new FileReader(new File("Res/StackTaskThree.txt")));
			String text = "";
			int counter = 0;
			String idiot = "";
			while((text = r.readLine()) != null) {
				
				if (counter == 7) {
					counter = 1;
					function(idiot);
					idiot = "";
					idiot += text + "@";
					
				}
				else {
					counter++;
					idiot += text + "@";
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ArrayList<Book> bookList = new ArrayList<Book>();   
		while(!bookStack.empty()) {
			if(bookStack.peek().fNFL().equals("E") || bookStack.peek().lNFL().equals("E")){
				bookList.add(bookStack.peek());
			
			}
			else if(bookStack.peek().fNFL().equals("H") || bookStack.peek().lNFL().equals("H")){        
				bookList.add(bookStack.peek());                                                     
			}              
			else if(bookStack.peek().fNFL().equals("P") || bookStack.peek().lNFL().equals("P")){        			
				bookList.add(bookStack.peek());                                                         			
			}                    
			else if(bookStack.peek().fNFL().equals("S") || bookStack.peek().lNFL().equals("S")){        			
				bookList.add(bookStack.peek());                                                         	
			}                     

			bookStack.pop();

			
		}
		System.out.println();
		System.out.println(bookList);
	}
	
	
	static String commas(String idiot) {			
		String s = new String();
		for(int i = 0; i < idiot.length(); i++) {
			if(idiot.charAt(i) == ',') {
				continue;
			}
			else {
				s += idiot.charAt(i);
			}
		}
		
		return s;
	}
	
	
	static void function (String idiot) {
		String[] vals = idiot.split("@");
		String[] lineFive = vals[4].split(" ");
		String[] lineSix= vals[5].split(" ");
		bookStack.add(new Book(vals[3].substring(2), 
				vals[2], 
				Double.parseDouble(commas(lineFive[0])),
				Integer.parseInt(commas(lineFive[4])),
				Integer.parseInt(commas(lineSix[1])), 
				Integer.parseInt(commas (lineSix[3]))));
	}
}
