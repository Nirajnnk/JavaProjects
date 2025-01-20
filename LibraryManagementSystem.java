

import java.util.ArrayList;
import java.util.Scanner;

// Book class to represent a book
class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        title.toLowerCase();
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("You have successfully borrowed \"" + title + "\".");
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You have successfully returned \"" + title + "\".");
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Status: " + (isBorrowed ? "Borrowed" : "Available");
    }
}

// Library class to manage books
class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: \"" + title + "\" by " + author);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books available in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book not found: \"" + title + "\".");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found: \"" + title + "\".");
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter the title of the book to borrow: ");
                    title = scanner.nextLine();
                    library.borrowBook(title);
                    break;
                case 4:
                    System.out.print("Enter the title of the book to return: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case 5:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}