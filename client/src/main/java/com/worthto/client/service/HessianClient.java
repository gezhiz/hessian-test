package com.worthto.client.service;

import com.caucho.hessian.client.HessianProxyFactory;
import com.worthto.common.domain.User;
import com.worthto.common.service.HelloService;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gezz on 2019/2/18.
 */
public class HessianClient {
    static ExecutorService es =  Executors.newFixedThreadPool(10);
    /**
     * 测试hessian服务是否可用，并要求在2秒内获得响应
     * @throws MalformedURLException
     */
    @Test//(timeout = 2000)
    public void testService4Success() throws MalformedURLException {

        String url = "http://localhost:8080/platform/app/helloService";
        System.out.println("请求的服务端地址：" + url);

        HessianProxyFactory factory = new HessianProxyFactory();
        HelloService helloService = (HelloService) factory.create(HelloService.class, url);
        System.out.println("服务端返回结果为：" + helloService.helloWorld("kitty!"));


        HashMap<String, Object> detailData = new HashMap<>();
        detailData.put("isMarried", "N");
        detailData.put("gender", "F");

        User user = new User();
        user.setAge(18);
        user.setUserName("OYY");
        user.setDetailData(detailData);

        int time = 100000;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i< time; i++){
            es.execute(new Runnable() {

                @Override
                public void run() {
                    helloService.getMyInfo(user);
                }
            });

        }

        System.out.println(time + "次调用耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("+--获得复杂对象:" );
        System.out.println("      +--新年龄:" + helloService.getMyInfo(user).getAge());
        System.out.println("      +--隐私信息:" + helloService.getMyInfo(user).getDetailData());

    }
}