package com.cyzc.designpattern.chainPattern.validateHandlerTest;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/14 10:07]
 */
public class Member {

    private String userName;

    private String passWord;

    private Long id;

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

