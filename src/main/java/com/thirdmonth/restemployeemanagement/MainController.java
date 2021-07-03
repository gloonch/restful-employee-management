package com.thirdmonth.restemployeemanagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"", "/"})
public class MainController {
    public String index(){
        return "";
    }
}
