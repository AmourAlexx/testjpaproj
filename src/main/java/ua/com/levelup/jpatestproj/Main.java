package ua.com.levelup.jpatestproj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.com.levelup.jpatestproj.beans.Apple;
import ua.com.levelup.jpatestproj.beans.Apricot;
import ua.com.levelup.jpatestproj.beans.Fruit;
import ua.com.levelup.jpatestproj.beans.Peach;

public class Main {

    public static void main(String[] args){
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(MyConfig.class);

        //Apple a = (Apple)ctx.getBean("apple");
        Peach p = ctx.getBean(Peach.class);
        //Apricot a2 = ctx.getBean("aprMy", Apricot.class);

        Apple a1 = ctx.getBean("iMy",Apple.class);

        Fruit f = ctx.getBean(Fruit.class);
    }
}
