package com.worthto.common;

import static org.junit.Assert.assertTrue;

import com.worthto.common.domain.Person;
import com.worthto.common.domain.User;
import com.worthto.common.utils.HessianObjectSerializeUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testHessianObjectSerialize() {
//        User user = new User();
//        user.setAge(20);
//        user.setUserName("gezz");
//        Map<String,Object> detailData = new HashMap();
//        detailData.put("isMarried","N");
//        detailData.put("edu","college");
//        user.setDetailData(detailData);
//        byte[] userBytes = HessianObjectSerializeUtil.serialize(user);
//        System.out.println("序列化结果：" + new String(userBytes.toString()));
//
//        User deserializeUser = HessianObjectSerializeUtil.deserialize(User.class, userBytes);
//        System.out.println("反序列化user:" + deserializeUser);
    }
}
