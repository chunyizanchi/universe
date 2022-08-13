package com.cyzc.why.service;

import com.cyzc.why.entity.Prize;
import com.cyzc.why.entity.PrizeRecord;
import java.util.List;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/10 12:01]
 */
public interface SellService {

    void sellProduct();

    Prize drawPrize(Integer actId,String threadName);

    Prize drawPrizeProcessor(Integer actId,String threadName);

    void sellProductProcessor();

    List<PrizeRecord> selectAll();
}
