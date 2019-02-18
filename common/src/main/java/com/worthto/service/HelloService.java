package com.worthto.service;

import com.worthto.domain.User;

/**
 * Created by gezz on 2019/2/18.
 */
public interface HelloService {

    public String helloWorld(String message);

    public User getMyInfo(User user);

}