package com.cyzc.java.entity;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/03 17:57]
 */
public class Home {

    private String homeAddr;
    private String carName;

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Home(String homeAddr, String carName) {
        this.homeAddr = homeAddr;
        this.carName = carName;
    }

    @Override
    public int hashCode() {
        // return super.hashCode();
        int result = homeAddr.hashCode();
        result = 17 * result + carName.hashCode();
        //result = 17 * result + age.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Home)) {
            return false;
        }
        Home homeObj = (Home) obj;
        if (this == homeObj) {
            return true;
        }

        // 如果两个对象姓名、年龄、性别相等，我们认为两个对象相等
        if (homeObj.homeAddr.equals(this.homeAddr) && homeObj.carName.equals(this.carName)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Home{" +
                "homeAddr='" + homeAddr + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }
}
