package com.tianlei.dao;

import com.tianlei.domain.User;

public interface UserMapper {

    User findByUserId(Integer userId);
}
