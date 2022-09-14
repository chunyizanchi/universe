package com.cyzc.designpattern.chainPattern.validateHandlerTest;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/09/14 10:04]
 */
public class ValidateHandler extends Handler {

    @Override
    public void doHandler(Member member) {

        if (StringUtils.isEmpty(member.getPassWord()) || StringUtils.isEmpty(member.getUserName())
                || ObjectUtils.isEmpty(member.getId())) {
            System.out.println("用户名账号密码不能为空"
            );
            return;

        }
        if (null != next) {
            next.doHandler(member);
        }

    }
}
