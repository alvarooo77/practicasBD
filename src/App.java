import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CreateTableBank miTabla = new CreateTableBank();
        miTabla.initConnection();
        miTabla.createStatement();
        miTabla.useStatement();

        miTabla.closeConnection();

    }
}
