/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManagement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author MSI
 */
public class Main extends Application {
    
       @Override
    public void start(Stage stage) 
    {

        try
         {
              Parent root = FXMLLoader.load(getClass().getResource("LoginInterface.fxml"));
              Scene scene = new Scene(root);
              //stage.resizableProperty().setValue(false); //deable window maximizer
              stage.initStyle(StageStyle.UTILITY); //remove Max & Min option
              stage.setScene(scene);
              stage.setTitle("BOOKSTORE");
              
              stage.show();
          }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

      }
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
