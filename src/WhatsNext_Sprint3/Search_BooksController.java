/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class Search_BooksController {
    @FXML private AnchorPane pane;
    @FXML private TextField searchTerms;
    
    private ArrayList<Book> results;
    
    @FXML protected void handleBookFilterButtonAction(ActionEvent event) {
        
        
        try{
            Stage stage1 = (Stage)pane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Filters_Books.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            //stage1.setWidth(600);
            Scene scene = new Scene(root, 600, 600);
            stage1.setScene(scene);

            stage1.show();
        }catch(Exception e){

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
    
    @FXML protected void handlSearchMenuButtonAction(ActionEvent event) {
        
        String text = searchTerms.getText();
        
        text = text.toLowerCase();
        
        
        ArrayList<String> terms = new ArrayList<>(Arrays.asList(text.split(" ")));
        
        Query query = new Query(null, terms, null); // Creates a query of only positive terms.
        TheSearchEngine search = new TheSearchEngine();
        results = search.bookSearch(query);       
        System.out.println(results);
        
        
        try{
            Stage stage1 = (Stage)pane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchResult.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root, 600, 600);
            stage1.setScene(scene);
            stage1.show();
            SearchResultUIController theSearchResultsController = SearchResultUIController.getSearchResultUIController();
            //theSearchResultsController.setBookList(results);
        }catch(Exception e){

        }
    }
}
