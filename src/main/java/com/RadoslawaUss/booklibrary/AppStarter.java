package com.RadoslawaUss.booklibrary;

import com.RadoslawaUss.booklibrary.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@PropertySource("classpath:custom.properties")
public class AppStarter implements CommandLineRunner {
   //* @Autowired
//    Book book;
//
//    Book book2;
   // @Value("${spring.pagesize:25}")//po dwukropku wartość awaryjna
    //Integer size;

    @Override
    public void run(String... args) throws Exception {
       // System.out.println(book);
        //System.out.println(book2);

       //System.out.println(book==book2);

    }
//@Autowired//wstrzykiwanie przez setter
    //public void setBook2(Book book2) {
      //  this.book2 = book2;
    }

