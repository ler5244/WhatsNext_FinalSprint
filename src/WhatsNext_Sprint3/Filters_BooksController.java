/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

/**
 *
 * @author mattb
 */

import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Filters_BooksController {
    
    @FXML private CheckBox comedy;
    @FXML private CheckBox drama;
    @FXML private CheckBox mystery;
    @FXML private CheckBox fantasy;
    @FXML private CheckBox horror;
    @FXML private CheckBox thriller;
    
    @FXML private CheckBox incognito;
    
    @FXML private Label incognitoSearch;
    
    @FXML private TextField positiveFilters;
    @FXML private TextField negativeFilters;
    
    @FXML private AnchorPane pane;
    private ArrayList<Movie> results;
    
    
    
    @FXML protected void handleSearchAction(ActionEvent event) {
        try{
            String positiveTerms = positiveFilters.getText();
            String negativeTerms = negativeFilters.getText();
            
            negativeTerms = negativeTerms.toLowerCase();
            positiveTerms = positiveTerms.toLowerCase();
            

            ArrayList<String> terms = new ArrayList<>(Arrays.asList(positiveTerms.split(" ")));
            ArrayList<String> negTerms = new ArrayList<>(Arrays.asList(negativeTerms.split(" ")));
            
            ArrayList<String> searchGenres = new ArrayList<>();
            if(comedy.isSelected())
            {
                searchGenres.add("comedy");
            }
            if(drama.isSelected())
            {
                searchGenres.add("drama");
            }
            if(mystery.isSelected())
            {
                searchGenres.add("mystery");
            }
            if(fantasy.isSelected())
            {
                searchGenres.add("fantasy");
            }
            if(horror.isSelected())
            {
                searchGenres.add("horror");
            }
            if(thriller.isSelected())
            {
                searchGenres.add("thriller");
            }    
            
           
            
            Query query = new Query(searchGenres, terms, negTerms); // Creates a query of only positive terms.
            TheSearchEngine search = new TheSearchEngine();
            results = search.movieSearch(query);       
            System.out.println(results);
            
            
            Stage stage1 = (Stage)pane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchResults.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            //stage1.setWidth(600);
            Scene scene = new Scene(root, 600, 600);
            stage1.setScene(scene);
            stage1.show();
            
        }catch(Exception e){

        }
    }
   
}
