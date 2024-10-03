import java.sql.*;

public class Database {

    String url = "jdbc:postgresql://localhost:5432/demo";
    String username= "postgres";
    String password ="1@Global";

    private Connection conn;

    private void connect()
    {
        try {
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established");
        } catch (SQLException e) {
            System.out.println("Connection failed");

        }
    }

    private void close()
    {
        try {
            conn.close();
            System.out.println("Database connection closed");
        } catch (SQLException e) {
            System.out.println("Database connection failed");
        }
    }

    ResultSet executeQuery(String sql)
    {
        connect();
        try {
            Statement st = conn.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close();
        }
    }

    boolean execute(String sql)
    {
        connect();
        try {
            Statement st = conn.createStatement();
            return st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally
        {
            close();
        }
    }
}
