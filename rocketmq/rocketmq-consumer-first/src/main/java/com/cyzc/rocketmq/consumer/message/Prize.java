package com.cyzc.rocketmq.consumer.message;


import com.cyzc.rocketmq.consumer.conf.TopicConstant;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/30 22:46]
 */
public class Prize {

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
