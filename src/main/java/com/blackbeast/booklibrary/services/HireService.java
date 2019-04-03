package com.blackbeast.booklibrary.services;

import com.blackbeast.booklibrary.domain.Hire;
import com.blackbeast.booklibrary.repository.BookRepository;
import com.blackbeast.booklibrary.repository.HireRepository;
import com.blackbeast.booklibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@PropertySource("classpath:custom.properties")
public class HireService {

    @Autowired
    HireRepository hireRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserService userService;

    @Value("${libraray.hire.giveBackDays}")
    Integer giveBackDays;

    public List<Hire> getHiresByBookId(Integer id){
        return hireRepository.findByHiredBook_Id(id);

    }
    public void save(Integer bookId){
        Hire hire = new Hire();
        hire.setHiredBook(bookRepository.getBook(bookId));
        hire.setHireUser(userService.getLoggedUser());
        hire.setHireDate(new Date());


    }

}
