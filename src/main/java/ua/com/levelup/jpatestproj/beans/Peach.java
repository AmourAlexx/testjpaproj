package ua.com.levelup.jpatestproj.beans;

import org.springframework.stereotype.Component;

@Component
public class Peach   extends Fruit{

    @Override
    public String getName() {
        return "pch";
    }
}
