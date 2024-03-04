import java.util.*;

// Define Book class
class Book 
{
    private int id;
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Book(int id, String title, String author, String category) 
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true; 
        
        // Assume all books are initially available
    }

    // Getters and setters
    public int getId() 
    {
        return id;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String getCategory() 
    {
        return category;
    }

    public boolean isAvailable() 
    {
        return available;
    }

    public void setAvailable(boolean available) 
    {
        this.available = available;
    }
}

// Define User class
class User 
{
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) 
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public String getEmail() 
    {
        return email;
    }
}

// Define Library class
class Library 
{
    private List<Book> books;
    private List<User> users;

    public Library() 
    {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) 
    {
        books.add(book);
    }

    // Add a user to the library
    public void addUser(User user) 
    {
        users.add(user);
    }

    // Search for a book by title
    public Book searchBook(String title) 
    {
        for (Book book : books) 
        {
            if (book.getTitle().equalsIgnoreCase(title))
            {
                return book;
            }
        }
        return null; 
        
        // Book not found
    }

    // Issue a book to a user
    public boolean issueBook(Book book, User user) 
    {
        if (book.isAvailable()) 
        {
            book.setAvailable(false);
            return true; 
            
            // Book successfully issued
        }
        return false; 
        
        // Book not available
    }

    // Return a book
    public void returnBook(Book book) 
    {
        book.setAvailable(true);
    }
}

public class LibraryManagementSystem 
{
    public static void main(String[] args) 
    {
        // Create some sample books
        Book book1 = new Book(1, "Icebreaker", "Hannah Grace", "Romance");
        Book book2 = new Book(2, "King of Wrath", "Ana Huang", "Romance");
        Book book3 = new Book(3, "The Fine Print", "Lauren Asher", "Romance");

        // Create some sample users
        User user1 = new User(1, "Mohamed", "mohamed@yahoo.com");
        User user2 = new User(2, "Ava", "ava@gmail.com");

        // Create library instance
        Library library = new Library();

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Add users to the library
        library.addUser(user1);
        library.addUser(user2);

        // Example usage: search and issue a book
        Book searchedBook = library.searchBook("Icebreaker");
        if (searchedBook != null) 
        {
            boolean issued = library.issueBook(searchedBook, user1);
            if (issued) 
            {
                System.out.println("Book issued successfully to " + user1.getName());
            } else 
            {
                System.out.println("Book is not available for issue");
            }
        } else 
        {
            System.out.println("Book not found");
        }
    }
}
