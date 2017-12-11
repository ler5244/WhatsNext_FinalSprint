package WhatsNext_Sprint3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class Search_MovieController {
    @FXML private AnchorPane pane;
    @FXML private TextField searchTerms;
    private ArrayList<Movie> results;
    
    
    @FXML protected void handleMovieFilterButtonAction(ActionEvent event) {
        
        
        try{
            Stage stage1 = (Stage)pane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Filters_Movies.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            //stage1.setWidth(600);
            Scene scene = new Scene(root, 600, 600);
            stage1.setScene(scene);

            stage1.show();
        }catch(Exception e){

        }
    }
    
    @FXML protected void handleReturnToMainMenuButtonAction(ActionEvent event) {
        
        
        try{
            Stage stage1 = (Stage)pane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            //stage1.setWidth(400);
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
        LoginController.getLoginController().getTheLoggedInUser().getMovieSearchHistory().addToHistory(query);
        
        TheSearchEngine search = new TheSearchEngine();
        results = search.movieSearch(query);
        System.out.println(results);
        
        
        try{
            
            Stage stage1 = (Stage)pane.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchResult.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root, 600, 600);
            stage1.setScene(scene);
            stage1.show();
            SearchResultUIController theSearchResultsController = SearchResultUIController.getSearchResultUIController();
            theSearchResultsController.setMovieList(results);
        }catch(Exception e){

        }
    }
}
