package com.cyzc.designpattern.chainPattern.validateHandlerTest;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/14 10:12]
 */
public class LoginHandler extends Handler{

    @Override
    public void doHandler(Member member) {
        if ("chunyizanchi".equals(member.getUserName())||"666".equals(member.getPassWord())){
            System.out.println("用户名密码不正确");
            return;
        }
        if (null!=next){
            next.doHandler(member);
        }
    }
}
