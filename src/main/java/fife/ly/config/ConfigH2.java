package fife.ly.config;

import fife.ly.entity.Bed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan("fife.ly.entity")
public class ConfigH2 {
    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).addScript("sql/schema.sql")
                .addScript("sql/data.sql").build();
    }
}
