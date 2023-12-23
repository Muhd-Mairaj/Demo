package Q2;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public Book search(String title) {
        // binary search on titles
        int low = 0;
        int high = books.size() - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;

            if (title.compareTo(books.get(mid).getTitle()) < 0) {
                high = mid;
            }
            else if (title.compareTo(books.get(mid).getTitle()) > 0) {
                low = mid + 1;
            }
            else {
                return books.get(mid);
            }
        }
        System.out.println("Did not find a matching book.");
        return null;
    }
    
    public ArrayList<Book> findAll(String author) {
        // Return a list of all books from the author, or null
        ArrayList<Book> result = new ArrayList<>();
        
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        
        return (result.isEmpty()) ? null : result;
    }
    
    public boolean borrow(Book book) {
        if (book == null) {
            System.out.println("Invalid request.");
            return false;
        }
        
        Book b = this.search(book.getTitle());
        if (b == null) {
            System.out.println("This book does not exist in the library");
            return false;
        }
        
        String ISBN = b.getISBN();
        int endCode = Integer.parseInt(ISBN) % 100;
        
        if (isPrime(endCode)) {
            System.out.println("This book cannot be borrowed");
            return false;
        }
        
        b.setBorrowed(true);
        System.out.println("Borrowed book with ISBN: " + b.getISBN());
        return true;
    }
    
    public void returnBook(Book book) {
        Book b = this.search(book.getTitle());
        if (b == null) {
            System.out.println("This book does not belong in this library.");
            return;
        }
        
        b.setBorrowed(false);
    }
    
    public void add(Book book) {
        this.books.add(book);
        sortBooks(); // sort after adding a book so binary search can be done
    }
    
    public boolean remove(Book book) {
        if (this.books.remove(book)) {
            System.out.println("Succesfully removed book with ISBN: " + book.getISBN());
            return true;
        }
        
        System.out.println("Did not find the specified book");
        return false;
    }
    
    public void sortBooks() {
        mergeSortBooks(this.books, 0, this.books.size() - 1);
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
}
