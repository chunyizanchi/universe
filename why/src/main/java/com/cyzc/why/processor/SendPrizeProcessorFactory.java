package com.cyzc.why.processor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.cyzc.why.enums.PointsLuckDrawTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/11/19 13:27]
 */
public class SendPrizeProcessorFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      this.applicationContext=applicationContext;
    }

    public SendPrizeProcessor getSendPrizeProcessor(PointsLuckDrawTypeEnum typeEnum){
        String processorName = "typeEnum.getSendPrizeProcessorName()";
        if(StrUtil.isBlank(processorName)){
            return null;
        }
        SendPrizeProcessor processor = applicationContext.getBean(processorName, SendPrizeProcessor.class);
        if(ObjectUtil.isNull(processor)){
            throw new RuntimeException("没有找到名称为【" + processorName + "】的发送奖品处理器");
        }
        return processor;
    }
}
