package com.cyzc.java.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Activity extends Model<Activity> {
	
    private static final long serialVersionUID = 1L;
    
    /**
     * 活动主表
     */
    @TableId("ACTIVITY_ID")
    private String activityId;
    /**
     * 活动标题
     */
    @TableField("TITLE")
    private String title;
    /**
     * 活动开始时间
     */
    private Date beginDate;
    /**
     * 活动结束时间
     */
    private Date endDate;
    /**
     * 创建人
     */
    @TableField("CREATED_BY")
    private String createdBy;
    /**
     * 创建时间
     */
    @TableField("CREATED_DATETIME")
    private Date createdDatetime;
    /**
     * 修改人
     */
    @TableField("LAST_MODIFIED_BY")
    private String lastModifiedBy;
    /**
     * 修改时间
     */
    @TableField("LAST_MODIFIED_DATETIME")
    private Date lastModifiedDatetime;
    /**
     * 活动类型ID
     */
    @TableField("ACTIVITY_TYPE_ID")
    private String activityTypeId;
    @TableField("TAG_ID")
    private String tagId;
    @TableField("FEATURES")
    private String features;
    /**
     * 选项配图
     */
    @TableField("IMAGE")
    private String image;
    /**
     * 启用：1  屏蔽： 0
     */
    @TableField("IS_ACTIVE")
    private String isActive;
    /**
     * 置顶（自增）
     */
    @TableField("IS_TOP")
    private Long isTop;
    /**
     * 点赞数
     */
    @TableField("PRAISE_COUNT")
    private Long praiseCount;
    /**
     * 阅读数
     */
    @TableField("READ_COUNT")
    private Long readCount;
    /**
     * 转发数
     */
    @TableField("TRANSPOND_COUNT")
    private Long transpondCount;
    /**
     * 报名人数
     */
    @TableField("SIGN_UP_COUNT")
    private Long signUpCount;
    /**
     * 评价数
     */
    @TableField("EVALUATE_COUNT")
    private Long evaluateCount;
    /**
     * 活动状态
     */
    @TableField("STATUS")
    private String status;
    @TableField("ACTUAL_COST")
    private Long actualCost;
    @TableField("BUDGETED_COST")
    private Long budgetedCost;
    @TableField("CAMPAIGN_MEMBER_RECORD_TYPE")
    private String campaignMemberRecordType;
    @TableField("NAME")
    private String name;
    @TableField("OWNER")
    private String owner;
    @TableField("RECORD_TYPE")
    private String recordType;
    @TableField("NUMBER_OF_CONVERTED_LEADS")
    private Long numberOfConvertedLeads;
    @TableField("EXPECTED_RESPONSE")
    private Double expectedResponse;
    @TableField("EXPECTED_REVENUE")
    private Long expectedRevenue;
    @TableField("NUMBER_SENT")
    private Long numberSent;
    @TableField("NUMBER_OF_OPPORTUNITIES")
    private Long numberOfOpportunities;
    @TableField("NUMBER_OF_WONOPPORTUNITIES")
    private Long numberOfWonopportunities;
    @TableField("PARENT")
    private String parent;
    @TableField("NUMBER_OF_CONTACTS")
    private Long numberOfContacts;
    @TableField("NUMBER_OF_LEADS")
    private Long numberOfLeads;
    @TableField("NUMBER_OF_RESPONSES")
    private Long numberOfResponses;
    @TableField("AMOUNT_ALL_OPPORTUNITIES")
    private Long amountAllOpportunities;
    @TableField("AMOUNT_WON_OPPORTUNITIES")
    private Long amountWonOpportunities;
    @TableField("BRAND_C")
    private String brandC;
    @TableField("OUT_URL")
    private String outUrl;
    @TableField("DESCRIPTION")
    private String description;
    /**
     * 活动详细内容HTML
     */
    @TableField("DETAIL")
    private String detail;
    @TableField("OUT_FLAG")
    private String outFlag;
    @TableField("ROLE")
    private String role;
    /**
     * 管理员身份(经销商or管理员)
     */
    @TableField("DEALER_ACCOUNT")
    private String dealerAccount;
    /**
     * 签到人数
     */
    @TableField("SIGN_IN_COUNT")
    private Long signInCount;
    @TableField("SUMMARY")
    private String summary;
    @TableField("ACTIVITY_HASHTABLE")
    private String activityHashtable;
    @TableField("PUBLISH_TIME")
    private Date publishTime;
    /**
     * 活动交互类型
     */
    @TableField("ACTIVITY_INTERACTION_TYPE")
    private String activityInteractionType;
    /**
     * 个人信息（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_BASE")
    private String signupQuestionsBase;
    /**
     * 兴趣爱好（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_HOBBY")
    private String signupQuestionsHobby;
    /**
     * 家庭状况（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_FAMILY")
    private String signupQuestionsFamily;
    /**
     * 奔驰座驾（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_CARS")
    private String signupQuestionsCars;
    /**
     * 评价类型
     */
    @TableField("GRADE_FLAG")
    private String gradeFlag;
    /**
     * 临时活动跳转的报名页面（正常活动为null）
     */
    @TableField("SPECIAL_REGISTER_PAGE")
    private String specialRegisterPage;
    /**
     * 临时活动跳转的报名成功页面（正常活动为null）
     */
    @TableField("SPECIAL_REG_SUCCESS_PAGE")
    private String specialRegSuccessPage;
    /**
     * 临时活动跳转的签到成功页面（正常活动为null）
     */
    @TableField("SPECIAL_SIGN_SUCCESS_PAGE")
    private String specialSignSuccessPage;
    /**
     * 临时活动跳转的评价成功页面（正常活动为null）
     */
    @TableField("SPECIAL_EVA_STATUS_PAGE")
    private String specialEvaStatusPage;
    /**
     * 活动详情显示按钮
     */
    @TableField("DETAIL_PAGE_OPS")
    private String detailPageOps;
    /**
     * 想去人数
     */
    @TableField("WANT_COUNT")
    private Long wantCount;
    /**
     * 活动报名开始时间
     */
    private Date signupStartDate;
    /**
     * 活动报名结束时间
     */
    private Date signupEndDate;
    /**
     * 是否填写签到后续信息 1是 2否
     */
    @TableField("SIGN_IN_FLAG")
    private String signInFlag;
    /**
     * 是否签到 1是 2否
     */
    @TableField("IS_SIGN_IN")
    private Integer isSignIn;
    /**
     * 是否报名 1 是2否
     */
    @TableField("IS_SIGN_UP")
    private Integer isSignUp;
    /**
     * 活动地点
     */
    @TableField("ACTIVITY_LOCALE")
    private String activityLocale;
    /**
     * 签到条款
     */
    @TableField("SIGN_IN_INFO")
    private String signInInfo;
    /**
     * 是否投票 1是 2否
     */
    @TableField("IS_BALLOT")
    private Integer isBallot;
    /**
     * 地区信息（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_PLACE")
    private String signupQuestionsPlace;
    /**
     * 电子邮箱（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_EMAIL")
    private String signupQuestionsEmail;
    /**
     * 生日信息（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_BIRTH")
    private String signupQuestionsBirth;
    /**
     * 证件信息（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_SFZH")
    private String signupQuestionsSfzh;
    /**
     * 购车意向（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_PURCHASE")
    private String signupQuestionsPurchase;
    /**
     * 意向经销商（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_DEALER")
    private String signupQuestionsDealer;
    /**
     * 车架号(VIN) （问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_VIN")
    private String signupQuestionsVin;
    /**
     * 驾照信息（问题勾选）
     */
    @TableField("SIGNUP_QUESTIONS_LICENSE")
    private String signupQuestionsLicense;
    /**
     * 活动站点（问题勾选）
     */
    @TableField("SINGUP_QUESTIONS_ACTIVITY")
    private String singupQuestionsActivity;
    /**
     * 是否评价 1 是2否
     */
    @TableField("IS_SIGN_EVALUATE")
    private Integer isSignEvaluate;
    @TableField("ADDTITLE")
    private String addtitle;
    /**
     * 团队
     */
    @TableField("TENANTID")
    private String tenantid;
    /**
     * 社区分类
     */
    @TableField("FROM_SOURCE")
    private String fromSource;
    /**
     * 社区分类KEY
     */
    @TableField("CLASSIFY_KEY")
    private String classifyKey;
    /**
     * 社区分类NAME
     */
    @TableField("CLASSIFY_NAME")
    private String classifyName;
    /**
     * 展示平台
     */
    @TableField("TERMINALID")
    private String terminalid;
    /**
     * 短信模板
     */
    @TableField("SMS_TEMPLATE")
    private String smsTemplate;
    /**
     * 1 车主专属
     */
    @TableField("ISTYPE")
    private String istype;
    @TableField("ACTIVITY_TARGET")
    private String activityTarget;
    /**
     * ONEWEB新增字段标签
     */
    @TableField("EVENT_TAG")
    private String eventTag;
    /**
     * ONEWEB新增字段经销商代码
     */
    @TableField("MERCHANT_CODE")
    private String merchantCode;
    @TableField("BEGIN_NEWS")
    private String beginNews;
    @TableField("END_NEWS")
    private String endNews;
    @TableField("SIGN_UP_NEWS")
    private String signUpNews;
    @TableField("CANCEL_NEWS")
    private String cancelNews;
    @TableField("IS_SCRM")
    private String isScrm;
    @TableField("SMS_ID")
    private String smsId;
    /*
     * 投票相关字段
     * */
    @TableField(exist=false)
    private String ballotId;//投票ID
    @TableField(exist=false)
    private String ballotType;//投票类型
    @TableField(exist=false)
    private Date tpstartTime;//投票开始时间
    @TableField(exist=false)
    private Date tpendTime;//投票结束时间
    @TableField(exist=false)
    private String ballotRole;//投票用户权限
    @TableField(exist=false)
    private String rolChezhu;
    @TableField(exist=false)
    private String rolFensi;
    @TableField(exist=false)
    private String rolYouke;
    ////////////////////

    /**
     * 审核系统相关字段
     */
    //审核状态 空未提交  0已提交未审核 1审核通过 2审核不通过
    @TableField("CHECK_STATUS")
    private String checkStatus;
    //审核人
    @TableField("CHECK_USER")
    private String checkUser;
    //审核时间
    @TableField("CHECK_DATE")
    private String checkDate;
    //审核原因
    @TableField("CHECK_CONTENET")
    private String checkContenet;
    //经销商活动类型
    @TableField("DEALERACTTYPE")
    private String dealeractType;
    //经销商代码
    @TableField("DEALER_CODE")
    private String dealerCode;
    //主办方
    @TableField("SPONSOR")
    private String sponsor;

    @TableField("ACTIVITY_PROVINCE")
    private String activityProvince;

    @TableField("ACTIVITYCITY")
    private String activityCity;

    @TableField("RELEASE_COUNT")
    private String  releaseCount;
    /**
     * 2020-01-11 是否显示短信通知
     */
    @TableField("IS_SMS")
    private String isSMS;
    @TableField(exist=false)
    private String actstartDate;

    @TableField(exist=false)
    private String actendDate;

    @TableField(exist=false)
    private String userType;

    @TableField(exist=false)
    private int  timeOut;
    
    //前端查看的类型  admin dealer
    @TableField(exist=false)
    private String watchType;
    @TableField(exist=false)
    private String openid;
    @TableField(exist=false)
    private String timeFlag;
    @TableField(exist=false)
    private List<String> dealerCodes;

    @TableField(exist=false)
    private Long sict;
    @TableField(exist=false)
    private Long wtct;

    //通知短信拆分内容
    @TableField("SMS_SPLIT")
    private String smsSplit;

    @TableField("PC_THUMBNAIL")
    private String pcThumbnail;

    private String pcThumbnailLink;

    private String appThumbnail;

    private String appThumbnailLink;

    private String isScwDisplay;

    private String eventCitys;


    private String prizeId;

    private String prizeCode;


    private String isShow;

    private String dealerId;

    private String dealerName;

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getPrizeCode() {
        return prizeCode;
    }

    public void setPrizeCode(String prizeCode) {
        this.prizeCode = prizeCode;
    }


    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public String getEventCitys() {
        return eventCitys;
    }

    public void setEventCitys(String eventCitys) {
        this.eventCitys = eventCitys;
    }

    public String getPcThumbnail() {
        return pcThumbnail;
    }

    public void setPcThumbnail(String pcThumbnail) {
        this.pcThumbnail = pcThumbnail;
    }

    public String getPcThumbnailLink() {
        return pcThumbnailLink;
    }

    public void setPcThumbnailLink(String pcThumbnailLink) {
        this.pcThumbnailLink = pcThumbnailLink;
    }

    public String getAppThumbnail() {
        return appThumbnail;
    }

    public void setAppThumbnail(String appThumbnail) {
        this.appThumbnail = appThumbnail;
    }

    public String getAppThumbnailLink() {
        return appThumbnailLink;
    }

    public void setAppThumbnailLink(String appThumbnailLink) {
        this.appThumbnailLink = appThumbnailLink;
    }

    public String getIsScwDisplay() {
        return isScwDisplay;
    }

    public void setIsScwDisplay(String isScwDisplay) {
        this.isScwDisplay = isScwDisplay;
    }

    public String getSmsSplit() {
        return smsSplit;
    }

    public void setSmsSplit(String smsSplit) {
        this.smsSplit = smsSplit;
    }

    public String getIsSMS() {
		return isSMS;
	}

	public void setIsSMS(String isSMS) {
		this.isSMS = isSMS;
	}

	public String getActivityCity() {
        return activityCity;
    }

    public void setActivityCity(String activityCity) {
        this.activityCity = activityCity;
    }

    @TableField(exist=false)
    private Long  siit;

    public Long getSiit() {
        return siit;
    }

    public void setSiit(Long siit) {
        this.siit = siit;
    }

    public Long getSict() {
        return sict;
    }

    public void setSict(Long sict) {
        this.sict = sict;
    }

    public Long getWtct() {
        return wtct;
    }

    public void setWtct(Long wtct) {
        this.wtct = wtct;
    }

    public List<String> getDealerCodes() {
		return dealerCodes;
	}

	public void setDealerCodes(List<String> dealerCodes) {
		this.dealerCodes = dealerCodes;
	}

	public String getTimeFlag() {
		return timeFlag;
	}

	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}

	public String getReleaseCount() {
        return releaseCount;
    }

    public void setReleaseCount(String releaseCount) {
        this.releaseCount = releaseCount;
    }

    public String getActivityProvince() {
        return activityProvince;
    }

    public void setActivityProvince(String activityProvince) {
        this.activityProvince = activityProvince;
    }

    public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getWatchType() {
		return watchType;
	}

	public void setWatchType(String watchType) {
		this.watchType = watchType;
	}

	public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getActstartDate() {
        return actstartDate;
    }

    public void setActstartDate(String actstartDate) {
        this.actstartDate = actstartDate;
    }

    public String getActendDate() {
        return actendDate;
    }

    public void setActendDate(String actendDate) {
        this.actendDate = actendDate;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckContenet() {
        return checkContenet;
    }

    public void setCheckContenet(String checkContenet) {
        this.checkContenet = checkContenet;
    }

    public String getDealeractType() {
        return dealeractType;
    }

    public void setDealeractType(String dealeractType) {
        this.dealeractType = dealeractType;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getSmsId() {
		return smsId;
	}

	public String getRolChezhu() {
		return rolChezhu;
	}

	public void setRolChezhu(String rolChezhu) {
		this.rolChezhu = rolChezhu;
	}

	public String getRolFensi() {
		return rolFensi;
	}

	public void setRolFensi(String rolFensi) {
		this.rolFensi = rolFensi;
	}

	public String getRolYouke() {
		return rolYouke;
	}

	public void setRolYouke(String rolYouke) {
		this.rolYouke = rolYouke;
	}

	public String getBallotId() {
		return ballotId;
	}

	public void setBallotId(String ballotId) {
		this.ballotId = ballotId;
	}

	public String getBallotType() {
		return ballotType;
	}

	public void setBallotType(String ballotType) {
		this.ballotType = ballotType;
	}


	public Date getTpstartTime() {
		return tpstartTime;
	}

	public void setTpstartTime(Date tpstartTime) {
		this.tpstartTime = tpstartTime;
	}

	public Date getTpendTime() {
		return tpendTime;
	}

	public void setTpendTime(Date tpendTime) {
		this.tpendTime = tpendTime;
	}

	public String getBallotRole() {
		return ballotRole;
	}

	public void setBallotRole(String ballotRole) {
		this.ballotRole = ballotRole;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public String getIsScrm() {
		return isScrm;
	}

	public void setIsScrm(String isScrm) {
		this.isScrm = isScrm;
	}

	public String getBeginNews() {
		return beginNews;
	}

	public void setBeginNews(String beginNews) {
		this.beginNews = beginNews;
	}

	public String getEndNews() {
		return endNews;
	}

	public void setEndNews(String endNews) {
		this.endNews = endNews;
	}

	public String getSignUpNews() {
		return signUpNews;
	}

	public void setSignUpNews(String signUpNews) {
		this.signUpNews = signUpNews;
	}

	public String getCancelNews() {
		return cancelNews;
	}

	public void setCancelNews(String cancelNews) {
		this.cancelNews = cancelNews;
	}

	public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getBeginDate() {
        return beginDate;
    }

    public String getbeginDateStr(){
    	String beginDateStr = "";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	if(beginDate!=null){
    		beginDateStr = sdf.format(beginDate);
    	}
    	return beginDateStr;
    }

    public String getActivityTypeName(){
		return null;
    }

    public String getsignupStartDateStr(){
    	String signupStartDateStr = "";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	if(signupStartDate!=null){
    		signupStartDateStr = sdf.format(signupStartDate);
    	}
    	return signupStartDateStr;
    }

    public String getsignupEndDateStr(){
    	String signupEndDateStr = "";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	if(signupEndDate!=null){
    		signupEndDateStr = sdf.format(signupEndDate);
    	}
    	return signupEndDateStr;
    }

    public String getendDateStr(){
    	String endDateStr = "";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	if(endDate!=null){
    		endDateStr = sdf.format(endDate);
    	}
    	return endDateStr;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public String getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(String activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Long getIsTop() {
        return isTop;
    }

    public void setIsTop(Long isTop) {
        this.isTop = isTop;
    }

    public Long getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Long praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Long getTranspondCount() {
        return transpondCount;
    }

    public void setTranspondCount(Long transpondCount) {
        this.transpondCount = transpondCount;
    }

    public Long getSignUpCount() {
        return signUpCount;
    }

    public void setSignUpCount(Long signUpCount) {
        this.signUpCount = signUpCount;
    }

    public Long getEvaluateCount() {
        return evaluateCount;
    }

    public void setEvaluateCount(Long evaluateCount) {
        this.evaluateCount = evaluateCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getActualCost() {
        return actualCost;
    }

    public void setActualCost(Long actualCost) {
        this.actualCost = actualCost;
    }

    public Long getBudgetedCost() {
        return budgetedCost;
    }

    public void setBudgetedCost(Long budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    public String getCampaignMemberRecordType() {
        return campaignMemberRecordType;
    }

    public void setCampaignMemberRecordType(String campaignMemberRecordType) {
        this.campaignMemberRecordType = campaignMemberRecordType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Long getNumberOfConvertedLeads() {
        return numberOfConvertedLeads;
    }

    public void setNumberOfConvertedLeads(Long numberOfConvertedLeads) {
        this.numberOfConvertedLeads = numberOfConvertedLeads;
    }

    public Double getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(Double expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public Long getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedRevenue(Long expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public Long getNumberSent() {
        return numberSent;
    }

    public void setNumberSent(Long numberSent) {
        this.numberSent = numberSent;
    }

    public Long getNumberOfOpportunities() {
        return numberOfOpportunities;
    }

    public void setNumberOfOpportunities(Long numberOfOpportunities) {
        this.numberOfOpportunities = numberOfOpportunities;
    }

    public Long getNumberOfWonopportunities() {
        return numberOfWonopportunities;
    }

    public void setNumberOfWonopportunities(Long numberOfWonopportunities) {
        this.numberOfWonopportunities = numberOfWonopportunities;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Long getNumberOfContacts() {
        return numberOfContacts;
    }

    public void setNumberOfContacts(Long numberOfContacts) {
        this.numberOfContacts = numberOfContacts;
    }

    public Long getNumberOfLeads() {
        return numberOfLeads;
    }

    public void setNumberOfLeads(Long numberOfLeads) {
        this.numberOfLeads = numberOfLeads;
    }

    public Long getNumberOfResponses() {
        return numberOfResponses;
    }

    public void setNumberOfResponses(Long numberOfResponses) {
        this.numberOfResponses = numberOfResponses;
    }

    public Long getAmountAllOpportunities() {
        return amountAllOpportunities;
    }

    public void setAmountAllOpportunities(Long amountAllOpportunities) {
        this.amountAllOpportunities = amountAllOpportunities;
    }

    public Long getAmountWonOpportunities() {
        return amountWonOpportunities;
    }

    public void setAmountWonOpportunities(Long amountWonOpportunities) {
        this.amountWonOpportunities = amountWonOpportunities;
    }

    public String getBrandC() {
        return brandC;
    }

    public void setBrandC(String brandC) {
        this.brandC = brandC;
    }

    public String getOutUrl() {
        return outUrl;
    }

    public void setOutUrl(String outUrl) {
        this.outUrl = outUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOutFlag() {
        return outFlag;
    }

    public void setOutFlag(String outFlag) {
        this.outFlag = outFlag;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDealerAccount() {
        return dealerAccount;
    }

    public void setDealerAccount(String dealerAccount) {
        this.dealerAccount = dealerAccount;
    }

    public Long getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(Long signInCount) {
        this.signInCount = signInCount;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getActivityHashtable() {
        return activityHashtable;
    }

    public void setActivityHashtable(String activityHashtable) {
        this.activityHashtable = activityHashtable;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getActivityInteractionType() {
        return activityInteractionType;
    }

    public void setActivityInteractionType(String activityInteractionType) {
        this.activityInteractionType = activityInteractionType;
    }

    public String getSignupQuestionsBase() {
        if (signupQuestionsBase == null) {
            return "0";
        }
        return signupQuestionsBase;
    }

    public void setSignupQuestionsBase(String signupQuestionsBase) {
        this.signupQuestionsBase = signupQuestionsBase;
    }

    public String getSignupQuestionsHobby() {
        if (signupQuestionsHobby == null) {
            return "0";
        }
        return signupQuestionsHobby;
    }

    public void setSignupQuestionsHobby(String signupQuestionsHobby) {
        this.signupQuestionsHobby = signupQuestionsHobby;
    }

    public String getSignupQuestionsFamily() {
        if (signupQuestionsFamily == null) {
            return "0";
        }
        return signupQuestionsFamily;
    }

    public void setSignupQuestionsFamily(String signupQuestionsFamily) {
        this.signupQuestionsFamily = signupQuestionsFamily;
    }

    public String getSignupQuestionsCars() {
        if (signupQuestionsCars == null) {
            return "0";
        }
        return signupQuestionsCars;
    }

    public void setSignupQuestionsCars(String signupQuestionsCars) {
        this.signupQuestionsCars = signupQuestionsCars;
    }

    public String getGradeFlag() {
        return gradeFlag;
    }

    public void setGradeFlag(String gradeFlag) {
        this.gradeFlag = gradeFlag;
    }

    public String getSpecialRegisterPage() {
        return specialRegisterPage;
    }

    public void setSpecialRegisterPage(String specialRegisterPage) {
        this.specialRegisterPage = specialRegisterPage;
    }

    public String getSpecialRegSuccessPage() {
        return specialRegSuccessPage;
    }

    public void setSpecialRegSuccessPage(String specialRegSuccessPage) {
        this.specialRegSuccessPage = specialRegSuccessPage;
    }

    public String getSpecialSignSuccessPage() {
        return specialSignSuccessPage;
    }

    public void setSpecialSignSuccessPage(String specialSignSuccessPage) {
        this.specialSignSuccessPage = specialSignSuccessPage;
    }

    public String getSpecialEvaStatusPage() {
        return specialEvaStatusPage;
    }

    public void setSpecialEvaStatusPage(String specialEvaStatusPage) {
        this.specialEvaStatusPage = specialEvaStatusPage;
    }

    public String getDetailPageOps() {
        return detailPageOps;
    }

    public void setDetailPageOps(String detailPageOps) {
        this.detailPageOps = detailPageOps;
    }

    public Long getWantCount() {
        return wantCount;
    }

    public void setWantCount(Long wantCount) {
        this.wantCount = wantCount;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getSignupStartDate() {
        return signupStartDate;
    }

    public void setSignupStartDate(Date signupStartDate) {
        this.signupStartDate = signupStartDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getSignupEndDate() {
        return signupEndDate;
    }

    public void setSignupEndDate(Date signupEndDate) {
        this.signupEndDate = signupEndDate;
    }

    public String getSignInFlag() {
        return signInFlag;
    }

    public void setSignInFlag(String signInFlag) {
        this.signInFlag = signInFlag;
    }

    public Integer getIsSignIn() {
        return isSignIn;
    }

    public void setIsSignIn(Integer isSignIn) {
        this.isSignIn = isSignIn;
    }

    public Integer getIsSignUp() {
        return isSignUp;
    }

    public void setIsSignUp(Integer isSignUp) {
        this.isSignUp = isSignUp;
    }

    public String getActivityLocale() {
        return activityLocale;
    }

    public void setActivityLocale(String activityLocale) {
        this.activityLocale = activityLocale;
    }

    public String getSignInInfo() {
        return signInInfo;
    }

    public void setSignInInfo(String signInInfo) {
        this.signInInfo = signInInfo;
    }

    public Integer getIsBallot() {
        return isBallot;
    }

    public void setIsBallot(Integer isBallot) {
        this.isBallot = isBallot;
    }

    public String getSignupQuestionsPlace() {
        if (signupQuestionsPlace == null) {
            return "0";
        }
        return signupQuestionsPlace;
    }

    public void setSignupQuestionsPlace(String signupQuestionsPlace) {
        this.signupQuestionsPlace = signupQuestionsPlace;
    }

    public String getSignupQuestionsEmail() {
        if (signupQuestionsEmail == null) {
            return "0";
        }
        return signupQuestionsEmail;
    }

    public void setSignupQuestionsEmail(String signupQuestionsEmail) {
        this.signupQuestionsEmail = signupQuestionsEmail;
    }

    public String getSignupQuestionsBirth() {
        if (signupQuestionsBirth == null) {
            return "0";
        }
        return signupQuestionsBirth;
    }

    public void setSignupQuestionsBirth(String signupQuestionsBirth) {
        this.signupQuestionsBirth = signupQuestionsBirth;
    }

    public String getSignupQuestionsSfzh() {
        if (signupQuestionsSfzh == null) {
            return "0";
        }
        return signupQuestionsSfzh;
    }

    public void setSignupQuestionsSfzh(String signupQuestionsSfzh) {
        this.signupQuestionsSfzh = signupQuestionsSfzh;
    }

    public String getSignupQuestionsPurchase() {
        if (signupQuestionsPurchase == null) {
            return "0";
        }
        return signupQuestionsPurchase;
    }

    public void setSignupQuestionsPurchase(String signupQuestionsPurchase) {
        this.signupQuestionsPurchase = signupQuestionsPurchase;
    }

    public String getSignupQuestionsDealer() {
        if (signupQuestionsDealer == null) {
            return "0";
        }
        return signupQuestionsDealer;
    }

    public void setSignupQuestionsDealer(String signupQuestionsDealer) {
        this.signupQuestionsDealer = signupQuestionsDealer;
    }

    public String getSignupQuestionsVin() {
        if (signupQuestionsVin == null) {
            return "0";
        }
        return signupQuestionsVin;
    }

    public void setSignupQuestionsVin(String signupQuestionsVin) {
        this.signupQuestionsVin = signupQuestionsVin;
    }

    public String getSignupQuestionsLicense() {
        if (signupQuestionsLicense == null) {
            return "0";
        }
        return signupQuestionsLicense;
    }

    public void setSignupQuestionsLicense(String signupQuestionsLicense) {
        this.signupQuestionsLicense = signupQuestionsLicense;
    }

    public String getSingupQuestionsActivity() {
        if (singupQuestionsActivity == null) {
            return "0";
        }
        return singupQuestionsActivity;
    }

    public void setSingupQuestionsActivity(String singupQuestionsActivity) {
        this.singupQuestionsActivity = singupQuestionsActivity;
    }

    public Integer getIsSignEvaluate() {
        return isSignEvaluate;
    }

    public void setIsSignEvaluate(Integer isSignEvaluate) {
        this.isSignEvaluate = isSignEvaluate;
    }

    public String getAddtitle() {
        return addtitle;
    }

    public void setAddtitle(String addtitle) {
        this.addtitle = addtitle;
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid;
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    public String getClassifyKey() {
        return classifyKey;
    }

    public void setClassifyKey(String classifyKey) {
        this.classifyKey = classifyKey;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    public String getSmsTemplate() {
        return smsTemplate;
    }

    public void setSmsTemplate(String smsTemplate) {
        this.smsTemplate = smsTemplate;
    }

    public String getIstype() {
        return istype;
    }

    public void setIstype(String istype) {
        this.istype = istype;
    }

    public String getActivityTarget() {
        return activityTarget;
    }

    public void setActivityTarget(String activityTarget) {
        this.activityTarget = activityTarget;
    }

    public String getEventTag() {
        return eventTag;
    }

    public void setEventTag(String eventTag) {
        this.eventTag = eventTag;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    @Override
    protected Serializable pkVal() {
        return this.activityId;
    }

    @Override
    public String toString() {
        return "Activity{" +
        ", activityId=" + activityId +
        ", title=" + title +
        ", beginDate=" + beginDate +
        ", endDate=" + endDate +
        ", createdBy=" + createdBy +
        ", createdDatetime=" + createdDatetime +
        ", lastModifiedBy=" + lastModifiedBy +
        ", lastModifiedDatetime=" + lastModifiedDatetime +
        ", activityTypeId=" + activityTypeId +
        ", tagId=" + tagId +
        ", features=" + features +
        ", image=" + image +
        ", isActive=" + isActive +
        ", isTop=" + isTop +
        ", praiseCount=" + praiseCount +
        ", readCount=" + readCount +
        ", transpondCount=" + transpondCount +
        ", signUpCount=" + signUpCount +
        ", evaluateCount=" + evaluateCount +
        ", status=" + status +
        ", actualCost=" + actualCost +
        ", budgetedCost=" + budgetedCost +
        ", campaignMemberRecordType=" + campaignMemberRecordType +
        ", name=" + name +
        ", owner=" + owner +
        ", recordType=" + recordType +
        ", numberOfConvertedLeads=" + numberOfConvertedLeads +
        ", expectedResponse=" + expectedResponse +
        ", expectedRevenue=" + expectedRevenue +
        ", numberSent=" + numberSent +
        ", numberOfOpportunities=" + numberOfOpportunities +
        ", numberOfWonopportunities=" + numberOfWonopportunities +
        ", parent=" + parent +
        ", numberOfContacts=" + numberOfContacts +
        ", numberOfLeads=" + numberOfLeads +
        ", numberOfResponses=" + numberOfResponses +
        ", amountAllOpportunities=" + amountAllOpportunities +
        ", amountWonOpportunities=" + amountWonOpportunities +
        ", brandC=" + brandC +
        ", outUrl=" + outUrl +
        ", description=" + description +
        ", detail=" + detail +
        ", outFlag=" + outFlag +
        ", role=" + role +
        ", dealerAccount=" + dealerAccount +
        ", signInCount=" + signInCount +
        ", summary=" + summary +
        ", activityHashtable=" + activityHashtable +
        ", publishTime=" + publishTime +
        ", activityInteractionType=" + activityInteractionType +
        ", signupQuestionsBase=" + signupQuestionsBase +
        ", signupQuestionsHobby=" + signupQuestionsHobby +
        ", signupQuestionsFamily=" + signupQuestionsFamily +
        ", signupQuestionsCars=" + signupQuestionsCars +
        ", gradeFlag=" + gradeFlag +
        ", specialRegisterPage=" + specialRegisterPage +
        ", specialRegSuccessPage=" + specialRegSuccessPage +
        ", specialSignSuccessPage=" + specialSignSuccessPage +
        ", specialEvaStatusPage=" + specialEvaStatusPage +
        ", detailPageOps=" + detailPageOps +
        ", wantCount=" + wantCount +
        ", signupStartDate=" + signupStartDate +
        ", signupEndDate=" + signupEndDate +
        ", signInFlag=" + signInFlag +
        ", isSignIn=" + isSignIn +
        ", isSignUp=" + isSignUp +
        ", activityLocale=" + activityLocale +
        ", signInInfo=" + signInInfo +
        ", isBallot=" + isBallot +
        ", signupQuestionsPlace=" + signupQuestionsPlace +
        ", signupQuestionsEmail=" + signupQuestionsEmail +
        ", signupQuestionsBirth=" + signupQuestionsBirth +
        ", signupQuestionsSfzh=" + signupQuestionsSfzh +
        ", signupQuestionsPurchase=" + signupQuestionsPurchase +
        ", signupQuestionsDealer=" + signupQuestionsDealer +
        ", signupQuestionsVin=" + signupQuestionsVin +
        ", signupQuestionsLicense=" + signupQuestionsLicense +
        ", singupQuestionsActivity=" + singupQuestionsActivity +
        ", isSignEvaluate=" + isSignEvaluate +
        ", addtitle=" + addtitle +
        ", tenantid=" + tenantid +
        ", fromSource=" + fromSource +
        ", classifyKey=" + classifyKey +
        ", classifyName=" + classifyName +
        ", terminalid=" + terminalid +
        ", smsTemplate=" + smsTemplate +
        ", istype=" + istype +
        ", activityTarget=" + activityTarget +
        ", eventTag=" + eventTag +
        ", merchantCode=" + merchantCode +
        ", dealerId=" + dealerId +
        ", dealerName=" + dealerName +
        "}";
    }
}
