package fife.ly;

import flfe.ly.entity.Bed;
import flfe.ly.entity.Pillow;
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
