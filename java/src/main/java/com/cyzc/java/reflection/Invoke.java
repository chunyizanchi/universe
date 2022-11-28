package com.cyzc.java.reflection;

import com.cyzc.java.entity.CustomerSelect;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@link PropertyDescriptor} 获取对应的
 *
 * @author Cyzc
 * @since [2021/12/22 14:34]
 */
public class Invoke {

    public static void main(String[] args)
            throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        CustomerSelect customerSelect=new CustomerSelect();
        customerSelect.setType("11");

        Class<? extends CustomerSelect> aClass = customerSelect.getClass();
        Field[] declaredFields = customerSelect.getClass().getDeclaredFields();


        StringBuilder judge = new StringBuilder("s");
        for (Field field:declaredFields){
            PropertyDescriptor pd=new PropertyDescriptor(field.getName(),aClass);
            Method getMethod= pd.getReadMethod();

            String name = getMethod.getName();
            if ("getType".equals(name)){
                continue;
            }
            System.out.println("String "+field.getName()+"= customerSelect."+name+"();");
          /*  String invoke = (String)getMethod.invoke(customerSelect);
            System.out.println(StringUtils.isSpace(invoke));
            System.out.println(invoke);
*/
            String sub="!StringUtils.isSpace("+field.getName()+")||";

            judge.append(sub);
        }
        System.out.println(judge);



    }

}
