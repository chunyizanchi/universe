package com.cyzc.java.reflection;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/18 23:37]
 */
public class SuperClass {

    private String superName;
    private Integer superAge;
    private String superSex;

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public Integer getSuperAge() {
        return superAge;
    }

    public void setSuperAge(Integer superAge) {
        this.superAge = superAge;
    }

    public String getSuperSex() {
        return superSex;
    }

    public void setSuperSex(String superSex) {
        this.superSex = superSex;
    }

    @Override
    public String toString() {
        return "SuperClass{" +
                "superName='" + superName + '\'' +
                ", superAge=" + superAge +
                ", superSex='" + superSex + '\'' +
                '}';
    }
}
