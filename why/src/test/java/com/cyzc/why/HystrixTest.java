package com.cyzc.why;

import com.cyzc.why.entity.Student;
import com.cyzc.why.service.StudentService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/06 16:13]
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class HystrixTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testHystrix() throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(20);

        CountDownLatch countDownLatch = new CountDownLatch(20);

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    countDownLatch.await();
                    final Student student = studentService.queryById(finalI);
                    log.info("student:{}",student);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();
        }

        Thread.currentThread().join();

    }


}
