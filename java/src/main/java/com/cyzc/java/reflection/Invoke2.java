package com.cyzc.java.reflection;

import com.cyzc.java.entity.CustomerSelect;
import java.lang.reflect.Field;
import org.springframework.util.ObjectUtils;

/**
 * <>
 *
 * @author Cyzc
 * @since [2021/12/22 16:00]
 */
public class Invoke2 {

    public static void main(String[] args) throws IllegalAccessException {
        Invoke2 invoke2=new Invoke2();

        CustomerSelect customerSelect=new CustomerSelect();
        customerSelect.setType("11");
        customerSelect.setStatus("22");

        boolean b = invoke2.hasIntercept(customerSelect);

        System.out.println(b);
    }

    boolean hasIntercept(CustomerSelect customerSelect) throws IllegalAccessException {
        boolean hasIntercept=false;
        Class<? extends CustomerSelect> aClass = customerSelect.getClass();
        Field[] declaredFields = customerSelect.getClass().getDeclaredFields();

        for (Field field:declaredFields){
            field.setAccessible(true);
            String name = field.getName();
            if ("type".equals(name)){
                continue;
            }
            Object invokeParameter = field.get(customerSelect);
            if (!ObjectUtils.isEmpty(invokeParameter)){
                return true;
            }
            System.out.println(field.get(customerSelect));
        }
        return hasIntercept;

    }
/*
    String customerId = customerSelect.getCustomerId();
    String openid = customerSelect.getOpenid();
    String accountNumber = customerSelect.getAccountNumber();
    String ucid = customerSelect.getUcid();
    String defunctPerson = customerSelect.getDefunctPerson();
    String defunctOrg = customerSelect.getDefunctOrg();
    String preferredLanguage = customerSelect.getPreferredLanguage();
    String lifecycleStatus = customerSelect.getLifecycleStatus();
    String firstname = customerSelect.getFirstname();
    String lastname = customerSelect.getLastname();
    String phone = customerSelect.getPhone();
    String nameUsage = customerSelect.getNameUsage();
    String startDate = customerSelect.getStartDate();
    String endDate = customerSelect.getEndDate();
    String salutationType = customerSelect.getSalutationType();
    Date birthdate = customerSelect.getBirthdate();
    String constellation = customerSelect.getConstellation();
    String maritalStatus = customerSelect.getMaritalStatus();
    String education = customerSelect.getEducation();
    String major = customerSelect.getMajor();
    String university = customerSelect.getUniversity();
    String gender = customerSelect.getGender();
    String industry = customerSelect.getIndustry();
    String occupation = customerSelect.getOccupation();
    String duty = customerSelect.getDuty();
    String status = customerSelect.getStatus();
    Long loyalty = customerSelect.getLoyalty();
    Long participation = customerSelect.getParticipation();
    Long classes = customerSelect.getClasses();
    String drivingLicence = customerSelect.getDrivingLicence();
    String favoriteColors = customerSelect.getFavoriteColors();
    String driverlicenseFlag = customerSelect.getDriverlicenseFlag();
    String headportrait = customerSelect.getHeadportrait();
    String nickName = customerSelect.getNickName();
    String province = customerSelect.getProvince();
    String city = customerSelect.getCity();
    String kind = customerSelect.getKind();
    String certificatesType = customerSelect.getCertificatesType();
    String certificatesNum = customerSelect.getCertificatesNum();
    String addressProvince = customerSelect.getAddressProvince();
    String addressCity = customerSelect.getAddressCity();
    String addressArea = customerSelect.getAddressArea();
    String employerName = customerSelect.getEmployerName();
    String contactBackground = customerSelect.getContactBackground();
    String govBackground = customerSelect.getGovBackground();
    String email = customerSelect.getEmail();
    Long familyMemberCount = customerSelect.getFamilyMemberCount();
    Long familyIncome = customerSelect.getFamilyIncome();
    Long personalIncome = customerSelect.getPersonalIncome();
    String addressDetail = customerSelect.getAddressDetail();
    String hobbyOther = customerSelect.getHobbyOther();
    String customerName = customerSelect.getCustomerName();
    Date planBuyTime = customerSelect.getPlanBuyTime();
    Long carPaymentStart = customerSelect.getCarPaymentStart();
    Long carPaymentEnd = customerSelect.getCarPaymentEnd();
    String country = customerSelect.getCountry();
    Date registerTime = customerSelect.getRegisterTime();
    Date createdDatetime = customerSelect.getCreatedDatetime();
    Long lastClasses = customerSelect.getLastClasses();
    String customerSource = customerSelect.getCustomerSource();
    String occupationOther = customerSelect.getOccupationOther();
    String fromSystem = customerSelect.getFromSystem();
    Long thirdSystemUserid = customerSelect.getThirdSystemUserid();
    Integer firstUseInType = customerSelect.getFirstUseInType();
    Date drivingLicenceDate = customerSelect.getDrivingLicenceDate();
    String interestBrand = customerSelect.getInterestBrand();
    String interestClass = customerSelect.getInterestClass();
    String interestModel = customerSelect.getInterestModel();
    String interestDealer = customerSelect.getInterestDealer();
    Date interestPurchaseDate = customerSelect.getInterestPurchaseDate();
    String hobby = customerSelect.getHobby();
    Date locationRejectTime = customerSelect.getLocationRejectTime();
    String agebracket = customerSelect.getAgebracket();
    String iskol = customerSelect.getIskol();
    String likemodel = customerSelect.getLikemodel();
    String likemodelOther = customerSelect.getLikemodelOther();
    String system = customerSelect.getSystem();
    String password = customerSelect.getPassword();
    Long topcount = customerSelect.getTopcount();
    String teamid = customerSelect.getTeamid();
    String tenantid = customerSelect.getTenantid();
    String cimtoken = customerSelect.getCimtoken();
    String cdmuaid = customerSelect.getCdmuaid();
    String terminalid = customerSelect.getTerminalid();
    String openidHelm = customerSelect.getOpenidHelm();
    String idcardIdentify = customerSelect.getIdcardIdentify();
    String driverIdentify = customerSelect.getDriverIdentify();
    Date tokenTime = customerSelect.getTokenTime();
    String oid = customerSelect.getOid();
    String isSyn = customerSelect.getIsSyn();
    String isDelete = customerSelect.getIsDelete();
    String ciamid = customerSelect.getCiamid();
    String dealer_account = customerSelect.getDealer_account();
    String model = customerSelect.getModel();
    String brand = customerSelect.getBrand();
    String class_ = customerSelect.getClass_();
    String tag_id = customerSelect.getTag_id();
    String tag_group_id = customerSelect.getTag_group_id();
    String tag_data_model_id = customerSelect.getTag_data_model_id();
    String bStartDate = customerSelect.getbStartDate();
    String bEndDate = customerSelect.getbEndDate();
    String cStartDate = customerSelect.getcStartDate();
    String cEndDate = customerSelect.getcEndDate();
    String fStartDate = customerSelect.getfStartDate();
    String fEndDate = customerSelect.getfEndDate();
    String dealerCityCode = customerSelect.getDealerCityCode();
    String dealerProvinceCode = customerSelect.getDealerProvinceCode();
    String inDealerCityCode = customerSelect.getInDealerCityCode();
    String inDealerProvinceCode = customerSelect.getInDealerProvinceCode();
    String isAmg = customerSelect.getIsAmg();
    String toAmg = customerSelect.getToAmg();
    String carTag = customerSelect.getCarTag();
    String jStartDate = customerSelect.getjStartDate();
    String jEndDate = customerSelect.getjEndDate();
        if (!StringUtils.isSpace(customerId) || !StringUtils.isSpace(openid)
            || !StringUtils.isSpace(accountNumber) || !StringUtils.isSpace(ucid)
            || !StringUtils.isSpace(defunctPerson) || !StringUtils.isSpace(defunctOrg)
            || !StringUtils.isSpace(preferredLanguage) || !StringUtils.isSpace(lifecycleStatus)
            || !StringUtils.isSpace(firstname) || !StringUtils.isSpace(lastname)
            || !StringUtils.isSpace(phone) || !StringUtils.isSpace(nameUsage)
            || !StringUtils.isSpace(startDate) || !StringUtils.isSpace(endDate)
            || !StringUtils.isSpace(salutationType) || !ObjectUtils.isEmpty(birthdate)
            || !StringUtils.isSpace(constellation) || !StringUtils.isSpace(maritalStatus)
            || !StringUtils.isSpace(education) || !StringUtils.isSpace(major)
            || !StringUtils.isSpace(university) || !StringUtils.isSpace(gender)
            || !StringUtils.isSpace(industry) || !StringUtils.isSpace(occupation)
            || !StringUtils.isSpace(duty) || !StringUtils.isSpace(status)
            || !ObjectUtils.isEmpty(loyalty) || !ObjectUtils.isEmpty(participation)
            || !ObjectUtils.isEmpty(classes) || !StringUtils.isSpace(drivingLicence)
            || !StringUtils.isSpace(favoriteColors) || !StringUtils.isSpace(driverlicenseFlag)
            || !StringUtils.isSpace(headportrait) || !StringUtils.isSpace(nickName)
            || !StringUtils.isSpace(province) || !StringUtils.isSpace(city)
            || !StringUtils.isSpace(kind) || !StringUtils.isSpace(certificatesType)
            || !StringUtils.isSpace(certificatesNum) || !StringUtils.isSpace(addressProvince)
            || !StringUtils.isSpace(addressCity) || !StringUtils.isSpace(addressArea)
            || !StringUtils.isSpace(employerName) || !StringUtils.isSpace(contactBackground)
            || !StringUtils.isSpace(govBackground) || !StringUtils.isSpace(email)
            || !ObjectUtils.isEmpty(familyMemberCount) || !ObjectUtils.isEmpty(familyIncome)
            || !ObjectUtils.isEmpty(personalIncome) || !StringUtils.isSpace(addressDetail)
            || !StringUtils.isSpace(hobbyOther) || !StringUtils.isSpace(customerName)
            || !ObjectUtils.isEmpty(planBuyTime) || !ObjectUtils.isEmpty(carPaymentStart)
            || !ObjectUtils.isEmpty(carPaymentEnd) || !StringUtils.isSpace(country)
            || !ObjectUtils.isEmpty(registerTime) || !ObjectUtils.isEmpty(createdDatetime)
            || !ObjectUtils.isEmpty(lastClasses) || !StringUtils.isSpace(customerSource)
            || !StringUtils.isSpace(occupationOther) || !StringUtils.isSpace(fromSystem)
            || !ObjectUtils.isEmpty(thirdSystemUserid) || !ObjectUtils.isEmpty(firstUseInType)
            || !ObjectUtils.isEmpty(drivingLicenceDate) || !StringUtils.isSpace(interestBrand)
            || !StringUtils.isSpace(interestClass) || !StringUtils.isSpace(interestModel)
            || !StringUtils.isSpace(interestDealer) || !ObjectUtils.isEmpty(
    interestPurchaseDate) || !StringUtils.isSpace(hobby) || !ObjectUtils.isEmpty(
    locationRejectTime) || !StringUtils.isSpace(agebracket) || !StringUtils.isSpace(
    iskol) || !StringUtils.isSpace(likemodel) || !StringUtils.isSpace(likemodelOther)
            || !StringUtils.isSpace(system) || !StringUtils.isSpace(password)
            || !ObjectUtils.isEmpty(topcount) || !StringUtils.isSpace(teamid)
            || !StringUtils.isSpace(tenantid) || !StringUtils.isSpace(cimtoken)
            || !StringUtils.isSpace(cdmuaid) || !StringUtils.isSpace(terminalid)
            || !StringUtils.isSpace(openidHelm) || !StringUtils.isSpace(idcardIdentify)
            || !StringUtils.isSpace(driverIdentify) || !ObjectUtils.isEmpty(tokenTime)
            || !StringUtils.isSpace(oid) || !StringUtils.isSpace(isSyn) || !StringUtils.isSpace(
    isDelete) || !StringUtils.isSpace(ciamid) || !StringUtils.isSpace(dealer_account)
            || !StringUtils.isSpace(model) || !StringUtils.isSpace(brand)
            || !StringUtils.isSpace(class_) || !StringUtils.isSpace(tag_id)
            || !StringUtils.isSpace(tag_group_id) || !StringUtils.isSpace(tag_data_model_id)
            || !StringUtils.isSpace(bStartDate) || !StringUtils.isSpace(bEndDate)
            || !StringUtils.isSpace(cStartDate) || !StringUtils.isSpace(cEndDate)
            || !StringUtils.isSpace(fStartDate) || !StringUtils.isSpace(fEndDate)
            || !StringUtils.isSpace(dealerCityCode) || !StringUtils.isSpace(dealerProvinceCode)
            || !StringUtils.isSpace(inDealerCityCode) || !StringUtils.isSpace(
    inDealerProvinceCode) || !StringUtils.isSpace(isAmg) || !StringUtils.isSpace(toAmg)
            || !StringUtils.isSpace(carTag) || !StringUtils.isSpace(jStartDate)
            || !StringUtils.isSpace(jEndDate)){

    }*/
}
