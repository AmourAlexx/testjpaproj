import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.levelup.jpatestproj.App;
import ua.com.levelup.jpatestproj.MyConfig;
import ua.com.levelup.jpatestproj.repo.FilmRepo;
import ua.com.levelup.jpatestproj.repo.LanguageRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MyConfig.class})
public class SpringTest {

    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private LanguageRepo langRepo;


    @Test
    public void name() {
        filmRepo.findByReleaseYearAndLanguageOrderByTitle(1990,langRepo.findById(1L).get());
    }
}
