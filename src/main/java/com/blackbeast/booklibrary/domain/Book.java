package com.blackbeast.booklibrary.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;
import java.util.Set;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "bookTitle")

    @NotNull
    @Size(min=2, message = "Tytuł musi posiadać co najmniej 2 litery")
    private String title;

    @NotNull(message ="Rok wydania musi być z przedziału 1-9999" )
    @Range(max = 2019, message = "Rok wydania musi być z przedziału 1-2019")
    private Integer year;

    @NotNull(message ="Należy podać wydawcę!")
    @Size(min =2, message ="Nazwa wydawcy musi zawierać co najnmiej 2 litery" )
    @Size(max =80, message ="Nazwa wydawcy musi zawierać co najwyżej 80 liter" )

    private String publisher;

    @Size(max =80, message ="Numer ISBN może zawierać co najwyżej 80 znaków" )
    private String isbn;

    @OneToOne
    private @Valid Author author;
    @OneToMany(mappedBy = "hiredBook",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Hire> hires;



    public Book(){


    }

    public Book(String title, Integer year, String publisher, String isbn, Author author) {
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.isbn = isbn;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
