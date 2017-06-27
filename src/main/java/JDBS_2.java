import javax.naming.Name;
import java.sql.*;

/**
 * Created by Pc on 25.06.2017.
 */
public class JDBS_2 {
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USERNAME = "postgres";
    private final static String PASS = "qweasdzxc123";

    public static void main(String[] args) {
        Connection connection;
        Driver driver = new org.postgresql.Driver();
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            Statement statement = connection.createStatement();

            statement.execute("INSERT INTO users(name, lastname) VALUES ('Ivan', 'Pupkin')");

            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while(rs.next()){
                System.out.println(rs.getString(1)
                        + " " + rs.getString(2)
                        + " " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
