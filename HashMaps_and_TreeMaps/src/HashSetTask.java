import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class HashSetTask {
	public static void main(String[] args) {
		int y = (int)(Math.random() * 11) + 2;
		ArrayList<HashSet<Integer>> x = new ArrayList<HashSet<Integer>>();
		for(int i = 0; i < y; i++) {
			x.add(new HashSet<Integer>());

		}
		int random = (int)(Math.random() * 60) + 1;
		for(int i = 0; i < x.size(); i++) {
			for(int j = 0; j < 20; j++) {
				random = (int)(Math.random() * 60) + 1;
				while(x.get(i).contains(random)){
					random = (int)(Math.random() * 60) + 1;
				}
				x.get(i).add(random);
			}
			System.out.println(x.get(i) + "    " + x.get(i).size());
		}
		
		
		System.out.println("Union of First Two Sets:   " + union(x.get(0), x.get(1)));
		System.out.println("Even union of First Two Sets:   " + evenUnion(x.get(0), x.get(1)));
	}
	
	public static Set<Integer> intersection(HashSet<Integer> x, HashSet<Integer> y) {
		HashSet<Integer> z = new HashSet<Integer>(x);
		z.retainAll(y);
		return z;
	}
	
	public static Set<Integer> union(HashSet<Integer> x, HashSet<Integer> y) {
		HashSet<Integer> z = new HashSet<Integer>(x);
		z.addAll(y);
		return z;
	}
	
	public static Set<Integer> evenIntersection(HashSet<Integer> x, HashSet<Integer> y) {
		HashSet<Integer> z = new HashSet<Integer>(x);
		z.retainAll(y);
		Iterator<Integer> iterator = z.iterator();
		while (iterator.hasNext()) {
		    Integer element = iterator.next();
		    if (element % 2 == 1) {
		        iterator.remove();
		    }
		}
		return z;
	}
	
	public static Set<Integer> evenUnion(HashSet<Integer> x, HashSet<Integer> y) {
		HashSet<Integer> z = new HashSet<Integer>(x);
		z.addAll(y);
		Iterator<Integer> iterator = z.iterator();
		while (iterator.hasNext()) {
		    Integer element = iterator.next();
		    if (element % 2 == 1) {
		        iterator.remove();
		    }
		}
		return z;
	}
	
}
