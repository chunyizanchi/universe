package com.cyzc.why.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/01/11 17:08]
 */
@Data
@TableName
public class FireStudent {

    private String id;
    @TableField
    private String name;
    private String number;
    private String userType;
    private String one;
    private String two;
    private String three;
    private String four;
    private String five;
    private String result;


}
