package ua.com.levelup.jpatestproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.com.levelup.jpatestproj.model.Film;
import ua.com.levelup.jpatestproj.model.Language;
import ua.com.levelup.jpatestproj.repo.FilmRepo;
import ua.com.levelup.jpatestproj.repo.LanguageRepo;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class);
        /*ApplicationContext ctx
                = new AnnotationConfigApplicationContext(MyConfig.class);

        FilmRepo r = ctx.getBean(FilmRepo.class);
        LanguageRepo lrepo = ctx.getBean(LanguageRepo.class);

        Language l = lrepo.findById(1L).get();

        List<Film> lst = r.findByReleaseYearAndLanguageOrderByTitle(1990, l);*/
        //List<Film> lst = r.ddd(4.5,1.6);
    }
}
