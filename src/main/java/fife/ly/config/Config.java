package fife.ly.config;

import fife.ly.entity.Bed;
import fife.ly.entity.Pillow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Bed bed(){
        Bed bed=new Bed();
        bed.setPillow(pillow());
        return bed;
    }
    @Bean
    public Pillow pillow(){
        Pillow pillow= new Pillow();
        pillow.setName("枕头1");
        return pillow;
    }
}
