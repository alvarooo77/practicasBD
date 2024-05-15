package nuestroCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MiCRUD {
   // atributtes
   private String driver = "com.mysql.jdbc.Driver";
   private String url = "jdbc:mysql://localhost:3306/";
   private String user = "root";
   private String password = "";
   private Connection connection;
   private Statement statement;
   
   // constructor
   public MiCRUD(String baseDeDatos){
      this.url = this.url.concat(baseDeDatos);
   };

   public boolean initDriver(){
      try {
         Class.forName(driver);
         return true;
      } catch (ClassNotFoundException e) {
         return false;
      }
   }

   public boolean initConnection(){
      this.connection = null;
      try {
         this.connection = DriverManager.getConnection(url, user, password);
         return true;
      } catch (SQLException e) {
         return false;
      } 
   }

   public boolean closeConnection(){
      try {
            this.connection.close();
            return true;
      } catch (SQLException e) {
         return false;
      } catch (NullPointerException e){
         return false;
      }
   }

   public boolean createStatement(){
      try {
         this.statement = connection.createStatement();
         return true;
      } catch (SQLException e) {
         return false;
      }
   }

   // create
   public boolean createTable(String name, MyColumn[] columns, MyConstraint[] constraints){
      String myQuery = "CREATE TABLE ".concat(name)+" (";
      for (int i = 0; i < columns.length; i++) {
         myQuery = myQuery + (columns[i].getColName()) + " " + columns[i].getColType() + " ";
         if (columns[i].isNulleable()){
            myQuery = myQuery +".";
         }else{
            myQuery = myQuery + " NOT NULL"+",";
         }
      }

      for (int j = 0; j < constraints.length; j++) {
         myQuery = myQuery + " CONSTRAINT " + constraints[j].getParams()[0];
         if (constraints[j].getParams().length == 2){  //primary key
            myQuery = myQuery + " PRIMARY KEY (";
            myQuery = myQuery+ constraints[j].getParams()[1] +"),";
         }else{  // foreign key
            myQuery = myQuery + " FOREIGN KEY (";
            myQuery = myQuery+ constraints[j].getParams()[1] +")";
            myQuery = myQuery + " REFERENCES " ;
            myQuery = myQuery + constraints[j].getParams()[2] + "(";
            myQuery = myQuery + constraints[j].getParams()[3] + "),";

         }
      }
      
   }
   // read
   // update
   // delete
}
