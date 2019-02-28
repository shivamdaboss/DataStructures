import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TaskTwo {
	public static void main(String[] args) {
		TreeMap<Integer, PriorityQueue<Bowler>> tm = new TreeMap();
		File f = new File("res/TaskTwo.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String text = "";
			String[] vals;
			int score;
			while((text = br.readLine()) != null) {
				vals = text.split(" ");
				score = Integer.parseInt(vals[2]);
				if(!tm.containsKey(score)) {
					tm.put(score, new PriorityQueue<Bowler>());
				}
				tm.get(score).add(new Bowler(vals[1], vals[0], score));
			}
		}
		catch(Exception e) {
			
		}
		
		for (int i : tm.keySet()) {
			PriorityQueue<Bowler> temp = tm.get(i);
			System.out.print("Score: " + i + "  List of Names: ");
			int x = tm.get(i).size();
			for(int j = 0; j < x; j++) {
				System.out.print(tm.get(i).poll());
			}
			System.out.println();
		}
	}
}
