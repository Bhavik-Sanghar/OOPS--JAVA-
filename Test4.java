// Book Class:
// Create a class named Book with attributes:
// bookId (int)
// title (String)
// author (String)
// isAvailable (boolean)
// Implement methods:
// displayBookInfo(): Displays information about the book, including whether it's available or checked out.
class Book {
    int bookId;
    String title;
    String author;
    boolean isAvailable;

    public Book(int bookId, String title, String author, boolean isAvailable) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    public void displayBookInfo() {
        System.out.println("Book id is: " + bookId);
        System.out.println("Book title is: " + title);
        System.out.println("Book author is: " + author);
        System.out.println("Book is Available: " + isAvailable);
    }
}

// Library Class:
// Create a class named Library with attributes:
// books (an array or list of Book objects)
// Implement methods:
// addBook(Book book): Adds a book to the library.
// displayAvailableBooks(): Displays information about available books in the library.
// checkOutBook(int bookId): Marks a book as checked out.
// returnBook(int bookId): Marks a checked-out book as returned.
class Library {
    Book books[];

    public Library(Book books[]) {
        this.books = books;
    }

    public void addBook(Book newBook) {
        if (books != null) {
            // Copy existing books to a new array with increased size
            Book[] newBooks = new Book[books.length + 1];
            System.arraycopy(books, 0, newBooks, 0, books.length);
            // Add the new book to the end of the array
            newBooks[newBooks.length - 1] = newBook;
            // Update the library's books array
            books = newBooks;
            System.out.println("Book added successfully!");
        } else {
            // If the array is null, create a new array with a single element
            books = new Book[] { newBook };
            System.out.println("Book added successfully!");
        }
    }

    public void displayAvailableBooks() {
        boolean availableBooksExist = false;

        if (books != null) {
            for (Book book : books) {
                if (book.isAvailable) {
                    availableBooksExist = true;
                    System.out.println("-------------------------------");
                    System.out.println("Book id is: " + book.bookId);
                    System.out.println("Book title is: " + book.title);
                    System.out.println("Book author is: " + book.author);
                    System.out.println("-------------------------------");
                }
            }
        }

        if (!availableBooksExist) {
            System.out.println("No Available Books.");
        }
    }

    public void checkOutBook(int bookId) {
        boolean bookFound = false;

        for (Book book : books) {
            if (book.bookId == bookId) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("Book checked out successfully.");
                } else {
                    System.out.println("Book is not available for checkout.");
                }

                bookFound = true;
                break; // No need to continue iterating once the book is found
            }
        }

        if (!bookFound) {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(int bookId) {
        boolean bookFound = false;

        for (Book book : books) {
            if (book.bookId == bookId) {
                book.isAvailable = true;
                System.out.println("Book returned successfully.");

                bookFound = true;
                break; // No need to continue iterating once the book is found
            }
        }

        if (!bookFound) {
            System.out.println("Book not found.");
        }
    }
}

public class Test4 {
    public static void main(String[] args) {
        // Create some initial books
        Book book1 = new Book(1, "The Catcher in the Rye", "J.D. Salinger", true);
        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", true);

        // Create a Library instance and pass the initial books
        Library library = new Library(new Book[] { book1, book2 });

        // Display available books before adding a new one
        System.out.println("Available Books Before Adding:");
        library.displayAvailableBooks();

        // Add a new book
        Book newBook = new Book(3, "1984", "George Orwell", true);
        library.addBook(newBook);

        // Display available books after adding a new one
        System.out.println("\nAvailable Books After Adding:");
        library.displayAvailableBooks();

        // Check out a book
        System.out.println("\nChecking Out a Book:");
        library.checkOutBook(2);

        // Display available books after checking out a book
        System.out.println("\nAvailable Books After Checking Out:");
        library.displayAvailableBooks();

        // Return the checked-out book
        System.out.println("\nReturning a Book:");
        library.returnBook(2);

        // Display available books after returning a book
        System.out.println("\nAvailable Books After Returning:");
        library.displayAvailableBooks();
    }
}
