package com.cyzc.java.serializable;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/04/08 23:18]
 */
public class Hessian2OutputSerializable {

    public static void main(String[] args) throws IOException {
        List<User1> user1List = new ArrayList<>();
        User1 user1 = new User1();
        user1.setName("HESSIAN");
        User1 user2 = new User1();
        user1.setName("HESSIAN2");

        user1List.add(user2);
        user1List.add(user1);
        //序列化
      /*  ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(bos);
        output.writeObject(user1List);
        output.flushBuffer();
        byte[] data = bos.toByteArray();
        System.out.println(Arrays.toString(data));
        bos.close();

        //反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        Hessian2Input input = new Hessian2Input(bis);
        //User1 deStudent = (User1) input.readObject();
        List<User1> deStudent = (List<User1>) input.readObject();
        input.close();
        System.out.println(deStudent.toString());*/
    }

}
