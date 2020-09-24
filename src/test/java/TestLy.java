import fife.ly.config.ConfigH2;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.sql.DataSource;
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
    @Test
    public void useH2(){
        GenericApplicationContext context=new AnnotationConfigApplicationContext(ConfigH2.class);
        //context.refresh(); //config文件时refresh会报错
        DataSource dataSource = context.getBean(DataSource.class);
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM phone");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        context.close();
    }
}
