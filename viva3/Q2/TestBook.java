package Q2;

import java.util.ArrayList;

public class TestBook {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        
        Library library = new Library();
        
        Book b1 = new Book("Hi", "Mairaj", "1234567890");
        b1.display();
        System.out.println("");
        
        library.add(b1);
        
        Book b2 = new Book("Bye", "Mairaj", "1234567897");
        b2.display();
        System.out.println("");
        
        library.add(b2);
        
        System.out.println(library.findAll("Mairaj"));
        
        Book b = library.search("Ho");
        library.borrow(b);
        
        b = library.search("Hi");
        library.borrow(b);
    }
}
