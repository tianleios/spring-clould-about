package com.proxy;

public class UserServiceImpl implements IUserService {

    public String findUserNameById(Integer id) {

        System.out.println("找到了用户");
        return "user:" + id.toString();
    }
}
