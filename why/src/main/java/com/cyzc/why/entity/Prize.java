package com.cyzc.why.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prize {
    private Integer id;

    private String prizeName;

    private Integer count;

    private Integer possibility;

    private Integer  actId;
}