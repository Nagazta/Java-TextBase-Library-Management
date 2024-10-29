import java.util.Scanner;

public class Main{
	public static void main(String[] a){
		System.out.println("LIBRARY MANAGEMENT SYSTEM");
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();

		Book book = new Book("100087", "HORIZON" ,"Kyle Sepulveda" , "Fantasy" );
		library.addBook(book);

		Member member = new Member ("MEM1001" , "Kurt Skie" ," 09273819");
		library.registerMember(member);

		Librarian librarian = new Librarian ("LIB1001", "THESSA SAYABOC", "09U60709");

		boolean LogOut = true;

while(LogOut)
{

        System.out.println("LOG IN MENU");
        System.out.print("ENTER ID: ");
        String memberID = scanner.nextLine();
        Member loginMem = library.FindMembersID(memberID);
        if(memberID.equals(member.getMemberID()))
        {
			System.out.println("WELCOME " + member.getName() + "!");
			System.out.print("ENTER THE BOOK ID TO BORROW: ");
			String bookID = scanner.nextLine();
			library.borrowBook(bookID, memberID);

			System.out.print("ENTER THE BOOK ID YOU WANT TO RETURN: ");
			bookID = scanner.nextLine();
			library.returnBook(bookID, memberID);
		}
		else if(memberID.equals(librarian.getMemberID()))
		{
			System.out.println("WELCOME " + librarian.getName() + "!");
 			System.out.println("LIBRARY MANAGEMENT SYSTEM");
        	System.out.println("Librarian Menu");
       		System.out.println("1. Add a Book");
        	System.out.println("2. Remove a Book");
        	System.out.print("Choose an option: ");
        	int option = scanner.nextInt();
        	scanner.nextLine();

        	switch(option)
        	{
				case 1:
                System.out.print("Enter Book ID: ");
                String bookID = scanner.nextLine();
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Book Author: ");
                String author = scanner.nextLine();
                System.out.print("Enter Book Genre: ");
                String genre = scanner.nextLine();

                Book newBook = new Book(bookID,title,author,genre);
                librarian.addBook(newBook, library);
                break;

                case 2:
                System.out.print("Enter Book ID to Remove: ");
                String RemoveBook = scanner.nextLine();
                librarian.removeBook(RemoveBook, library);
                break;

                default:
                System.out.println("INVALID OPTION!");
                break;
			}
		}
		else if(memberID.equals("LIBRARY"))
		{
			System.out.println("ADMIN MANAGEMENT");
            System.out.println("1. Add a Book");
            System.out.println("2. Register a Member");
            System.out.println("3. Find a Book by Title");
            System.out.println("4. Borrow a Book");
            System.out.println("5. Return a Book");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
			scanner.nextLine();

            switch (option)
            {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookID = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Book Genre: ");
                    String genre = scanner.nextLine();

                    Book newBook = new Book(bookID, title, author, genre);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter Member Contact: ");
                    String contact = scanner.nextLine();

                    Member newMember = new Member(memberId, memberName, contact);
                    library.registerMember(newMember);
                    System.out.println("Member registered successfully.");
                    break;

                case 3:
                    System.out.print("Enter the Title of the Book to Search: ");
                    title = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(title);
                    if (foundBook != null) {
                        System.out.println("Book Found: ID: " + foundBook.getBookID() + ", Title: " + foundBook.getTitle());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the Book ID to Borrow: ");
                    bookID = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextLine();
                    library.borrowBook(bookID, memberId);
                    System.out.println("Book borrowed successfully.");
                    break;

                case 5:
                    System.out.print("Enter the Book ID to Return: ");
                    bookID = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    memberId = scanner.nextLine();
                    library.returnBook(bookID, memberId);
                    System.out.println("Book returned successfully.");
                    break;

                default:
                    System.out.println("INVALID OPTION!");
                    break;
            }

        }
        else
        {
            System.out.println("INVALID MEMBER ID!");
        }
        System.out.print("DO YOU WANT TO LOG OUT? YES OR NO: ");
        String out = scanner.nextLine();

        if(out.equalsIgnoreCase("no"))
        {
			LogOut = true;
		}
		else
		{
			System.exit(0);
		}
	}

    }
}