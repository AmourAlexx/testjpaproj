import model.Actor;
import model.Film;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.JoinTable;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class CRUDTests {

    private EntityManager em;

    @Before
    public void setUp() throws Exception {
        em = Persistence
                .createEntityManagerFactory("SakilaPersistenceUnit")
                .createEntityManager();
    }

    @Test
    public void read() {
        String hql = "select a from Actor a where a.actorId = 1";
        Actor res = (Actor)em.createQuery(hql).getSingleResult();
        System.out.println(res);

    }

    /*@Test
    public void name() throws  Exception{
        Class<?> joinTable = Thread.currentThread().getContextClassLoader()
                .loadClass(JoinTable.class.getName());

        System.out.println(Arrays.asList(joinTable.getDeclaredMethods()));
    }*/
}
