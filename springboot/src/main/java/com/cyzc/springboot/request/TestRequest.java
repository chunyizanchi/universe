package com.cyzc.springboot.request;

import com.cyzc.base.web.BaseRequest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/18 22:08]
 */
@Getter
@Setter
public class TestRequest extends BaseRequest {

    private Long testId;
}
