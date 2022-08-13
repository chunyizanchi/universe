package com.cyzc.why.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.util.Date;
import lombok.Data;

/**
    * 抽奖记录表
    */
@Data
public class PointsLuckDrawRecord {
    private Long id;

    /**
    * 用户ID
    */
    private Long memberId;

    /**
    * 中奖用户手机号
    */
    private String memberMobile;

    /**
    * 消耗积分
    */
    private Integer points;

    /**
    * 奖品ID
    */
    private Long prizeId;

    /**
    * 1:中奖 2:未中奖
    */
    private Short result;

    /**
    * 中奖月份
    */
    private String month;

    /**
    * 中奖日期（不包括时间）
    */
    private Date daily;

    private Date createTime;

    private Date updateTime;
    @TableField(exist = false)
    private Integer sumResult;
}