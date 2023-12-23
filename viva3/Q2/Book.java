/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Q2;

/**
 *
 * @author rayya
 */
public class Book {
 
    private String title;
    private String author;
    private String ISBN;
    private boolean borrowed;
    
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.borrowed = false;
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
    
    public boolean getBorrowed() {
        return this.borrowed;
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
    
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
    
    public boolean equals(Book book) {
        if (this.ISBN.equals(book.ISBN)) {
            return true;
        }
        
        return false;
    }
    
    public int compareTo(Book book) {
        return this.title.compareTo(book.title);
    }
    
    public void display() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.ISBN);
        System.out.println("Borrowed: " + this.borrowed);
    }
    
    public String toString() {
        return String.format("Book[%s]", this.ISBN);
    }
}
