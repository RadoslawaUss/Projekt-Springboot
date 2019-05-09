package com.blackbeast.booklibrary.controllers;

import com.blackbeast.booklibrary.domain.Book;
import com.blackbeast.booklibrary.domain.Hire;
import com.blackbeast.booklibrary.domain.User;
import com.blackbeast.booklibrary.dto.BookDto;
import com.blackbeast.booklibrary.dto.UserDto;
import com.blackbeast.booklibrary.services.BookService;
import com.blackbeast.booklibrary.services.HireService;
import com.blackbeast.booklibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class HireController{
    @Autowired
    BookService bookService;
    @Autowired
    HireService hireService;
    @Autowired
    UserService userService;


        @RequestMapping(value = "books/hires/{id}", method= RequestMethod.GET)
        public String getHires(Model model, @PathVariable("id") Integer id){
            Book book = bookService.getBook(id);
            List<Hire> hires= hireService.getHiresByBookId(id);
            model.addAttribute("book", book);
                  model.addAttribute("hires", hires);
                  return "hires";

        }


    @RequestMapping(value = "/books/hire/{id}", method = RequestMethod.GET)// przechwycenie linka
    public String hire( Model model, @PathVariable("id") Integer id){
        Hire hire= hireService.hire(id);
        List<BookDto> books = bookService.convert(bookService.getBooks());
        UserDto loggedUser=userService.convert(userService.getLoggedUser());
        model.addAttribute("books", books);
        model.addAttribute("user", loggedUser);
        model.addAttribute("hireStatus", hire!=null);

        if (hire !=null)
            model.addAttribute("giveBackDate", hire.getPlannedGiveBackDate());

        return "books";
    }
    @RequestMapping(value = "/user/hires", method = RequestMethod.GET)
    public String loggedUserHires(Model model) {
        User loggedUser = userService.getLoggedUser();
        UserDto loggedUserDto = userService.convert(loggedUser);
        List<Hire> hires = hireService.getHireListByUserId(loggedUser.getId());

        model.addAttribute("user", loggedUserDto);
        model.addAttribute("hires", hires);

        return "hires-own";
    }

    @RequestMapping(value = "/admin/hires", method = RequestMethod.GET)
    public String notGiveBackHires(Model model) {
        User loggedUser = userService.getLoggedUser();
        UserDto loggedUserDto = userService.convert(loggedUser);
        List<Hire> hires = hireService.getNotGiveBackHireList();

        model.addAttribute("user", loggedUserDto);
        model.addAttribute("hires", hires);
        model.addAttribute("showMessage", Boolean.FALSE);

        return "hires-admin";
    }

    @RequestMapping(value = "/admin/hires/giveback/{id}", method = RequestMethod.GET)

public String giveBack(Model model, @PathVariable("id") Long id){
        User loggedUser = userService.getLoggedUser();
        UserDto loggedUserDto = userService.convert(loggedUser);

        hireService.setHireAsGiveBack(id);
        String bookName = hireService.getHireById(id).getHiredBook().getTitle();
        List<Hire> hires = hireService.getNotGiveBackHireList();

        model.addAttribute("user", loggedUserDto);
        model.addAttribute("hires", hires);
        model.addAttribute("showMessage", Boolean.TRUE);
        model.addAttribute("bookName",bookName);


        return "hires-admin";
    }
}


