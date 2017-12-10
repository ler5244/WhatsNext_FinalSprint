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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class SearchResultUIController {
    //this is here because something with SearchResultController isn't working with the .fxml file
    @FXML private AnchorPane pane;
    
    private static SearchResultUIController theSearchResultUIController;
    
    public static SearchResultUIController getSearchResultUIController(){
        if(theSearchResultUIController != null)
        {
            //System.out.println("This works...");
            return theSearchResultUIController;
        } else {
            //System.out.println("This doesn't work...");
            theSearchResultUIController = new SearchResultUIController();
            return theSearchResultUIController;
        }
    }
    
    @FXML protected void handleReturnMainMenuButtonAction(ActionEvent event) {
        
        
        try{
            Stage stage1 = (Stage)pane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            //stage1.setWidth(600);
            Scene scene = new Scene(root, 600, 600);
            stage1.setScene(scene);

            stage1.show();
        }catch(Exception e){

        }
    }
    
        @FXML private ListView list;
    
    private ArrayList<Movie> movieList = new ArrayList<>();
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ListProperty<String> listProperty = new SimpleListProperty<>();
    
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        theSearchResultUIController = this;
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
    
    
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     * @param movieList the movieList to set
     */
    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
        this.bookList = null;
        initialize();
        list.refresh();
    }
    
    
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    /**
     * @param bookList the bookList to set
     */
    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
        this.movieList = null;
        initialize();
        list.refresh();
    }
}
