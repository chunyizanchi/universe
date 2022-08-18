package com.cyzc.springboot.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author tpsoft
 * @since 2019-10-16
 */
@TableName("TP_EXTERNAL_ACT_SOURCE")
public class TpExternalActSource  {

    private static final long serialVersionUID = 1L;

    @TableId("EXTERNAL_ACT_SOURCE_ID")
    private String externalActSourceId;
    /**
     * 用户openid
     */
    @TableField("OPENID")
    private String openId;
    /**
     * 行为名称
     */
    @TableField("ACTIVITYNAME")
    private String activityName;
    /**
     * 创建时间
     */
    @TableField("CREATEDATE")
    private Date createDate;
    /**
     * 活动id
     */
    @TableField("ACTIVITYID")
    private String activityId;
    /**
     * 用户类型：1-车主；2-粉丝；3-游客
     */
    @TableField("USER_TYPE")
    private String userType;
    /**
     * 来源渠道
     */
    @TableField("SOURCE")
    private String source;
    @TableField("TENANTID")
    private String tenantId;
    @TableField("ISNEW")
    private String isNew;
    @TableField("AFTER_LOGIN_OPENID")
    private String afterLoginOpenId;
    @TableField(exist = false)
    private String customerName;
    @TableField(exist = false)
    private String phone;
    @TableField(exist = false)
    private Date fansDateTime;
    @TableField(exist = false)
    private String type;
    @TableField(exist = false)
    private String gender;
    @TableField(exist = false)
    private Integer qCount;
    @TableField(exist = false)
    private Integer cCount;
    @TableField(exist = false)
    private Integer xCount;
    @TableField(exist = false)
    private Integer sCount;
    @TableField(exist = false)
    private String phoneCode;

    @TableField(exist = false)
    private Date createDateEn;


    @TableField(exist = false)
    private Date createDateStr;

    @TableField(exist = false)
    private String headImg;

    @TableField(exist = false)
    private String nickNameStr;
    //年月信息
    @TableField(exist = false)
    private String yearMouthFormat;

    public String getYearMouthFormat() {
        return yearMouthFormat;
    }

    public void setYearMouthFormat(String yearMouthFormat) {
        this.yearMouthFormat = yearMouthFormat;
    }

    public String getNickNameStr() {
        return nickNameStr;
    }

    public void setNickNameStr(String nickNameStr) {
        this.nickNameStr = nickNameStr;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    public Date getCreateDateStr() {
        return createDateEn;
    }

    public void setCreateDateStr(Date createDateStr) {
        this.createDateStr = createDateStr;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateDateEn() {
        return createDateEn;
    }

    public void setCreateDateEn(Date createDateEn) {
        this.createDateEn = createDateEn;
    }

    public String getPhoneCode() {

        return phone;

    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Integer getqCount() {
        return qCount;
    }

    public void setqCount(Integer qCount) {
        this.qCount = qCount;
    }

    public Integer getcCount() {
        return cCount;
    }

    public void setcCount(Integer cCount) {
        this.cCount = cCount;
    }

    public Integer getxCount() {
        return xCount;
    }

    public void setxCount(Integer xCount) {
        this.xCount = xCount;
    }

    public Integer getsCount() {
        return sCount;
    }

    public void setsCount(Integer sCount) {
        this.sCount = sCount;
    }

    public String getIsNew() {

        if ("1".equals(isNew)) {
            isNew = "是";
        } else {
            isNew = "否";
        }
        System.out.println("调用了getIsNew 方法 isNew的值是:"+isNew);
        return isNew;
    }

    public void setIsNew(String isNew) {

        this.isNew = isNew;
        System.out.println("调用了setIsNew 方法 isNew的值是:"+this.isNew);
    }

    public String getAfterLoginOpenId() {
        return afterLoginOpenId;
    }

    public void setAfterLoginOpenId(String afterLoginOpenId) {
        this.afterLoginOpenId = afterLoginOpenId;
    }

    public String getCustomerName() {

        return customerName;
    }

    public void setCustomerName(String customerName) {

        this.customerName = customerName;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getFansDateTime() {
        return fansDateTime;
    }

    public void setFansDateTime(Date fansDateTime) {
        this.fansDateTime = fansDateTime;
    }

    public String getType() {
        if ("1".equals(type)) {
            type = "车主";
        } else if ("2".equals(type)) {
            type = "粉丝";
        } else {
            type = "游客";
        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {

        if ("1".equals(gender)) {
            gender = "男";
        } else if ("2".equals(gender)) {
            gender = "女";
        } else {
            gender = "保密";
        }
        return gender;

    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExternalActSourceId() {
        return externalActSourceId;
    }

    public void setExternalActSourceId(String externalActSourceId) {
        this.externalActSourceId = externalActSourceId;
    }


    public String getUserType() {

        if ("1".equals(userType)) {
            userType = "车主";
        } else if ("2".equals(userType)) {
            userType = "粉丝";
        } else {
            userType = "游客";
        }
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }


    @Override
    public String toString() {
        return "TpExternalActSource{" +
                "externalActSourceId='" + externalActSourceId + '\'' +
                ", openId='" + openId + '\'' +
                ", activityName='" + activityName + '\'' +
                ", createDate=" + createDate +
                ", activityId='" + activityId + '\'' +
                ", userType='" + userType + '\'' +
                ", source='" + source + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", isNew='" + isNew + '\'' +
                ", afterLoginOpenId='" + afterLoginOpenId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", fansDateTime=" + fansDateTime +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", qCount=" + qCount +
                ", cCount=" + cCount +
                ", xCount=" + xCount +
                ", sCount=" + sCount +
                ", phoneCode='" + phoneCode + '\'' +
                ", createDateEn=" + createDateEn +
                ", createDateStr=" + createDateStr +
                ", headImg='" + headImg + '\'' +
                ", nickNameStr='" + nickNameStr + '\'' +
                ", yearMouthFormat='" + yearMouthFormat + '\'' +
                '}';
    }
}
