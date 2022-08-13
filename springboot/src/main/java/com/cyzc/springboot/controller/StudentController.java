package com.cyzc.springboot.controller;

import com.cyzc.springboot.service.DataService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/16 16:29]
 */
@RestController
public class StudentController {


    @Autowired
    private DataService dataService;

    @RequestMapping(path = "students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") @Range(min = 1, max = 100) int id) {
        dataService.deleteStudent(id);
    }
    @RequestMapping(path = "/helloWorld", method = RequestMethod.GET)
    public String helloWorld() {
        return "helloWorld";
    }

    ;
}
