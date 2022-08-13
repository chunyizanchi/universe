package com.cyzc.java.entity;


/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/03 15:16]
 */
public class CloneTest implements Cloneable {

    private String address;

    private String city;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CloneTest{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
