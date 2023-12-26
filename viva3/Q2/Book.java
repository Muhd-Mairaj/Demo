package Q2;

public class Book {
 
    private String title;
    private String author;
    private String ISBN;
    
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public String getISBN() {
        return this.ISBN;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }
    
    public void display() {
        System.out.println("- Title: " + this.title);
        System.out.println("  Author: " + this.author);
        System.out.println("  ISBN: " + this.ISBN);
    }
    
    public String toString() {
        return String.format("Book[%s]", this.ISBN);
    }
}
