package service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public final class EM {
    private static final EntityManager instance = Persistence
            .createEntityManagerFactory("testPU")
            .createEntityManager();;

    public static EntityManager getInstance(){
        return instance;
    }
}
