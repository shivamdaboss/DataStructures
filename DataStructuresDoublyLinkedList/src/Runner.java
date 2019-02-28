
public class Runner {
	public static void main(String [] args) {

		
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		int random;
		// adding thirty random numbers
		for(int i = 0; i < 30; i++) {
			random = (int)(Math.random() * 1000) + 1;
			list.add(random);
		}
		
		System.out.println("List: " + list.toString());
		
		//printing in reversed order
		System.out.println("List in reversed order: " + list.toReversedString());
		//printing list size
		System.out.println("List Size: " + list.getSize());
		//average of all numbers	
		int average = 0;
		for(int i = 0; i < list.getSize(); i++) {
			average += list.get(i).getValue();
		}
		average /= list.getSize();
		System.out.println("List Average: " + average);
		//even number average
		int evenAverage = 0;
		for(int i = 0; i < list.getSize(); i+= 2) {
			evenAverage += list.get(i).getValue();
		}
		evenAverage /= list.getSize()/2;
		System.out.println("Even average: " + evenAverage);
		//odd number average
		int oddAverage = 0;
		for(int i = 1; i < list.getSize(); i+= 2) {
			oddAverage += list.get(i).getValue();
		}
		oddAverage /= list.getSize()/2;
		System.out.println("Even average: " + oddAverage);
		// adding odd numbers again
		int initialSize = list.getSize();
		for(int i = 0; i < initialSize; i++) {
			if(list.get(i).getValue() % 2 == 1) {
				list.add(list.get(i).getValue());
			}
		}
		System.out.println("List with odds added once more: " + list);
		//removing divisible by 4
		for(int i = 0; i < list.getSize(); i++) {
			if(list.get(i).getValue() % 4 == 0) {
				list.remove(i);
			}
		}
		System.out.println("Everything divisible by 4 removed: " + list);
		//adding 45454 in the fourth position
		list.add(3, 45454);
		
		System.out.println("List with added value: " + list);
		//sorting list
		System.out.println("Sorted List: " + list.sort());
		
		//List Median
		if(list.getSize() % 2 == 0) {
			int median = (list.get(list.getSize()/2).getValue() + list.get(list.getSize()/2 - 1).getValue()) / 2;
			System.out.println("Median: " + median);
		}
		else {
			System.out.println("Median: " + list.get(list.getSize() / 2 + 1));
		}
		
		
		
	}
}
