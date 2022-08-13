package com.cyzc.springboot.service.impl;

import com.cyzc.springboot.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/16 16:25]
 */
@Repository
@Primary
@Slf4j
public class MySQLDataServiceImpl implements DataService {

    @Override
    public void deleteStudent(int id) {
        log.info("MySQLDataServiceImpl.deleteStudent"+id);
    }
}
