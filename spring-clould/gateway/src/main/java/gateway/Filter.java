package gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class  Filter extends ZuulFilter {

//    pre：可以在请求被路由之前调用
//    routing：在路由请求时候被调用
//    post：在routing和error过滤器之后被调用
//    error：处理请求时发生错误时被调用

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
      String token = request.getParameter("accessToken");
//        RequestContextHolder.currentRequestAttributes()

        return null;
    }
}
