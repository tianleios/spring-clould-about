package com.tianlei.service;

import com.tianlei.domain.User;

import java.util.List;

public interface IUserService {

    User findById(Long id);
    User save(User user);
    List<User> findUserPage(int start, int limit);
    User findUserDetailByUserName(String userName);


}
