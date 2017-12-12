/*`
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author djb5755
 */
public class WhatsNext extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        PersistentDataCntl.getPersistentDataCntl();
        LoginController login = new LoginController();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root, 600, 600);
        
        stage.setTitle("Welcome to What's Next");
        stage.setScene(scene);
        stage.show();       
       
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
