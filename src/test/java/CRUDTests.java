import ua.com.levelup.jpatestproj.model.Actor;
import ua.com.levelup.jpatestproj.model.Film;
import ua.com.levelup.jpatestproj.model.Language;
import ua.com.levelup.jpatestproj.model.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

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
        a.setLastName("Sam");
        a.setFirstName("Smith");

        Film f1 = new Film();
        f1.setTitle("Film 2");
        f1.setLength(90);
        f1.setRentalDuration(180);
        f1.setRentalRate(4.5);
        f1.setReplacementCost(24.45);
        a.getFilms().add(f1);

        Language l = new Language();
        l.setName("English");
        f1.setLanguage(l);

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

    @Test
    public void simpleQ() {
        String hql = "select f, a.lastName " +
                "from Film f " +
                "join f.actors a " +
                "where a.lastName like 'Smith' and a.firstName like 'Test'";
        List res = em.createQuery(hql).getResultList();
        System.out.println(res);
    }


    public void criteriaQ(String lastName, String firstName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> query = cb.createQuery(Film.class);
        Root<Film> r = query.from(Film.class);
        query.select(r);
        Join act = r.join("actors");

        List<Predicate> whereBlock = new ArrayList<Predicate>();
        if(lastName != null)
            whereBlock.add(cb.like(act.get("lastName").as(String.class),lastName));
        if(firstName != null)
            whereBlock.add(cb.like(act.get("firstName"),firstName));

        Predicate[] arr = new Predicate[whereBlock.size()];
        whereBlock.toArray(arr);
        query.where(arr);

        List res = em.createQuery(query).getResultList();
        System.out.println(res);
    }

    @Test
    public void critTest() {
        criteriaQ("Smith","Test");
    }

    @Test
    public void springjpa() {

    }
}
