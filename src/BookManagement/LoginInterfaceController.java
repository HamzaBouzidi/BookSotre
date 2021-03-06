/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class LoginInterfaceController implements Initializable {

  
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField username_id;
    @FXML
    private PasswordField password_id;
    
    @FXML
    public void SwitchToTableView(ActionEvent event) throws IOException
    {
        if("admin".equals(username_id.getText()) && "admin".equals(password_id.getText()))
        {
              root = FXMLLoader.load(getClass().getResource("TableView.fxml"));
              stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
              Scene scene = new Scene(root); 
              stage.setScene(scene);
              stage.show();
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
             a.setContentText("Invalid Login");
            a.show();
        }
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    }
   
