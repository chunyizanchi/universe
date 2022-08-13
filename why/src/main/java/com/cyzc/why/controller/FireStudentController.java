package com.cyzc.why.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyzc.why.entity.FireStudent;
import com.cyzc.why.mapper.FireStudentMapper;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/11 17:17]
 */
@RestController("/fireStudent")
@Slf4j
public class FireStudentController {

    @Autowired
    private FireStudentMapper fireStudentMapper;

    public void change() {

        IPage<FireStudent> fireStudentIPage=new Page<>();
        System.out.println();

        List<FireStudent> fireStudents = fireStudentMapper.selectList(null);
        log.info("student list {}", fireStudents);

        fireStudents.forEach(item -> {

        });

    }


    String getResult(FireStudent student) {

        String result="";

        String one = student.getOne();
        String two = student.getTwo();
        String three = student.getThree();
        String four = student.getFour();
        String five = student.getFive();

        int passCount = 0;
        //优秀
        int excellentCount = 0;
        //良好
        int goodCount = 0;

        addCount(one, passCount, excellentCount, goodCount);
        addCount(two, passCount, excellentCount, goodCount);
        addCount(three, passCount, excellentCount, goodCount);
        addCount(four, passCount, excellentCount, goodCount);
        addCount(five, passCount, excellentCount, goodCount);
        log.info("passCount {} goodCount {} excellentCount {}", passCount, goodCount,
                excellentCount);

        double rate = BigDecimal.valueOf((float) (excellentCount+goodCount)/5).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        double rate2=BigDecimal.valueOf((float) excellentCount/5).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

       /* if (passCount>=3){
            return "及格";
        }else if ((excellentCount+goodCount)>=3){
            return "良好";
        }else if (excellentCount>=3||)

        if ((goodCount==4&&rate2>0.5)||rate2>0.7){
            result="优秀";
        }else if (rate>0.6){
            result="良好";
        }else {
            result="及格";
        }*/
        return result;

    }

    public void addCount(String s, int passCount, int excellentCount, int goodCount) {

        switch (s) {
            case "优秀":
                excellentCount++;
                break;
            case "良好":
                goodCount++;
                break;
            case "及格":
                passCount++;
                break;
        }


    }
}
