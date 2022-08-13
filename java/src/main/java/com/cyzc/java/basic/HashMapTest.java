package com.cyzc.java.basic;

import com.cyzc.java.entity.Home;
import com.cyzc.java.entity.Student;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/03 17:30]
 */
public class HashMapTest {

    private static Map<Student, Home> hashMap = new HashMap<Student, Home>();

    static {
        Student student = new Student("ywb", 7);
        Home home = new Home("天安门", "自行车");
        hashMap.put(student,home);

    }

    public static void main(String[] args) {
       /* Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Aa", "Aa");
        hashMap.put("BB", "BB");
        hashMap.put("AaAa", "AaAa");
        hashMap.put("AaBB", "AaBB");
        hashMap.put("BBAa", "BBAa");
        hashMap.put("BBBB", "BBBB");
        hashMap.put("AaAaAa", "AaAaAa");
        hashMap.put("AaAaBB", "AaAaBB");
        hashMap.put("AaBBAa", "AaBBAa");
        hashMap.put("AaBBBB", "AaBBBB");
        hashMap.put("BBAaAa", "BBAaAa");
        hashMap.put("BBAaBB", "BBAaBB");
        hashMap.put("BBBBAa", "BBBBAa");
        hashMap.put("BBBBBB", "BBBBBB");*/

        updateInfo("why", 7, "滨江路", "摩托");
        for (Map.Entry<Student, Home> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }

    }
    private static void updateInfo(String name, Integer age, String homeAddr, String carName) {
        Student student = new Student(name, age);
        System.out.println("student hashcode:"+student.hashCode());
        Home homeInfo = hashMap.get(student);
        if (homeInfo == null) {
            hashMap.put(student, new Home(homeAddr, carName));
        }
    }
}
