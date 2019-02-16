package ua.com.levelup.jpatestproj.model.dao;

import ua.com.levelup.jpatestproj.model.User;
import ua.com.levelup.jpatestproj.service.EM;

import javax.persistence.EntityManager;

public class UserDAO implements DAO<User> {

    private User obj;

    public UserDAO(User u){
        obj = u;
    }

    @Override
    public User save() {
        EntityManager em = EM.getInstance();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        return obj;
    }

    @Override
    public boolean remove() {
        try {
            EntityManager em = EM.getInstance();
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            return true;
        } catch (Throwable t) {
            t.printStackTrace();
            return false;
        }
    }
}
