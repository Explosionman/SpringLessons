package ru.rybinskov.gb;

import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = entityFactory.createEntityManager();

        em.getTransaction().begin();

        List<User> allUsers = em.createNativeQuery("SELECT u FROM User u").getResultList();
        System.out.println(allUsers);
        em.getTransaction().commit();

    }
}
