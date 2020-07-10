package com.tl.dubbo.common.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * Created by tianlei on 2019-07-28
 */
@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order =  -99)
public class MyExecptionFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {


        int a = 10;
        Result orgResult = invoker.invoke(invocation);
//        if (!(orgResult instanceof RpcResult)) {
//            return orgResult;
//        }
//
//        RpcResult orgRpcResult = (RpcResult) orgResult;
//
//        if (orgRpcResult.hasException()) {
//
//            orgRpcResult.setValue("error");
//            orgRpcResult.setException(null);
//            return orgRpcResult;
//        }

        return orgResult;


    }


}

