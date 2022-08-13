package com.cyzc.springboot.utils;



import com.cyzc.springboot.entity.Prize;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.springframework.util.ObjectUtils;


public class PrizeTools {


    /**
     * 返回奖池map
     *
     * @param lotteries
     * @return
     */
    public static TreeMap<Integer, Prize> initLottery(List<Prize> lotteries) {
        if (ObjectUtils.isEmpty(lotteries)){
            return null;
        }
        List<Prize> filtered = new ArrayList<>();
        //暂存概率
        int tmpRatio = 0;
        for (Prize lottery : lotteries) {
            //如果奖品数量小于等于0
            if (lottery.getCount() <= 0) {
                tmpRatio += lottery.getPossibility();
                continue;
            }

            filtered.add(lottery);
        }
        TreeMap<Integer, Prize> map = filtered.stream().collect(TreeMap::new, (m, l) -> {
            Integer ratio = 0;
            if (m != null && m.size() > 0) {
                ratio = m.lastKey();
            }
            m.put(ratio + l.getPossibility(), l);
        }, TreeMap::putAll);
        return map;
    }


}
