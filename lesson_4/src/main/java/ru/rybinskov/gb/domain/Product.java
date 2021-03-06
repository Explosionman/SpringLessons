package ru.rybinskov.gb.domain;

import javax.persistence.*;

    @Entity
    @Table(name = "products_tbl")
    public class Product {
        @Id
        @GeneratedValue
        @Column(name = "product_id")
        private Long id;

        @Column(name = "price_fld")
        private Integer price;

        @Column(name = "title_fld")
        private String title;


        public Product() {
        }

        public Product(String title, Integer price) {
            this.title = title;
            this.price = price;
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

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Product [ id = %d; title = %s; price = %d]", id, title, price);
        }
}
