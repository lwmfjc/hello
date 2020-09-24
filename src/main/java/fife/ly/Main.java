package fife.ly;

import flfe.ly.entity.Bed;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=
                //new AnnotationConfigApplicationContext(Config.class)
                new ClassPathXmlApplicationContext("classpath:context.xml");

        Bed bed=applicationContext.getBean(Bed.class);
        bed.usePillow();
    }
}
