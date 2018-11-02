package com.xuan.springappinfo.utils.http;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>Description: 跨域工具包 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/10/21
 * @Time: 15:40
 */
public class Crosfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub

        HttpServletResponse res = (HttpServletResponse) response;

        HttpServletRequest req = (HttpServletRequest) request;

        /*
          这里使用全局匹配，不推荐使用，应采用下面这种配置
          res.addHeader("Access-Control-Allow-Origin", "*");*/

        String origin = req.getHeader("Origin");
        if (!org.springframework.util.StringUtils.isEmpty(origin)) {
            //带cookie的时候，origin必须是全匹配，不能使用*，这里设置域名
            res.addHeader("Access-Control-Allow-Origin", origin);
        }

        //调用方法
        res.addHeader("Access-Control-Allow-Methods", "*");

        res.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Authorization,SessionToken");

        // 支持所有自定义头
        String headers = req.getHeader("Access-Control-Request-Headers");
        if (!org.springframework.util.StringUtils.isEmpty(headers)) {
            res.addHeader("Access-Control-Allow-Headers", headers);
        }

        res.addHeader("Access-Control-Max-Age", "3600");

        // enable cookie
        res.addHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
