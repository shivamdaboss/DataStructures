import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem_Two {
	
	private ArrayList<Integer> indexes = new ArrayList<Integer>();
	private ArrayList<BigInteger> sequence = new ArrayList<BigInteger>(Arrays.asList(BigInteger.valueOf(2), BigInteger.valueOf(1), BigInteger.valueOf(3)));
	Problem_Two(String name){
		File file = new File(name);
		String text = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((text = reader.readLine()) != null) {
				System.out.println(method(new BigInteger(text)));
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public BigInteger method(BigInteger goldenIndex) {
		sequence.clear();
		if(goldenIndex.equals(BigInteger.valueOf(0))) {
			return BigInteger.valueOf(2);
		}
		else if(goldenIndex.equals(BigInteger.valueOf(1))) {
			return BigInteger.valueOf(1);
		}
		else if(goldenIndex.equals(BigInteger.valueOf(2)))
			return BigInteger.valueOf(3);
		else {
			sequence.add(BigInteger.valueOf(2));
			sequence.add(BigInteger.valueOf(1));
			sequence.add(BigInteger.valueOf(3));
			for(BigInteger i = BigInteger.valueOf(2); i.compareTo(goldenIndex) < 0; i = i.add(BigInteger.valueOf(1))) {
				sequence.set(0, sequence.get(1));
				sequence.set(1, sequence.remove(2));
				sequence.add(sequence.get(1).add(sequence.get(0)));
			
			}
		}
		
		return sequence.get(2);
	}

}
