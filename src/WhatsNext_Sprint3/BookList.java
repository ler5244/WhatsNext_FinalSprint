/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Laura 
 */
public class BookList implements Serializable{
    private ArrayList <Book> bookList;
    
    public BookList() {
        
        bookList = new ArrayList();
        
        Book book1 = new Book("The Great Gatsby","F. Scott Fitzgerald","Drama","Parties in New York");
        Book book2 = new Book("The Hunger Games", "Suzanne Collins", "Thriller", "The Hunger Games follows 16-year-old Katniss Everdeen, a girl from District 12 who volunteers for the 74th Hunger Games in place of her younger sister Primrose Everdeen. Also selected from District 12 is Peeta Mellark. They are mentored by their district's only living victor, Haymitch Abernathy, who won 24 years earlier and has since led a solitary life of alcoholism.");
        Book book3 = new Book("Harry Potter and the Sorcerer's Stone","J. K. Rowling","Fantasy","Harry's life is about to change when a mysterious letter arrives by owl messenger. A letter with an invitation to a wonderful place he never dreamed existed. There he finds not only friends, aerial sports, and magic around every corner, but a great destiny that's been waiting for him... if Harry can survive the encounter.");
        Book book4 = new Book("The Lightning Thief","Rick Riordan","Fantasy","The Lightning Thief is a 2005 fantasy-adventure novel based on Greek mythology, the first young adult novel written by American author Rick Riordan.");
        Book book5 = new Book("","","","");
        Book book6 = new Book("","","","");
        Book book7 = new Book("","","","");
        Book book8 = new Book("","","","");
        Book book9 = new Book("","","","");
        Book book10 = new Book("","","","");
        
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
    }
    
    public void addBooks(Book book)
    {
        getBookList().add(book);
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}
