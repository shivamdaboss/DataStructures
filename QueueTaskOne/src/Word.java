
public class Word implements Comparable<Word>{
	private String word;
	public Word(String word) {
		this.word = word;
	}
	
	public String toString() {
		return word;	
	}

	@Override
	public int compareTo(Word o) {
		if(word.toLowerCase().compareTo(o.toString().toLowerCase()) < 0) {
			return -1;
		}
		else if(word.toLowerCase().compareTo(o.toString().toLowerCase()) > 0) {
			return 1;
		}
		return 0;
		
	}
	public String getWord() {
		return word;
	}
}
