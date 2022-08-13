package com.cyzc.why.service.impl;

import com.cyzc.why.entity.Student;
import com.cyzc.why.service.BatchService;
import com.cyzc.why.service.StudentService;
import com.netflix.hystrix.HystrixCollapser.Scope;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.List;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/10 16:38]
 */
@Service
public class BatchServiceImpl implements BatchService {

    private static Logger logger = LoggerFactory.getLogger(BatchServiceImpl.class);

    @Resource
    private StudentService studentService;

    @HystrixCollapser(batchMethod = "getUserBatchById", scope = Scope.GLOBAL,
            collapserProperties = {
                    @HystrixProperty(name = "maxRequestsInBatch", value = "10")
            })
    public Future<Student> getUserById(Integer id) {
        return null;
    }

    @HystrixCommand
    public List<Student> getUserBatchById(List<Integer> ids) {

        logger.info("进入批量处理方法：{}", ids);
        return studentService.queryByBatch(ids);
    }


}
