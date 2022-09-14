package com.cyzc.designpattern.chainPattern.validateHandlerTest;

/**
 * <p> 总结： 职责链模式其实就是 先定义一个Handler 抽象类。 Handler类中有注册 职责链类，定义两个方法。 addHandler 和doHandler
 *
 * @author Cyzc
 * @since [2022/09/14 10:19]
 */
public class TestDemo {

    public static void main(String[] args) {

        Handler.Builder builder = new Handler.Builder();
        //注意注册顺序
        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler())
                .addHandler(new BusinessLogicHandler());

        Member member = new Member();
        member.setRole("1111");
        member.setUserName("chunyizanchi");
        member.setPassWord("123");
        member.setId(12456L);
        builder.build().doHandler(member);


    }
}
