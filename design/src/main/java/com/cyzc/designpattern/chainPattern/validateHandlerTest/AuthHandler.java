package com.cyzc.designpattern.chainPattern.validateHandlerTest;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/14 10:16]
 */
public class AuthHandler extends Handler {

    @Override
    public void doHandler(Member member) {

        if (!"管理员".equals(member.getRole())) {
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        if (next != null) {
            next.doHandler(member);
        }

    }
}
