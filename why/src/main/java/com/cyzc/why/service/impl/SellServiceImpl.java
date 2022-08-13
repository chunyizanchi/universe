package com.cyzc.why.service.impl;

import com.cyzc.why.entity.Order;
import com.cyzc.why.entity.Prize;
import com.cyzc.why.entity.PrizeRecord;
import com.cyzc.why.entity.Product;
import com.cyzc.why.mapper.OrderMapper;
import com.cyzc.why.mapper.PrizeMapper;
import com.cyzc.why.mapper.PrizeRecordMapper;
import com.cyzc.why.mapper.ProductMapper;
import com.cyzc.why.service.SellService;
import com.cyzc.why.utils.PrizeTools;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/10 12:01]
 */
@Component
public class SellServiceImpl implements SellService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PrizeRecordMapper prizeRecordMapper;

    @Autowired
    private PrizeMapper prizeMapper;

    @Autowired
    private SellService sellService;

    private final Lock lock = new ReentrantLock(true);

    @Override
    public void sellProduct() {
        try {
            lock.lock();
            //使用aop代理获取代理对象调用方法
            ((SellServiceImpl) AopContext.currentProxy()).sellProduct();
            //transactionService.sellProductProcessor();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    /**
     *  ((SellService) AopContext.currentProxy()) 获取代理对象
     * @param actId
     * @param threadName
     * @return {@link com.cyzc.why.entity.Prize}
     * @since  2021/11/19 14:34
     */
    @Override
    public Prize drawPrize(Integer actId, String threadName) {
        Prize prize=new Prize();
        try {
            lock.lock();
            //使用aop代理获取
            prize= ((SellService) AopContext.currentProxy()).drawPrizeProcessor(actId,
                    threadName);
            //((SellService) AopContext.currentProxy()).drawPrizeProcessor(actId, threadName);
            //prize = sellService.drawPrizeProcessor(actId, threadName);
            //drawPrizeProcessor(actId,threadName);
            //新写一个service方便被spring代理
            //prize = sellService.drawPrizeProcessor(actId, threadName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return prize;
    }

    @Override
    @Transactional
    public Prize drawPrizeProcessor(Integer actId, String threadName) {
        //获取奖池
        final List<Prize> prizeList = prizeMapper.selectPrizeByActId(actId);
        //判断奖池元素，count/possibility 为0 就将该元素remove掉
        prizeList.removeIf(prize -> prize.getPossibility() == 0 || prize.getCount() == 0);

        //Optional.of(prizeList).flatMap()

        if (ObjectUtils.isEmpty(prizeList)) {
            System.out.println("所有奖品都没有库存了");
            return null;
        }

        TreeMap<Integer, Prize> ratioLotteries;

        //获得奖池map
        ratioLotteries = PrizeTools.initLottery(prizeList);
        System.out.println(ratioLotteries);
        //通过随机数从奖池中抽取奖品
        int ss = ThreadLocalRandom.current().nextInt(ratioLotteries.lastKey());
        System.out.println(ratioLotteries.lastKey());
        //最终抽奖返回奖品
        Prize winning = ratioLotteries.tailMap(ss, false).firstEntry().getValue();
        System.out.println("抽到的奖品：" + winning.getId());
        //扣减库存
        Prize updatePrize = new Prize();
        updatePrize.setId(winning.getId());
        updatePrize.setCount(winning.getCount() - 1);
        prizeMapper.updateByPrimaryKeySelective(updatePrize);
        System.out.println(Thread.currentThread().getName() + "===扣减库存成功!");

        //插入prizerecord
        PrizeRecord prizeRecord = new PrizeRecord();
        prizeRecord.setUserName(threadName);
        prizeRecord.setPrizeId(winning.getId());
        prizeRecordMapper.insert(prizeRecord);
        System.out.println(Thread.currentThread().getName() + "===生成PrizeRecord 成功");

        return winning;
    }

    @Override
    @Transactional
    public void sellProductProcessor() {
        System.out.println(Thread.currentThread().getName() + ": 抢到锁了，进入方法");
        Product product = productMapper.selectByPrimaryKey(1);
        final Integer count = product.getCount();
        System.out.println(Thread.currentThread().getName() + ":当前库存 =" + count);

        if (count > 0) {
            Product updateProduct = new Product();
            updateProduct.setId(product.getId());
            updateProduct.setCount(count - 1);
            productMapper.updateByPrimaryKeySelective(updateProduct);
            System.out.println(Thread.currentThread().getName() + ":减库存完毕");
            Order order = new Order();
            order.setBuyName(Thread.currentThread().getName());
            order.setBuyGoods(product.getProductName());
            orderMapper.insertSelective(order);
            System.out.println(Thread.currentThread().getName() + ":生成订单成功");

        } else {
            System.out.println(Thread.currentThread().getName() + ":没库存了！");
        }


    }

    @Override
    public List<PrizeRecord> selectAll() {
        return prizeRecordMapper.selectAll();
    }
}
