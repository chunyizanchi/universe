package com.cyzc.rocketmq.producer.message;

import com.cyzc.rocketmq.producer.conf.TopicConstant;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/30 22:46]
 */
public class PrizeMessage {
    public static final String TOPIC = TopicConstant.TOPIC_PRIZE;

    /**
     * 编号
     */
    private Integer id;

    public PrizeMessage setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PrizeMessage{" +
                "id=" + id +
                '}';
    }
}
