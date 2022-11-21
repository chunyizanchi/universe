package com.cyzc.java.generic.genericExtension;

import com.cyzc.java.generic.entity.Animal;
import com.cyzc.java.generic.entity.Biology;
import com.cyzc.java.generic.entity.Cat;
import com.cyzc.java.generic.entity.GenericClass;
import java.util.ArrayList;
import jdk.internal.dynalink.linker.LinkerServices;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/11/19 16:00]
 */
public class TestDemo {

    public static void main(String[] args) {
        GenericClass<String> stringGenericClass = new GenericClass<>();

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        ArrayList<Biology> biologies = new ArrayList<>();
        biologies.add(new Biology());

        stringGenericClass.getCounts(cats);
        stringGenericClass.updateCollections(biologies);



    }

}
