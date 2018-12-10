package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
  @FXML
  private Label firstN, lastN;

  @FXML
  void testPress(ActionEvent event) {
    //Database path
    final String Database_Url =
        "jdbc:derby:C:\\Users\\Brandon\\OneDrive.old\\BooksDataBaseProject\\lib\\books";
    final String Select_Query = "SELECT authorID, firstName, lastName FROM authors";
    try (
        //find bugs: hardcoded constant to database
        //books database username and password
        Connection connection = DriverManager.getConnection(//Connect to database
            Database_Url, "deitel", "deitel");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Select_Query)) {
      resultSet.next();
      //add content of table to column in window
      firstN.setText(resultSet.getString(2));
      lastN.setText(resultSet.getString(3));
      //Exception
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }
}
