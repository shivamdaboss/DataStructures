
public class Book {
	private String author;
	private String bookTitle;
	private double rating;
	private int numbOfRatings;
	private int score;
	private int numbOfVotes;
	Book(String author, String bookTitle, double rating, int numbOfRatings, int score, int numbOfVotes){
		this.author = author;
		this.bookTitle = bookTitle;
		this.rating = rating;
		this.numbOfRatings = numbOfRatings;
		this.score = score;
		this.numbOfVotes = numbOfVotes;
		
	}
	
	public String toString() {
		return author +", " + bookTitle +", " + rating +", " + numbOfRatings +", " + score +", " + numbOfVotes;
	}
	
	public String fNFL() {
		return author.substring(0, 1);
	}
	
	public String lNFL() {
		String[] yo = author.split(" ");
		return yo[1].substring(0, 1);
	}
}
