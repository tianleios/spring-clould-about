package com.tl.dubbo.filter;

import org.apache.dubbo.rpc.*;

/**
 * Created by tianlei on 2019-07-28
 */
public class ExecptionFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        Result result = invoker.invoke(invocation);
        if (result != null && result.getException() != null && result.getException() instanceof RuntimeException) {
            if (result instanceof RpcResult) {
                RpcResult rpcResult = (RpcResult) result;
                rpcResult.setValue("get error");
                rpcResult.setException(null);
            }
        }
        return result;

    }

}
