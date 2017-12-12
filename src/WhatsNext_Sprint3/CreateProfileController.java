/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class CreateProfileController {
    @FXML private TextField username;
    @FXML private PasswordField cpassword;
    @FXML private PasswordField password;
    @FXML private AnchorPane pane;
    private UserList userList = new UserList();
    
    
    @FXML protected void handleNewProfileButtonAction(ActionEvent event) {
        String theUsername = username.getText();
        String thePassword = password.getText();
        String theCPassword = cpassword.getText();
        if(thePassword.equals(theCPassword))
        {
            User user = new User(username.getText(), cpassword.getText());
            PersistentDataCntl.getPersistentDataCntl().readSerializedDataModel();
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
    
    @FXML protected void handleBackToMainMenuButtonAction (ActionEvent event) {
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
