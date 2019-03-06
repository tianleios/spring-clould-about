package com.tl.other;

import com.tl.rpc.RpcClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by tianlei on 2019/2/27
 */
public class RpcProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String str = method.getName() + Arrays.stream(args).map(Object::toString).collect(Collectors.joining(","));
        RpcClient.getInstance().getChannel().writeAndFlush(str);
        return "tianlei-success";
    }
}
