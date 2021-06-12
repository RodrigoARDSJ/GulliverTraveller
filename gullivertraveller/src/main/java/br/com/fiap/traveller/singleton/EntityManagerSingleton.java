package br.com.fiap.traveller.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {

    private static EntityManagerFactory factory;

    public static EntityManagerFactory getInstance() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("easypark");
        }
        return factory;
    }

    private EntityManagerSingleton() {
    }
}
