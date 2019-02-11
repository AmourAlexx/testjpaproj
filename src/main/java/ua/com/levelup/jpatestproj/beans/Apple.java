package ua.com.levelup.jpatestproj.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("session")
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

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void saveChanges(){
        //...
    }
}
