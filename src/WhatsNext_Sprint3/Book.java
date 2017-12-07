/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

/**
 *
 * @author Laura
 */
public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String genre;
    private String bookDescription;
    
    public Book(String aBookTitle, String aBookAuthor, String aGenre, String aBookDescription){
        this.bookTitle = aBookTitle;
        this.bookAuthor = aBookAuthor;
        this.genre = aGenre;
        this.bookDescription = aBookDescription;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
    
}
