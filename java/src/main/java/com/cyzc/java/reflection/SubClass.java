package com.cyzc.java.reflection;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/18 23:37]
 */
public class SubClass extends SuperClass{

    private String subName;
    private Integer subAge;
    private String subSex;

    public String publicField;
    protected String protectedField;
    String defaultField;

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Integer getSubAge() {
        return subAge;
    }

    public void setSubAge(Integer subAge) {
        this.subAge = subAge;
    }

    public String getSubSex() {
        return subSex;
    }

    public void setSubSex(String subSex) {
        this.subSex = subSex;
    }

    public String getPublicField() {
        return publicField;
    }

    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }

    public String getProtectedField() {
        return protectedField;
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "subName='" + subName + '\'' +
                ", subAge=" + subAge +
                ", subSex='" + subSex + '\'' +
                ", publicField='" + publicField + '\'' +
                ", protectedField='" + protectedField + '\'' +
                ", defaultField='" + defaultField + '\'' +
                '}';
    }

    public void setProtectedField(String protectedField) {
        this.protectedField = protectedField;
    }

    public String getDefaultField() {
        return defaultField;
    }

    public void setDefaultField(String defaultField) {
        this.defaultField = defaultField;
    }

}
