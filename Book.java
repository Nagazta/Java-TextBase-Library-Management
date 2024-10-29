public class Book{

	private String bookID;
	private String title;
	private String author;
	private String genre;
	private boolean isAvailable;

	public Book(String bookID, String title, String author, String genre){
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.isAvailable = true;

	}
	public String getBookID(){
		return bookID;
	}
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	public String getGenre(){
		return genre;
	}
	public boolean isAvailable(){
		return isAvailable;
	}


	public void borrowBook()
	{
		if(isAvailable)
		{
			isAvailable = false;
			System.out.println("Thanks for availing the book: " + title+ "\n");
		}
		else
		{
			System.out.println("The book is not available at the moment");
		}
	}
	public void returnBook()
	{
		if(!isAvailable)
		{
			isAvailable = true;
			System.out.println("Thanks for returning the book: " + title + "\n");
		}
		else
		{
			System.out.println("The book was not borrowed");
		}
	}
	public String toString(){
		if(isAvailable)
		{
			System.out.println("This book is available to borrow");
		}
		else
		{
			System.out.println("This book is unavailable to borrow");
		}
		return  "Book ID: "+ bookID + "\n" +
				"Title: " +title + "\n" +
			    "Author: " +author + "\n" +
			    "Genre: " +genre + "\n";
	}
}