package ua.com.levelup.jpatestproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication//нужно добавить, чтоб класс воспринимался как точка входа в Спринг
@Import(MyConfig.class)//все необходимые конфиги добавить или так, или указать в настройках проекта в Spring-фасетах (Ctrl+Alt+Shift+S)
public class App {

    public static void main(String[] args){
        SpringApplication.run(App.class);//всё, что нужно
        /*ApplicationContext ctx
                = new AnnotationConfigApplicationContext(MyConfig.class);

        FilmRepo r = ctx.getBean(FilmRepo.class);
        LanguageRepo lrepo = ctx.getBean(LanguageRepo.class);

        Language l = lrepo.findById(1L).get();

        List<Film> lst = r.findByReleaseYearAndLanguageOrderByTitle(1990, l);*/
        //List<Film> lst = r.ddd(4.5,1.6);
    }
}
