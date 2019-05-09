package com.blackbeast.booklibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccessController {
    @RequestMapping(value = "/access-denied", method= RequestMethod.GET)
    public String accessDenied(){
        return "access-denied";

    }

}
