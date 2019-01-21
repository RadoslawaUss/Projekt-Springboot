package com.RadoslawaUss.booklibrary.repository;

import com.RadoslawaUss.booklibrary.domain.Book;
import org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class BookRepository {
@PersistenceContext
    private EntityManager em;

 public Collection<Book> getBooks(){
     return em.createQuery("from Book", Book.class).getResultList();

 }
 public Book getBook(int id){
     return em.find(Book.class, id);
 }
 @Transactional
 public void saveBook(Book book){
     if(book!=null)
         em.persist(book);
 }
}
