package com.cyzc.why.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/05/05 21:46]
 */
@Data
@AllArgsConstructor
public class OrderExt {
    private Integer id;

    private String buyName;

    private String buyGoods;
    private String payTime;

}
