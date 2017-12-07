/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author djb5755
 */
public class SearchResultController implements Initializable {

    private static SearchResultController theSearchResultController;
    
    public static SearchResultController getSearchResultController(){
        if(theSearchResultController != null)
        {
            System.out.println("This works...");
            return theSearchResultController;
        } else {
            System.out.println("This doesn't work...");
            theSearchResultController = new SearchResultController();
            return theSearchResultController;
        }
    }

    
    @FXML private AnchorPane pane;
    @FXML private ListView list;
    
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ListProperty<String> listProperty = new SimpleListProperty<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        theSearchResultController = this;
        if(getMovieList() != null)
        {
            for(Movie m:getMovieList())
            {
                titles.add(m.getMovieTitle());
            }
        }
        else if (bookList != null)
        {
            for(Book b:bookList)
            {
                titles.add(b.getBookTitle());
            }
        }
        listProperty.set(FXCollections.observableArrayList(titles));
        list.itemsProperty().bind(listProperty);
    }    
    
    
    
    /**
     * @return the movieList
     */
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     * @param movieList the movieList to set
     */
    public void setMovieList(ArrayList<Movie> movieList) {
        System.out.println("SET LIST");
        this.movieList = movieList;
        list.refresh();
    }
    
//    public ArrayList<Book> getBookList() {
//        return bookList;
//    }
//
//    
//    public void setBookList(ArrayList<Book> bookList) {
//        System.out.println("SET LIST");
//        this.bookList = bookList;
//        list.refresh();
//    }
}
