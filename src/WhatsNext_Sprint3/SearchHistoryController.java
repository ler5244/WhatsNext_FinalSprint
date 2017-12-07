package WhatsNext_Sprint3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author djb5755
 */
public class SearchHistoryController{

    @FXML private AnchorPane pane;
    @FXML private ListView recs;
    private ArrayList<Movie> results;
    private ArrayList<Query> history;
    
    private ArrayList<String> masterGenres; 
    private ArrayList<String> masterPositiveFilters; 
    private ArrayList<String> masterNegativeFilters; 
    
    public SearchHistoryController()
    {
        history = LoginController.getLoginController().getTheLoggedInUser().getMovieSearchHistory().queryHistory;
        System.out.println(history);
        if(!history.isEmpty())
        {
            if(history.size() <= 3)
            {
                for(Query q:history)
                {
                    for(String g: q.getGenres())
                    {
                        masterGenres.add(g);
                    }
                    for(String p: q.getPositiveFilters())
                    {
                        masterPositiveFilters.add(p);
                    }
                    for(String n: q.getNegativeFilters())
                    {
                        masterNegativeFilters.add(n);
                    }
                    
                }
            }
            else{
                for(int i = 1; i<=3; i++)
                {
                    Query theQuery = history.get(history.size()-i);
                    for(String g: theQuery.getGenres())
                    {
                        masterGenres.add(g);
                    }
                    for(String p: theQuery.getPositiveFilters())
                    {
                        masterPositiveFilters.add(p);
                    }
                    for(String n: theQuery.getNegativeFilters())
                    {
                        masterNegativeFilters.add(n);
                    }
                    
                }
            }
            
        }
        
        Query historyBasedQuery = new Query(masterGenres, masterPositiveFilters, masterNegativeFilters);
        TheSearchEngine search = new TheSearchEngine();
        results = search.movieSearch(historyBasedQuery);
        System.out.println(results);
        // Show history based recommendations in recs
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
    
    
    
}
