package com.cyzc.rocketmq.producer.message;

import com.cyzc.rocketmq.producer.conf.TopicConstant;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/30 22:46]
 */
public class Prize {
    public static final String TOPIC = TopicConstant.TOPIC_PRIZE;

    /**
     * 编号
     */
    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "PrizeMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prize setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

}
