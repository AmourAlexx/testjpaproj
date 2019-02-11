package ua.com.levelup.jpatestproj.beans;

import org.springframework.stereotype.Component;

@Component
public class Apricot  extends Fruit{

    @Override
    public String getName() {
        return "apr";
    }
}
