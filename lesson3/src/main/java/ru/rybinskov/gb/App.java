package ru.rybinskov.gb;

import jdk.internal.dynalink.linker.LinkerServices;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws InterruptedException {

        EntityManagerFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = entityFactory.createEntityManager();
        //   Config.init(em);

        Product milk = new Product();
        milk.setTitle("Milk");
        milk.setPrice(60L);
        createProductEntity(em, milk);
        saveProductEntity(em, milk);

        Product bread = new Product();
        bread.setTitle("bread");
        bread.setPrice(30L);
        createProductEntity(em, bread);
        saveProductEntity(em, bread);

        Product cheese = new Product();
        cheese.setTitle("cheese");
        cheese.setPrice(600L);
        createProductEntity(em, cheese);
        saveProductEntity(em, cheese);

        System.out.println("Продукты созданы, ждём");
        Thread.sleep(2500);

        User user1 = new User();
        user1.setName("Alexandr");
        createUserEntity(em, user1);
        saveUserEntity(em, user1);
        user1.setProducts(Arrays.asList(bread, milk));

        System.out.println("С первым клиентом закончили, ждём");
        Thread.sleep(1500);

        User user2 = new User();
        user2.setName("Elena");
        createUserEntity(em, user2);
        saveUserEntity(em, user2);
        System.out.println("Со вторым клиентом закончили, ждём");
        Thread.sleep(1500);


        //Почему он не срабатывает?
        user2.setProducts(Arrays.asList(milk));
        Thread.sleep(1500);
        {
            System.out.println("Клиент " + user1.getName() + " купил:");
            User user = readEntity(em, 4L);
            List<Product> list = user.getProducts();
            for (Product product : list) {
                System.out.println(product.getTitle() + ", цена: " + product.getPrice());
            }
        }
        {
            System.out.println("Клиент " + user2.getName() + " купил:");
            User user = readEntity(em, 5L);
            List<Product> list = user.getProducts();
            for (Product product : list) {
                System.out.println(product.getTitle() + ", цена: " + product.getPrice());
            }
        }

    }


    private static User readEntity(EntityManager em, long id) {
        System.out.println("Start reading");

        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();

        System.out.println("Reading completed->" + user);
        return user;
    }

    private static void saveUserEntity(EntityManager em, User entity) {
        System.out.println("Start saving");

        em.getTransaction().begin();
        User savedEntity = em.merge(entity);
        em.getTransaction().commit();

        System.out.println("Saving completed->" + savedEntity);
    }


    private static void createUserEntity(EntityManager em, User entity) {
        System.out.println("Creating entity");
        //open transaction
        em.getTransaction().begin();
        //put person into persist area of Hibernate
        em.persist(entity);
        //commit/close transaction
        em.getTransaction().commit();
        System.out.println("Creating finished");
    }

    private static void saveProductEntity(EntityManager em, Product entity) {
        System.out.println("Start saving");

        em.getTransaction().begin();
        Product savedEntity = em.merge(entity);
        em.getTransaction().commit();

        System.out.println("Saving completed->" + savedEntity);
    }


    private static void createProductEntity(EntityManager em, Product entity) {
        System.out.println("Creating entity");
        //open transaction
        em.getTransaction().begin();
        //put person into persist area of Hibernate
        em.persist(entity);
        //commit/close transaction
        em.getTransaction().commit();
        System.out.println("Creating finished");
    }


}
