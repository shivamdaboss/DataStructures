import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TaskThree {
	public static void main(String[] args) {
		String fileName = "res/TaskThree.txt";
		String text = "";
		HashMap<String, HashSet<BasketballPlayer>> list = new HashMap<String, HashSet<BasketballPlayer>>();
		TreeMap<String, TreeSet<BasketballPlayer>> sortedList = new TreeMap<String, TreeSet<BasketballPlayer>>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
			while((text = br.readLine()) != null) {
				String[] vals = text.split("\t");
				if(!list.containsKey(vals[8])) {
					list.put(vals[8], new HashSet<BasketballPlayer>());
				}
				list.get(vals[8]).add(new BasketballPlayer(Integer.parseInt(vals[0]), vals[1], vals[2], Integer.parseInt(vals[3]), vals[4], Integer.parseInt(vals[5]), vals[6], vals[7], vals[8]));
				if(!sortedList.containsKey(vals[8])) {
					sortedList.put(vals[8], new TreeSet<BasketballPlayer>());
				}
				sortedList.get(vals[8]).add(new BasketballPlayer(Integer.parseInt(vals[0]), vals[1], vals[2], Integer.parseInt(vals[3]), vals[4], Integer.parseInt(vals[5]), vals[6], vals[7], vals[8]));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator i;
		for(String j : list.keySet()) {
			System.out.println(j + ": ");
			i = list.get(j).iterator();
			while(i.hasNext()) {
				System.out.print(i.next() + " ");
			}
			System.out.println();
			System.out.println();
			
		}
		
		System.out.println("Sorted Verson:      ");
		System.out.println();
		
		Iterator z = sortedList.keySet().iterator();
		while(z.hasNext()) {
			Object u = z.next();
			System.out.println(u + ": ");
			i = sortedList.get(u).iterator();
			while(i.hasNext()) {
				System.out.print(i.next() + " ");
			}
			System.out.println();
			System.out.println();
			
		}
		
	}
}	
