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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author mattb
 */
public class LoginController {

    

    @FXML private Text actiontarget;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private AnchorPane pane;
    private static LoginController theLoginController;
    private UserList userList;
    private User theLoggedInUser;
    
    
    public LoginController()
    {
        theLoginController = this;
        this.userList = new UserList(); // Initializes List
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }
    
    public static LoginController getLoginController(){
        if(theLoginController != null){
            return theLoginController;
        }else{
            theLoginController = new LoginController();
            return theLoginController;
        }
    }
    
    public boolean requestAuthenticate(String authUsername, String authPassword)
    { 
        System.out.println("ButtonPressed");
        
        for(User u:userList.getTheList())
        {
            
            if(authUsername.equals(u.getUsername()))
            {
                System.out.println("Username checked");
                if(authPassword.equals(u.getPassword()))
                {
                    System.out.println("Password checked"); 
                    this.theLoggedInUser = u;
                    return true;
                }
            }
        }
        
        return false;
    }
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        
        
        String u = username.getText();
        String p = password.getText();
        
        boolean isAuthenticated = requestAuthenticate(u, p);

        if(isAuthenticated){
            
            /* Code to open Main Menu goes here*/
            try{
                Stage stage1 = (Stage)pane.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                
                Scene scene = new Scene(root, 600, 600);
//                stage1.setHeight(400);
//                stage1.setWidth(400);
                
                stage1.setScene(scene);

                stage1.show();
            }catch(Exception e){

            }
        }else{
            username.setText(null);
            password.setText(null);
            actiontarget.setText("Enter valid username and password");
        }
       
    }
    
    /**
     * @return the theLoggedInUser
     */
    public User getTheLoggedInUser() {
        return theLoggedInUser;
    }

    
}
