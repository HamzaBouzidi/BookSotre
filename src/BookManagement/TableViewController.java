/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManagement;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class TableViewController  implements Initializable  {

    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_title;
    @FXML
    private TextField tf_author;
    @FXML
    private TextField tf_year;
    @FXML
    private TextField tf_pages;
    @FXML
    private TableColumn<Books, Integer> tv_id;
    @FXML
    private TableColumn<Books, String> tv_title;
    @FXML
    private TableColumn<Books, String> tv_author;
    @FXML
    private TableColumn<Books, Integer> tv_year;
    @FXML
    private TableColumn<Books, Integer> tv_pages;
    @FXML
    private Button inser_btn;
    @FXML
    private Button update_btn;
    @FXML
    private Button delete_btn;
    @FXML
    private TableView<Books> tvBooks;
    
    @FXML
    public void InsertInTable(ActionEvent event) throws IOException
    {
    String query = "INSERT INTO book VALUE(" + tf_id.getText()+ ",'" + tf_title.getText() + "','" + tf_author.getText() + "',"
            + tf_year.getText() + "," +tf_pages.getText() +")";
    executeQuery(query);
    showBooks();
    
    }
    @FXML
    public void UpdateInTable(ActionEvent event) throws IOException
    {
       String query = "UPDATE book SET title = '" + tf_title.getText() + "', author = '"  + tf_author.getText() + "', year = "
            + tf_year.getText() + ", pages = " + tf_pages.getText() + " WHERE id = "+tf_id.getText()+ "";
    executeQuery(query);
    showBooks(); 
    
    }
    @FXML
    public void DeleteInTable(ActionEvent event) throws IOException
    {
    String query = "DELETE FROM book WHERE id=" + tf_id.getText()+"";
    executeQuery(query);
    showBooks();
    }
    private void executeQuery(String query)
    {
     Connection conn = getConnection();
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        @FXML
    private void OnTableClick(MouseEvent event)
    {
      Books book= tvBooks.getSelectionModel().getSelectedItem();
      tf_id.setText(""+book.getId());
      tf_title.setText(book.getAuthor());
      tf_author.setText(book.getAuthor());
      tf_year.setText(""+book.getYear());
      tf_pages.setText(""+book.getPages());
    }
    
public Connection getConnection()
{   Connection connect;
    try {
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookStore","root","");
        return connect;
    } catch (Exception e) {
        System.out.println("Error"+e.getMessage());
        return null;
    }
}
public ObservableList<Books> getBooksList()
{
    ObservableList<Books> BookList =FXCollections.observableArrayList();
    Connection conn = getConnection();
    String query ="SELECT* FROM book";
    try {
        Statement st=conn.createStatement();
        ResultSet rs =st.executeQuery(query); 
        while(rs.next())
        {
         Books books= new Books(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getInt("year"),rs.getInt("pages"));
         BookList.add(books);
        }
    } catch (Exception e) {
        e.getStackTrace();
    }
        return BookList;
}
public void showBooks()
{
        ObservableList<Books> list = getBooksList();
        tv_id.setCellValueFactory(new PropertyValueFactory<Books,Integer>("id"));
        tv_title.setCellValueFactory(new PropertyValueFactory<Books,String>("title"));
        tv_author.setCellValueFactory(new PropertyValueFactory<Books,String>("author"));
        tv_year.setCellValueFactory(new PropertyValueFactory<Books,Integer>("year"));
        tv_pages.setCellValueFactory(new PropertyValueFactory<Books,Integer>("pages"));
        
        tvBooks.setItems(list);
}

/*private boolean NotEmpty()
{
if(tf_id.getText().isEmpty() || tf_author.getText().isEmpty() || tf_pages.getText().isEmpty() | tf_title.getText().isEmpty() || tf_year.getText().isEmpty())
{
    Alert alert=new Alert(Alert.AlertType.WARNING);
    alert.setTitle("VALIDATE FIELDs");
    alert.setHeaderText(null);
    alert.setContentText("NO EMPTY FIELD IS ALLOWED");
    alert.showAndWait();
    
    return false;
}
  else
  { return true; }
}
*/
/*private boolean IsInteger()
{ 
     try {
         Integer.parseInt(tf_id.getText());
         Integer.parseInt(tf_pages.getText());
         Integer.parseInt(tf_year.getText());
         
        
    } catch (NumberFormatException e) {
        return false;
    }
        return true;
   
}
*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
        
}

    



