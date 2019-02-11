package ua.com.levelup.jpatestproj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ua.com.levelup.jpatestproj.beans.Apple;
import ua.com.levelup.jpatestproj.beans.Apricot;
import ua.com.levelup.jpatestproj.beans.Fruit;
import ua.com.levelup.jpatestproj.beans.Peach;

import java.time.LocalDate;

@Configuration
@ComponentScan(basePackages = {"ua.com.levelup.jpatestproj.beans"})
public class MyConfig {


    @Bean
    public Fruit getFruitOfToday(){
        int i = LocalDate.now().getDayOfWeek().getValue()/2;
        switch (i){
            case 1: return new Peach();
            case 2: return new Apple();
            case 3: return new Apricot();
        }
        return null;
    }
}
