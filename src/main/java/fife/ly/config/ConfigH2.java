package fife.ly.config;

import fife.ly.entity.Bed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScans(value = {
        @ComponentScan(value = "fife.ly.entity"),
        @ComponentScan(value="fife.ly.dao")
})
public class ConfigH2 {
    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).addScript("sql/schema.sql")
                .addScript("sql/data.sql").build();
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
