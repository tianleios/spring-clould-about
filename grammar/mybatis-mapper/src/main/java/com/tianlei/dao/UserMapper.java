package com.tianlei.dao;

import com.tianlei.domain.User;

import javax.validation.constraints.Max;
import java.util.List;

public interface UserMapper {

    void add(User user);
    void addName(String name);

    User selectOne();
    List<User> selectList();


}
