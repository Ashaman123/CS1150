public class MillspaughOwenAssignment10 {
    public static void main(String[] args) {
        Book[] bookList = new Book[6];

        Book book1 = new Book("Big Java: Early Objects", "Cay Horstmann", 708);
        bookList[0] = book1;
        Book book2 = new Book("Grokking Algorithms", "Aditya Bhargava", 238);
        bookList[1] = book2;
        Book book3 = new Book("The C++ Programming Language", "Bjarne Stroustrup", 1376);
        bookList[2] = book3;
        Book book4 = new Book("The Elements of Java Style", "Jim Shur", 144);
        bookList[3] = book4;
        Book book5 = new Book("The Design of Everyday Things", "Don Norman", 368);
        bookList[4] = book5;
        Book book6 = new Book("Don't Make Me Think", "Steve Krug", 216);
        bookList[5] = book6;

        System.out.println("*********************************************************");
        System.out.println("Task 1");
        System.out.println("*********************************************************");

        System.out.println(String.format("%-40s %-30s %s", "Title", "Author", "Page Number"));

        for (Book book : bookList) {
            String title = book.getTitle();
            String author = book.getAuthor();
            int numPages = book.getNumPages();

            // Use String.format to align the columns
            String formattedOutput = String.format("%-40s %-30s %d", title, author, numPages);

            System.out.println(formattedOutput);
        }

        String smallestBook = findSmallestBook(bookList);
        System.out.printf("\nSmallest Book: %s%n", smallestBook);
        System.out.println("");
        System.out.println("");
        
        System.out.println("********************************************");
        System.out.println("Part 2: Books In Library");
        System.out.println("********************************************");
        // Task 2
        // Create a Library object with a maximum capacity of 5 books
        Library library = new Library(5);

        // Add your Book objects to the library (you should have already created them)
        if (library.addBook(book1)) {
            System.out.println("Was Big Java: Early Objects added to library? true");
        }
        if (library.addBook(book2)) {
            System.out.println("Was Grokking Algorithms added to library? true");
        }
        if (library.addBook(book3)) {
            System.out.println("Was The C++ Programming Language added to library? true");
        }
        if (library.addBook(book4)) {
            System.out.println("Was The Elements of Java Style added to library? true");
        }
        if (library.addBook(book5)) {
            System.out.println("Was The Design of Everyday Things added to library? true");
        } else {
            System.out.println("No room in library for 6 books");
        }	
        System.out.println("");

        // Call the displayBooks method to display the books in the library
        library.displayBooks();
        System.out.println("");
        
        Book smallestBookInLibrary = library.findSmallestBookInLibrary();
        if (smallestBookInLibrary != null) {
            System.out.printf("\nSmallest Book: %s%n", smallestBookInLibrary.getTitle());
        } else {
            System.out.println("No books available in the library.");
        }
    }

    public static String findSmallestBook(Book[] bookList) {
        if (bookList.length == 0) {
            return "No books available.";
        }

        Book smallestBook = bookList[0];

        for (Book book : bookList) {
            if (book.getNumPages() < smallestBook.getNumPages()) {
                smallestBook = book;
            }
        }

        return smallestBook.getTitle() + " By: " + smallestBook.getAuthor() + ", " + smallestBook.getNumPages() + " Pages";
    }
}

class Book {
    private String title;
    private String author;
    private int numPages;

    public Book(String title, String author, int numPages) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }
}

class Library {
    private Book[] books;
    private int numBooksInLibrary;

    public Library(int maxNumBooks) {
        books = new Book[maxNumBooks];
        numBooksInLibrary = 0;
    }

    public int getNumBooksInLibrary() {
        return numBooksInLibrary;
    }

    public boolean addBook(Book bookToAdd) {
        if (numBooksInLibrary < books.length - 1) {
            books[numBooksInLibrary] = bookToAdd;
            numBooksInLibrary++;
            return true;
        } else {
            return false;
        }
    }

    public Book findSmallestBookInLibrary() {
        if (numBooksInLibrary == 0) {
            return null;
        }

        Book smallestBook = books[0];

        for (int i = 1; i < numBooksInLibrary; i++) {
            if (books[i].getNumPages() < smallestBook.getNumPages()) {
                smallestBook = books[i];
            }
        }

        return smallestBook;
    }

    public void displayBooks() {
        if (numBooksInLibrary == 0) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("Books in the library:");
        for (int i = 0; i < numBooksInLibrary; i++) {
            System.out.println("Title: " + books[i].getTitle());
            System.out.println("Author: " + books[i].getAuthor());
            System.out.println("Pages: " + books[i].getNumPages());
            System.out.println("------------------------");
        }
    }
}
