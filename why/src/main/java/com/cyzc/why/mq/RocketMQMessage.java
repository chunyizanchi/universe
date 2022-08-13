package com.cyzc.why.mq;

import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/02 11:15]
 */
@Data
public class RocketMQMessage<T> implements Serializable {

    /**
     * 消息内容
     */
    private T content;


    /**
     * 消息的key
     */
    private String msgKey;

    /**
     * topic
     */
    private String producerTopic;
    /**
     * group
     */
    private String producerGroup;
    /**
     * tag
     */
    private String producerTag;
}
