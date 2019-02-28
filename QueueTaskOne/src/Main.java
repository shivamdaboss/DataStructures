import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {
	public static void main(String[] args) {
		Queue<Word> x = new LinkedList<Word>();
		ArrayList<String> a = new ArrayList<String>();
		File f = new File("Res/text");
		String text = "";
		String[] temp;
		try {
			BufferedReader r = new BufferedReader(new FileReader(f));
			
			while((text = r.readLine()) != null) {
				temp = text.split(" ");
				for(int i =  0; i < temp.length; i++) {
					temp[i] = temp[i].replace(",", "");
					temp[i] = temp[i].replace(" ", "");
					temp[i] = temp[i].replace(".", "");
					a.add(temp[i]);
					x.add(new Word(temp[i]));
				}
			}
			

			
			//alphabetical order
			
			PriorityQueue<Word> q = new PriorityQueue<Word> ();
			for(int i = 0; i < a.size(); i++) {
				q.add(new Word(a.get(i)));
			}
			System.out.println();	
			

			
			//part b
			PriorityQueue<WordTwo> qTwo = new PriorityQueue<WordTwo> ();
			for(int i = 0; i < a.size(); i++) {
				qTwo.add(new WordTwo(a.get(i)));
			}
			
			for(Word s : x) {
				if(s.getWord().length() <= 8 ) {
					System.out.print(s + "\t\t\t");
				}
				else {
					System.out.print(s + "\t\t");
				}
				if(q.peek()!= null) {
					if(q.peek().toString().length() <= 8) {
						System.out.print(q.poll() + "\t\t\t");
					}
					else {
						System.out.print(q.poll() + "\t\t");
					}
				}
				if(qTwo.peek() != null) {
					System.out.println(qTwo.poll());
				}
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void ProblemOneA() {
		
	}
}
