
public class WordTwo implements Comparable<WordTwo>{
	private String word;
	public WordTwo(String word) {
		this.word = word;
	}
	
	public String toString() {
		return word;	
	}

	@Override
	public int compareTo(WordTwo o) {
		if(word.toLowerCase().compareTo(o.toString().toLowerCase()) > 0) {
			return -1;
		}
		else if(word.toLowerCase().compareTo(o.toString().toLowerCase()) < 0) {
			return 1;
		}
		return 0;
		
	}
	public String getWord() {
		return word;
	}
}
