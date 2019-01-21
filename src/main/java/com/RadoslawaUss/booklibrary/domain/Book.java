package com.RadoslawaUss.booklibrary.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Random;

//@Component
//@Scope("prototype")//utworzą się 2 różne obiekty; zasięg - jak obiekt ma być tworzony - singleton cy może istnieć wiele instacji w kontekście

@Entity
//@Table(name = "book")

public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//automatycznie nadaje id
    //@Column(name = "BookTitle")
    private int id;
    private String title;
    private int year;
    private String publisher;
    private String isbn;

    public  Book(){
        //this.title = "Ogniem i mieczem";
        //this.year = new Random(). nextInt(2000);
        //this.publisher = "Wydawca 123";
        //this.isbn = "ASD123123";
    }

    public String getTitle() {
        return title;
    }

    public Book(String title, int year, String publisher, String isbn) {
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

