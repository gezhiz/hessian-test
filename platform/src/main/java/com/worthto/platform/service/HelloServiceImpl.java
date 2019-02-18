package com.worthto.platform.service;

import com.caucho.hessian.server.HessianServlet;
import com.worthto.common.domain.User;
import com.worthto.common.service.HelloService;

/**
 * Created by gezz on 2019/2/18.
 */
public class HelloServiceImpl extends HessianServlet implements HelloService {

    /**
     *
     */
    private static final long serialVersionUID = -3537274030227675984L;

    @Override
    public String helloWorld(String message) {
        System.out.println("client：invoke helloworld");
        return "Hello, " + message;
    }

    @Override
    public User getMyInfo(User user) {
        System.out.println("client：invoke getMyInfo");
        if (null == user) {
            return new User();
        }

        user.setAge(99);
        return user;
    }

}