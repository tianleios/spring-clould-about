package com.tl.service;

import com.tl.domain.User;

import javax.validation.constraints.Size;

public interface IUserService {

    User findUserById(Integer id);

    User findUserByName(String name);

    void test(@Size(min = 1,max = 2) String name);

}
