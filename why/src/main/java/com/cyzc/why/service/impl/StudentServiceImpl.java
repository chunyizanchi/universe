package com.cyzc.why.service.impl;

import com.cyzc.why.entity.Student;
import com.cyzc.why.mapper.StudentMapper;
import com.cyzc.why.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/06 13:00]
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryById(Integer id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> queryByBatch(List<Integer> ids) {
        return studentMapper.selectByIdList(ids);
    }
}
