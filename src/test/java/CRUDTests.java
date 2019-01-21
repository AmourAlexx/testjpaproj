import model.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CRUDTests {

    private EntityManager em;

    private Long testId = 7L;

    @Before
    public void setUp() throws Exception {
        em = Persistence
                .createEntityManagerFactory("testPU")
                .createEntityManager();
    }

    @Test
    public void create() {
        em.getTransaction().begin();
        User a = new User();
        a.setLogin("Test");
        a.setEmail("test@test.com");
        a.setPassword("qwerty");
        em.persist(a);
        em.getTransaction().commit();
        testId = a.getId();
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
        return (User)em.createNamedQuery("User.finById", User.class)
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
