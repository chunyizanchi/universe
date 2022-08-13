package com.cyzc.why.controller;

import com.cyzc.why.entity.Student;
import com.cyzc.why.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <> fixme 高并发下的请求合并
 *
 * @author Cyzc
 * @since [2021/12/06 12:59]
 */
@RestController("/hystrix")
public class HystrixController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/student/{id}")
    public Student queryById(@PathVariable Integer id){
        return studentService.queryById(id);
    }

}
