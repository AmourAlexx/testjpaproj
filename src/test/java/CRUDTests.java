import model.Actor;
import model.Film;
import model.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CRUDTests {

    private EntityManager em;

    private Long testId = 9L;

    @Before
    public void setUp() throws Exception {
        em = Persistence
                .createEntityManagerFactory("testPU")
                .createEntityManager();
    }

    @Test
    public void create() {
        em.getTransaction().begin();
        Actor a = new Actor();
        a.setLastName("Testov");
        a.setFirstName("Test");

        Film f1 = new Film();
        f1.setTitle("Film 1");
        f1.setLength(90);
        f1.setRentalDuration(180);
        f1.setRentalRate(4.5);
        f1.setReplacementCost(24.45);
        a.getFilms().add(f1);

        em.persist(a);
        em.getTransaction().commit();
        testId = a.getActorId();
        System.out.println("create -- "+a);
    }

    @Test
    public void read() {
        User u = findUser(testId);
        System.out.println("read -- "+u);
    }

    @Test
    public void update() {
        em.getTransaction().begin();
        User u = findUser(testId);
        System.out.println("update -- "+u);
        u.setLogin("Sara");
        em.persist(u);
        em.getTransaction().commit();
        System.out.println("update -- "+u);
    }

    @Test
    public void delete() {
        em.getTransaction().begin();
        User u = findUser(testId);
        System.out.println("remove -- "+u);
        em.remove(u);
        em.getTransaction().commit();
        System.out.println("remove -- removed");
    }

    private User findUser(long id){
        return (User)em.createNamedQuery("User.findById", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    /*@Test
    public void name() throws  Exception{
        Class<?> joinTable = Thread.currentThread().getContextClassLoader()
                .loadClass(JoinTable.class.getName());

        System.out.println(Arrays.asList(joinTable.getDeclaredMethods()));
    }*/
}
