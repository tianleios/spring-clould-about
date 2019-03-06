package com.tl.service;

import com.tl.mapper.UserMapper;
import com.tl.other.Rpc;
import org.springframework.stereotype.Service;

/**
 * Created by tianlei on 2019/2/27
 */
@Service
public class UserService {

    @Rpc
    private UserMapper userMapper;

    public String insert() {
       return userMapper.insert("tianlei", 20);
    }
}
