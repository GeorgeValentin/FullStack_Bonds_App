package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "book_name")
    private String bookName;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private Set<Bond> bonds = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public Book(){}

    public Book(int bookId,String bookName, User user) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.user = user;
    }

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }



    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Set<Bond> getBonds() {
        return bonds;
    }

    public void setBonds(Set<Bond> bonds) {
        this.bonds = bonds;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }

}
