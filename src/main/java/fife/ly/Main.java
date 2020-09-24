package fife.ly;

import flfe.ly.entity.Bed;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
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
        /*ApplicationContext applicationContext=
                //new AnnotationConfigApplicationContext(Config.class)
                new ClassPathXmlApplicationContext("classpath:context.xml");

        Bed bed=applicationContext.getBean(Bed.class);
        bed.usePillow();*/
    }
}
