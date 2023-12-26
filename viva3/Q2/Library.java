package Q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> findBooksByTitle(String title) {
        // Return a list of all books with the title, or null
        ArrayList<Book> result = new ArrayList<>();
        
        for (Book book: this.books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.display();
                result.add(book);
            }
        }
        
        return (result.isEmpty()) ? null : result;
    }
    
    public ArrayList<Book> findBooksByAuthor(String author) {
        // Return a list of all books from the author, or null
        ArrayList<Book> result = new ArrayList<>();

        System.out.println("Books by author '" + author + "':");
        for (Book book: this.books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.display();
                result.add(book);
            }
        }
        
        return (result.isEmpty()) ? null : result;
    }
    
    public boolean borrowBook(String ISBN) {
        int d = Integer.parseInt(ISBN.substring(ISBN.length() - 2));
        
        if (isPrime(d)) {
            return false;
        }
        
        for (Book book: this.books) {
            if (book.getISBN().equals(ISBN)) {
                if (book.getBorrowed()) { //  check if the book is already borrowed
                    return false;
                }
                book.setBorrowed(true);
                return true;
            }
        }
        
        return false;
    }

    
    public void returnBook(Book book) {
        Book b = this.findBooksByTitle(book.getTitle());
        if (b == null) {
            return;
        }
        
        b.setBorrowed(false);
    }
    
    public void addBook(Book book) {
        this.books.add(book);
    }
    
    public boolean removeBook(String ISBN) {
        for (Book book: this.books) {
            if (book.getISBN().equals(ISBN)) {
                this.books.remove(book);
                return true;
            }
        }
        
        return false;
    }
    
    public void sortBooks() {
        Collections.sort(this.books, new SortBookByTitleComparator());
        System.out.println("Books in the library, sorted by title:");
        this.displayLibrary();
    }
    
    private boolean isPrime(int n) {
        boolean prime = n > 1;
        
        for (int i = 3; i < n; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        
        return prime;
    }
        
    public void displayLibrary() {
        for (Book book: this.books) {
            book.display();
            System.out.println();
        }
    }
}

// Comparator for sorting Books
// reference:
// https://www.geeksforgeeks.org/comparator-interface-java/
class SortBookByTitleComparator implements Comparator<Book> {
    
    public int compare(Book a, Book b) {
        return a.getTitle().compareTo(b.getTitle());
    }
}
