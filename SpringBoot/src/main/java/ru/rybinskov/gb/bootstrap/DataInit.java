package ru.rybinskov.gb.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.rybinskov.gb.domain.Product;
import ru.rybinskov.gb.domain.Role;
import ru.rybinskov.gb.domain.User;
import ru.rybinskov.gb.repository.ProductJpaDAO;
import ru.rybinskov.gb.repository.UserDao;

@Component
public class DataInit implements CommandLineRunner {

    public static final User USER = new User();
    public static final User MANAGER = new User();
    public static final User ADMIN = new User();

    public final ProductJpaDAO productJpaDAO;
    public final UserDao userDao;

    static {
        USER.setName("User");
        USER.setPassword("123");
        USER.setRole(Role.USER);

        MANAGER.setName("Manager");
        MANAGER.setPassword("123");
        MANAGER.setRole(Role.MANAGER);

        ADMIN.setName("Admin");
        ADMIN.setPassword("admin");
        ADMIN.setRole(Role.ADMIN);
    }

    public DataInit(ProductJpaDAO productJpaDAO, UserDao userDao) {
        this.productJpaDAO = productJpaDAO;
        this.userDao = userDao;
    }


    public static void init(ProductJpaDAO productJpaDAO, UserDao userDao) {
        productJpaDAO.save(new Product("сыр", 550));
        productJpaDAO.save(new Product("лук", 10));
        productJpaDAO.save(new Product("чеснок", 10));
        productJpaDAO.save(new Product("колбаса", 800));
        productJpaDAO.save(new Product("хлеб", 35));
        productJpaDAO.save(new Product("молоко", 45));
        productJpaDAO.save(new Product("мороженое", 40));
        productJpaDAO.save(new Product("ветчина", 700));
        productJpaDAO.save(new Product("свинина", 400));
        productJpaDAO.save(new Product("говядина", 500));
        productJpaDAO.save(new Product("макароны", 60));
        productJpaDAO.save(new Product("ячка", 50));
        productJpaDAO.save(new Product("рис", 60));
        productJpaDAO.save(new Product("яйца", 80));
        productJpaDAO.save(new Product("булка сдобная", 20));
        productJpaDAO.save(new Product("круассан", 50));
        productJpaDAO.save(new Product("бублики", 70));
        productJpaDAO.save(new Product("баранки", 80));
        productJpaDAO.save(new Product("котлеты", 80));
        productJpaDAO.save(new Product("товар", 80));
        productJpaDAO.save(new Product("товар1", 80));
        productJpaDAO.save(new Product("товар2", 80));
        productJpaDAO.save(new Product("товар3", 80));
        productJpaDAO.save(new Product("товар4", 80));
        productJpaDAO.save(new Product("товар5", 80));
        productJpaDAO.save(new Product("товар6", 80));
        productJpaDAO.save(new Product("товар7", 80));
        productJpaDAO.save(new Product("товар8", 80));
        productJpaDAO.save(new Product("товар9", 80));
        productJpaDAO.save(new Product("товар10", 80));
        productJpaDAO.save(new Product("товар11", 80));
        productJpaDAO.save(new Product("товар12", 80));
        productJpaDAO.save(new Product("товар13", 80));
        productJpaDAO.save(new Product("товар14", 80));

        userDao.save(USER);
        userDao.save(MANAGER);
        userDao.save(ADMIN);
    }

    @Override
    public void run(String... args) throws Exception {
        init(productJpaDAO, userDao);
    }
}
