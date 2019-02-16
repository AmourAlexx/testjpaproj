package ua.com.levelup.jpatestproj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.com.levelup.jpatestproj.beans.Apple;
import ua.com.levelup.jpatestproj.beans.Apricot;
import ua.com.levelup.jpatestproj.beans.Fruit;
import ua.com.levelup.jpatestproj.beans.Peach;
import ua.com.levelup.jpatestproj.model.Film;
import ua.com.levelup.jpatestproj.repo.FilmRepo;

import java.util.List;

public class Main {

    public static void main(String[] args){
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext(MyConfig.class);

        FilmRepo r = ctx.getBean(FilmRepo.class);
        List<Film> lst = r.findByTitleLikeAndRentalRate("film 1", 4.6);
    }
}
