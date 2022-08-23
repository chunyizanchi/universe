package com.cyzc.designpattern.observerPattern;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/20 00:01]
 */
public class Message {

    private String messageId;

    private String messageDesc;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }

    public Message(String messageId, String messageDesc) {
        this.messageId = messageId;
        this.messageDesc = messageDesc;
    }
}
