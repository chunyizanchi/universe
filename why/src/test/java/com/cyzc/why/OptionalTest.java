package com.cyzc.why;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cyzc.why.entity.PointsLuckDrawRecord;
import com.cyzc.why.entity.Prize;
import com.cyzc.why.mapper.PointsLuckDrawRecordMapper;
import com.cyzc.why.mapper.PrizeMapper;
import com.cyzc.why.mapper.PrizeRecordMapper;
import com.cyzc.why.service.SellService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/18 11:08]
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class OptionalTest {

    @Autowired
    private PrizeMapper prizeMapper;

    @Autowired
    private SellService sellService;

    @Autowired
    private PrizeRecordMapper prizeRecordMapper;

    @Autowired
    private PointsLuckDrawRecordMapper pointsLuckDrawRecordMapper;

    @Test
    public void testOptionalGet() {

        List<Prize> list = new ArrayList<>();
        list.add(new Prize(1, "1", 1, 1, 1));

        // final List<Prize> prizes = prizeMapper.selectPrizeByActId2(2).ifPresent(null);

        //System.out.println(prizes);
    }

    @Test
    public void testGroupBy() {

        Wrapper<PointsLuckDrawRecord> queryWrapper = null;

        List<PointsLuckDrawRecord> prizeRecords = pointsLuckDrawRecordMapper.selectList(
                null);

        prizeRecords.forEach(item -> {
                    if (ObjectUtils.isEmpty(item.getPoints())) {
                        item.setPoints(0);
                    }
                }

        );

        Map<Long, Integer> collect = prizeRecords.stream()
                .collect(Collectors.groupingBy(PointsLuckDrawRecord::getMemberId,
                        Collectors.summingInt(PointsLuckDrawRecord::getPoints)));

        Map<Long, Optional<PointsLuckDrawRecord>> collects = prizeRecords.stream()
                .collect(Collectors.groupingBy(PointsLuckDrawRecord::getMemberId,
                        Collectors.maxBy(Comparator.comparingInt(PointsLuckDrawRecord::getPoints))));

        Map<Long, Integer> resultMap = new HashMap<>();
        collects.forEach((k, v) -> {
            Integer value = 0;

            if (!v.isPresent()) {
                value = 0;
            } else {
                PointsLuckDrawRecord pointsLuckDrawRecord = v.get();
                value = pointsLuckDrawRecord.getPoints();
            }
            resultMap.put(k, value);
        });

        System.out.println(resultMap);
        JSON parse1 = JSONUtil.parse(resultMap);
        System.out.println(parse1);

       /* List<PointsLuckDrawRecord> collect1 = prizeRecords.stream().map(item -> {
                    PointsLuckDrawRecord pointsLuckDrawRecord = new PointsLuckDrawRecord();
                    pointsLuckDrawRecord.setId(item.getId());
                    pointsLuckDrawRecord.setMemberId(item.getMemberId());
                    pointsLuckDrawRecord.setMemberMobile(item.getMemberMobile());
                    pointsLuckDrawRecord.setPoints(item.getPoints());
                    Integer integer = collect.get(item.getMemberId());
                    pointsLuckDrawRecord.setSumResult(integer);
                    return pointsLuckDrawRecord;
                }).distinct()
                .sorted(Comparator.comparing(PointsLuckDrawRecord::getSumResult).reversed())
                .limit(10).collect(Collectors.toList());*/

        System.out.println(collect);
        System.out.println(collect.keySet());
        System.out.println(collects);
        JSON parse = JSONUtil.parse(collects);
        System.out.println(parse);
    /*    System.out.println(collect1);
        JSON parse = JSONUtil.parse(collect1);*/
        // System.out.println(parse);

    }

    @Test
    public void testGroupBy11() {

        for (int i = 50; i < 100; i++) {
            PointsLuckDrawRecord pointsLuckDrawRecord = new PointsLuckDrawRecord();

            pointsLuckDrawRecord.setMemberId((long) i);
            pointsLuckDrawRecord.setMemberMobile(String.valueOf(i));
            pointsLuckDrawRecord.setPoints(i);
            pointsLuckDrawRecord.setPrizeId((long) i);
            pointsLuckDrawRecord.setResult((short) 0);
            pointsLuckDrawRecord.setMonth(String.valueOf(12));
            pointsLuckDrawRecord.setDaily(new Date());

            pointsLuckDrawRecordMapper.insert(pointsLuckDrawRecord);
            log.info("insert i {} success", i);
        }

        // final List<Prize> prizes = prizeMapper.selectPrizeByActId2(2).ifPresent(null);

        //System.out.println(prizes);
    }
}
