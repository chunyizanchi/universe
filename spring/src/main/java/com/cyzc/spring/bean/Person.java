package com.cyzc.spring.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/29 21:29]
 */

public class Person {

    private String name;
    private String sex;
    private String[] emails;
    private Set<String> tesl;
    private List<String> addresses;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", emails=" + Arrays.toString(emails) +
                ", tesl=" + tesl +
                ", addresses=" + addresses +
                ", maps=" + maps +
                ", properties=" + properties +
                '}';
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private Map<String, String> maps;
    private Properties properties;

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> address) {
        this.addresses = address;
    }

    private Person() {

    }

    public Set<String> getTesl() {
        return tesl;
    }

    public void setTesl(Set<String> tesl) {
        this.tesl = tesl;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }
}
