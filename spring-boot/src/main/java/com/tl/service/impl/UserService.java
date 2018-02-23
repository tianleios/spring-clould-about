package com.tl.service.impl;

import com.tl.domain.User;
import com.tl.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Service
@Validated
public class UserService implements IUserService {

    @Override
    public User findUserById(@Min(value = 1) Integer id) {

        return null;
    }

    @Override
    public User findUserByName(@Size(min = 5,max = 8) String name) {
        return null;
    }

    @Override
    public void test(String name) {

    }
}
