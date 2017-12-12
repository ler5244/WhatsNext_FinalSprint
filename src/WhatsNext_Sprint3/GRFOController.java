package WhatsNext_Sprint3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GRFOController{
   @FXML private AnchorPane pane;
   @FXML private Text actiontarget;
   
   @FXML protected void handleMainMenuButtonAction (ActionEvent event) {
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
   
   @FXML protected void handleDanButtonAction (ActionEvent event) {
       try{
           actiontarget.setText("You should watch Avengers!  It's a great movie!");
       }catch(Exception e) {
           
       }
   }
   
   @FXML protected void handleMattButtonAction (ActionEvent event) {
       try{
           actiontarget.setText("You should read Harry Potter!  Definitely my favorite series ever!");
       }catch(Exception e) {
           
       }
   }
   
   @FXML protected void handleLauraButtonAction (ActionEvent event) {
       try{
           actiontarget.setText("Highly recommend watching The Hunger Games!  Was on the edge of my seat!");
       }catch(Exception e) {
           
       }
   }
   
   @FXML protected void handleKrystalButtonAction (ActionEvent event) {
       try{
           actiontarget.setText("Obsessed with The Lightning Thief!  Just bought the sequel on Amazon!");
       }catch(Exception e) {
           
       }
   }
    
}
