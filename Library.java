import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<Book> books;
	private List<Member> members;
	public Library(){
		this.books = new ArrayList<>();
		this.members = new ArrayList<>();
	}
	public void addBook(Book book)
	{
		if(!books.contains(book))
		{
			books.add(book);
			System.out.println("BOOK: " + book.getTitle() + " has been added to the library");
		}
		else
		{
			System.out.println("BOOK IS ALREADY IN THE LIBRARY!");
		}
	}
	public void registerMember(Member member)
	{
		if(!members.contains(member))
		{
			members.add(member);
			System.out.println(member.getName() + " has been added to the Library System");
		}
		else
		{
			System.out.println("THIS USER HAS BEEN REGISTERED ALREADY IN THE SYSTEM");
		}
	}
	public Book findBookByTitle(String title)
	{
		for(Book book : books)
		{
			if(book.getTitle().equalsIgnoreCase(title))
			{
				if(book.isAvailable())
				{
					return book;
				}
				else
				{
					System.out.println("The book " + title + " is currently unavailable");
					return null;
				}
			}
		}
		System.out.println("THIS BOOK IS NOT REGISTERED IN THE LIBRARY");
		return null;
	}
	public void borrowBook(String bookID, String memberID)
	{
		Book book = FindBooksID(bookID);
		Member member = FindMembersID(memberID);

		if(book == null)
		{
			System.out.println("Book: " + bookID + " not found");
			return;
		}
		if(member == null)
		{
			System.out.println("Member: " + memberID +" not found");
			return;
		}
		if(book.isAvailable())
		{
			member.borrowBook(book);
		}
		else
		{
			System.out.println("THE BOOK IS CURRENTLY UNAVAILABLE");
		}
	}
	public void returnBook(String bookID, String memberID)
	{
		Book book = FindBooksID(bookID);
		Member member = FindMembersID(memberID);

		if(book == null)
		{
			System.out.println("Book: " + bookID + " not found");
			return;
		}
		if(member == null)
		{
			System.out.println("Member: " + memberID +" not found");
			return;
		}
		member.returnBook(book);
	}

	public Book FindBooksID(String bookID)
	{
		for(Book book : books)
		{
			if(book.getBookID().equals(bookID))
			{
				return book;
			}
		}
		return null;
	}
	public Member FindMembersID(String memberID)
	{
		for(Member member : members)
		{
			if(member.getMemberID().equals(memberID))
			{
				return member;
			}
		}
		return null;
	}
	 public List<Book> getBooks() {
	        return books;
    }

}