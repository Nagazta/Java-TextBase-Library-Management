import java.util.List;

public class Librarian extends Member{
	public Librarian(String memberID, String name, String contactInfo){
		super(memberID, name, contactInfo);
	}
	public void addBook(Book book, Library library)
	{
        library.addBook(book);
	}
    public void removeBook(String bookID, Library library)
    {
        Book book = library.FindBooksID(bookID);
        if (book != null)
        {
            library.getBooks().remove(book);
            System.out.println("BOOK: " + book.getTitle() + " has been removed from the library.");
        }
        else
        {
            System.out.println("Book with ID " + bookID + " not found.");
        }
    }

}