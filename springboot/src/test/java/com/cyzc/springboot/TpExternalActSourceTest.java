package com.cyzc.springboot;

import com.cyzc.springboot.entity.TpExternalActSource;
import org.junit.jupiter.api.Test;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/18 14:00]
 */
public class TpExternalActSourceTest {
    @Test
    public void testCreateTpExternalActSource()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class<?> aClass = Class.forName("com.cyzc.springboot.entity.TpExternalActSource");
        TpExternalActSource o = (TpExternalActSource)aClass.newInstance();
        System.out.println(o.toString());

    }

}
