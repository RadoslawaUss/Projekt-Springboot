package com.blackbeast.booklibrary.services;

import com.blackbeast.booklibrary.domain.Hire;
import com.blackbeast.booklibrary.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HireServiceTest {
    private static final Integer BOOK_EXISTS = 2;
    private static final Integer BOOK_NOT_EXISTS = 1;
    private static final long HIRES_COUNT = 2;
    private static final Integer BOOK_HIRED = 2;
    private static final Integer BOOK_NOT_HIRED = 15;


    @Autowired
    HireService hireService;
    @Autowired
    UserService userService;

    @Test
    public void getHiresByBookIdTest() {
        List<Hire> hiresNotExists = hireService.getHiresByBookId(BOOK_NOT_EXISTS);
        assertNotNull(hiresNotExists);
        assertTrue(hiresNotExists.isEmpty());

        List<Hire> hiresExists = hireService.getHiresByBookId(BOOK_EXISTS);
        assertNotNull(hiresExists);
        assertFalse(hiresExists.isEmpty());
        assertEquals(hiresExists.size(), HIRES_COUNT);

    }

    @Test
    public void hireTest1() {
        User user = userService.getUser("admin");

        int bookHiredCountPre = hireService.getHiresByBookId(BOOK_HIRED).size();
        hireService.hire(BOOK_HIRED, user);
        int bookHiredCountPost = hireService.getHiresByBookId(BOOK_HIRED).size();
        assertEquals(bookHiredCountPre, bookHiredCountPost);


    }
    @Test
    public void hireTest2() {
        User user = userService.getUser("admin");

        int bookHiredCountPre = hireService.getHiresByBookId(BOOK_NOT_HIRED).size();
        //hireService.hire(BOOK_NOT_HIRED, user);
        Hire hire = hireService.hire(BOOK_NOT_HIRED, user);
        int bookHiredCountPost = hireService.getHiresByBookId(BOOK_NOT_HIRED).size();
        assertEquals(bookHiredCountPost - bookHiredCountPre, 1);

        if(hire != null) {
            hireService.setHireAsGiveBack(hire.getId());
        }

//        List<Hire> hires = hireService.getHiresByBookId(BOOK_NOT_HIRED);
//
//        for(Hire hire : hires)
//            hireService.setHireAsGiveBack(hire.getId());

    }



}

