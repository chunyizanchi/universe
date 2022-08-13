package com.cyzc.why.service;

import com.cyzc.why.entity.Student;
import java.util.List;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/06 13:00]
 */
public interface StudentService {

    Student queryById(Integer id);


    List<Student> queryByBatch(List<Integer> ids);
}
