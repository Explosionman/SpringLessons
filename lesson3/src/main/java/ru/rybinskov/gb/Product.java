package ru.rybinskov.gb;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products_tbl")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Long price;

    @ManyToMany
    @JoinTable(name = "purchases_tbl",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setCategories(List<User> users) {
        this.users = users;
    }
}
