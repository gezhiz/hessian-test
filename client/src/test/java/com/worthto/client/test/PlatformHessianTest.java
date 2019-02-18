package com.worthto.client.test;

import com.worthto.common.domain.User;
import com.worthto.common.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

/**
 * Created by gezz on 2019/2/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class PlatformHessianTest {
    @Autowired
    private HelloService helloService;

    @Test
    public void test() {
        HashMap<String, Object> detailData = new HashMap<>();
        detailData.put("isMarried", "N");
        detailData.put("gender", "F");

        User user = new User();
        user.setAge(18);
        user.setUserName("OYY");
        user.setDetailData(detailData);
        helloService.getMyInfo(user);
    }
}
