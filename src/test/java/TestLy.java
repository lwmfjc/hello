import org.junit.Test;

import java.sql.*;

public class TestLy {
    @Test
    public void testSimpleDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicdb?useSSL=true&serverTimezone=UTC",
                    "prospring5","prospring5");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SINGER");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("first_name"));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
