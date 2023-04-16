package com.group19.bookstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Cart {
        @Id
        @GeneratedValue
        private long username;
        @Column
        private String bookName;
        @Column
        private String bookId;
        @Column
        private int price;

        public long getUsername() {
            return username;
        }

        public void setUsername(long username) {
            this.username = username;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
