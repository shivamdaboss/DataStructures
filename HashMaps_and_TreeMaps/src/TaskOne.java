import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class TaskOne {

	public static void main(String[] args) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		String text = "";
		File file = new File("res/TaskOne");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((text = reader.readLine()) != null) {
				int num = Integer.parseInt(text);
				if(!hm.containsKey(num)) {
					hm.put(num, 0);
				}
				hm.put(num, hm.get(num) + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(hm);
	
	}
}
