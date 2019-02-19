package com.worthto.common;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.worthto.common.domain.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gezz on 2019/2/19.
 */
public class HessianSerializableTest {

    public static void main(String[] args) throws IOException {
        Person person = new Person();
        person.setId("002");
        person.setName("小强二号");
        Map<String,Object> detailData = new HashMap();
        detailData.put("isMarried","N");
        detailData.put("edu","college");
        person.setDetailData(detailData);
        byte[] bytes = objToBytes(person);
        Person p = bytesToObj(bytes);
        System.out.println(p);
    }

    //使用Hessian序列化工具，将java对象，序列化为字节数组
    public static byte[] objToBytes(Person person) throws IOException{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //Hession的序列化输出
        Hessian2Output out = new Hessian2Output(os);
        out.writeObject(person);
        out.close();
        return os.toByteArray();
    }

    //将字节数组反序列化为java对象
    public static Person bytesToObj(byte[] bytes) throws IOException{
        ByteArrayInputStream ins = new ByteArrayInputStream(bytes);
        Hessian2Input input = new Hessian2Input(ins);
        Person person = (Person) input.readObject();
        return person;
    }
}
