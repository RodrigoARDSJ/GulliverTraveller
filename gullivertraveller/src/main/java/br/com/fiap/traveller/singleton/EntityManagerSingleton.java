package br.com.fiap.traveller.singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {

    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("gullivertraveller");
    private static EntityManager manager;

    public static EntityManager getInstance() {
        if (manager == null) manager = FACTORY.createEntityManager();
        return manager;
    }
}
