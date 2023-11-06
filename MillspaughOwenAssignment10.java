
public class MillspaughOwenAssignment10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book[] bookList = new Book[6];
		
		Book book1 = new Book("Big Java: Early Objects","Cay Horstmann",708);
			bookList[0] = book1;
		Book book2 = new Book("Grokking Algorithms", "Aditya Bhargava", 238);
			bookList[1] = book2;
		Book book3 = new Book("The C++ Programming Language","Bjarne Stroustrup",1376);
			bookList[2] = book3;
		Book book4 = new Book("The Elements of Java Style","Jim Shur",144);
			bookList[3] = book4;
		Book book5 = new Book("The Design of Everyday Things","Don Norman",368);
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
	        
	        return smallestBook.getTitle() + " By: " + smallestBook.getAuthor() + ", " + smallestBook.getNumPages() + " Pages";	    }
			

}

class Book{
	private String title = "";
	private String author = "";
	private int numPages = 0;
	
	public Book(String title, String author, int numPages) {
		this.title = title;
		this.author = author;
		this.numPages = numPages;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor(){
		return author;
	}
	public int getNumPages() {
		return numPages;
	}
}
	//class Library() {
	
//}
