import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableBank {
   // Attributes
   String driver = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/bank";
   String login = "root";
   String password = "";
   String createTableBank = "CREATE TABLE banco (" +
         "client VARCHAR(100) NOT NULL, " +
         "password VARCHAR(20) NOT NULL, " +
         "balance Integer NOT NULL, " +
         "PRIMARY KEY(client))";
   Connection connection = null;
   Statement statement = null;

   public void CreateTableBank() throws SQLException {

      statement = connection.createStatement();
      statement.executeUpdate(createTableBank);

   }

   public void initialize() throws ClassNotFoundException, SQLException {
      Class.forName(driver);
      connection = DriverManager.getConnection(url, login, password);
   }

   public void close() throws SQLException {
      try {
         connection.close();
      } catch (SQLException e) {
         throw e;
      }
   }

} // end class