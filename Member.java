import java.util.ArrayList;
import java.util.List;

public class Member{

	private String memberID;
	private String name;
	private String contactInfo;
	private List<Book> borrowedBooks;

	public Member(String memberID, String name, String contactInfo){
		this.memberID = memberID;
		this.name = name;
		this.contactInfo = contactInfo;
		this.borrowedBooks = new ArrayList<>();
	}

	public String getMemberID(){
		return memberID;
	}
	public String getName(){
		return name;
	}
	public String getContactInfo(){
		return contactInfo;
	}
	public List<Book> getBorrowedBooks(){
		return borrowedBooks;
	}
	public void	borrowBook(Book book)
	{
		if(borrowedBooks.size() >= 5)
		{
			System.out.println(name + " reached the limit of 5 books");
			System.out.println("PLEASE RETURN THE OTHER BOOK FIRST!");
		}
		if(book.isAvailable())
		{
			borrowedBooks.add(book);
			book.borrowBook();
			System.out.println(name + " has borrowed the book title: " + book.getTitle());
		}
		else
		{
			System.out.println("The book is not available at the moment");
		}
	}
	public void returnBook(Book book)
	{
		if(borrowedBooks.contains(book))
		{
			borrowedBooks.remove(book);
			book.returnBook();
			System.out.println(name + " has returned the book title: " + book.getTitle());
		}
		else
		{
			System.out.println("You don't have the book you want to return. Please double check.");
		}
	}

	public String toString()
	{
		String result =  "Member ID: " + memberID + "\n" +
				"Name: " + name + "\n" +
				"Contact Info: "  +contactInfo + "\n";
			if(borrowedBooks.isEmpty())
			{
				System.out.println("No books borrowed");
			}
			else
			{
				System.out.println("BOOK BORROWED");
				for(Book book : borrowedBooks)
				{
					System.out.println(book.getTitle()+ " by " + book.getAuthor());
				}
				System.out.println("");
			}
		return result;
	}


}