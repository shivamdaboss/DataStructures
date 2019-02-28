import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		File f = new File("Res/car.txt");
		PriorityQueue<Car> carList = new PriorityQueue<Car>();
		try {
			BufferedReader r = new BufferedReader(new FileReader(f));
			String text = "";
			
			String[] values;
			int[] valuesInts;
			while((text = r.readLine()) != null) {
				values = text.split("\t");
				valuesInts = new int[values.length];
				for(int i = 0; i < values.length; i++) {
					valuesInts[i] = Integer.parseInt(values[i]);
				}
				carList.add(new Car(valuesInts[0], valuesInts[1], valuesInts[2], valuesInts[3], valuesInts[4], valuesInts[5], valuesInts[6], valuesInts[7]));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		while(!carList.isEmpty()){
			  System.out.println(carList.poll());
			}
	}
}
