package com.cyzc.why.entity;

import java.util.Date;
import lombok.Data;

@Data
public class TpExternalActSource {
    private String externalActSourceId;

    private String openid;

    private String activityname;

    private Date createdate;

    private String activityid;

    private String userType;

    private String source;

    private String terminalid;

    private String tenantid;

    private String isnew;

    private String afterLoginOpenid;
}