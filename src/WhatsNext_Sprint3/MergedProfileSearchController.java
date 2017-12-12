package WhatsNext_Sprint3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MergedProfileSearchController{   
    @FXML private AnchorPane pane;
    
    @FXML protected void handleReturnMainMenuButtonAction (ActionEvent event) {
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
}
