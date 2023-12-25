package Q2;

import java.util.ArrayList;

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
    
    public Book findBookByISBN(String ISBN){
        for (Book book: this.books) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                return book;
            }
        }
        
        return null;
    }
    
    public boolean borrowBook(String ISBN) {
        int d1 = ISBN.charAt(ISBN.length()-1) - '0';
        int d2 = ISBN.charAt(ISBN.length()-2) - '0';
        
        if (isPrime(d1) || isPrime(d2)) {
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
        Book book = findBookByISBN(ISBN);
        if (book == null) {
            return false;
        }

        return this.books.remove(book);
    }
    
    public void sortBooks() {
        mergeSortBooks(this.books, 0, this.books.size() - 1);
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
    
    private void mergeSortBooks(ArrayList<Book> books, int start, int end) {
        // base case
        if (start == end) {
            return;
        }
        
        int mid = (start + end) / 2;
        
        // sort left side
        mergeSortBooks(books, start, mid);
        // sort right side
        mergeSortBooks(books, mid + 1, end);
        
        // merge part begins
        int left = start;
        int right = mid + 1;
        int index = 0;
        Book[] temp = new Book[end - start + 1];
        
        while (left <= mid && right <= end) {
            if (books.get(left).compareTo(books.get(right)) <= 0) {
                temp[index] = books.get(left);
                left++;
                index++;
            }
            else {
                temp[index] = books.get(right);
                right++;
                index++;
            }
        }
        
        // copy over remaining left side, if any
        while (left <= mid) {
            temp[index] = books.get(left);
            left++;
            index++;
        }
        // copy over remaining right side, if any
        while (right <= end) {
            temp[index] = books.get(right);
            right++;
            index++;
        }
        
        // copy back to original array
        for (int i = 0; i < index; i++) {
            books.set(start + i, temp[i]);
        }
    }    
    
    public void displayLibrary() {
        System.out.println("Books in the library, sorted by title:");
        for (Book book: this.books) {
            book.display();
            System.out.println();
        }
    }
}
