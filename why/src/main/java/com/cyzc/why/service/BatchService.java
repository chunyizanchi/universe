package com.cyzc.why.service;

import com.cyzc.why.entity.Student;
import java.util.List;
import java.util.concurrent.Future;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/10 16:38]
 */
public interface BatchService {


    Future<Student> getUserById(Integer id);
    List<Student> getUserBatchById(List<Integer> ids);
}
