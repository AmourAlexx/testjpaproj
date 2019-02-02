package ua.com.levelup.jpatestproj.beans;

import org.springframework.stereotype.Component;


public class Apple extends Fruit{

    public Apple(){
        super();
    }

    public Apple(String name){
        super(name);
    }

    @Override
    public String getName() {
        return "apl";
    }
}
