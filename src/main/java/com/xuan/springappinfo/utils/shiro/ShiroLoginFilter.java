package com.xuan.springappinfo.utils.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.xuan.springappinfo.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 功能描述: <br>
 * 〈控制shiro的重定向请求〉
 *
 * @Author Yat-Xuan
 * @Description //TODO ASUS
 * @Date 2018/10/26 18:27
 **/
@RestController
@RequestMapping("/shiro")
public class ShiroLoginFilter {

    /**
     * 功能描述: <br>
     * 〈在没有登录的情况下，返回json，不进行重定向。〉
     *
     * @return com.xuan.springappinfo.utils.Result
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/26 18:29
     * @Param []
     **/
    @RequestMapping("/onAccessDenied")
    protected Result onAccessDenied() {

        return Result.getCustomize(false, -1, "请登录！！！");
    }

    /**
     * 功能描述: <br>
     * 〈判断是否为ajax请求〉
     *
     * @return boolean
     * @Author Yat-Xuan
     * @Description //TODO ASUS
     * @Date 2018/10/26 17:38
     * @Param [request]
     **/
    private boolean isAjax(ServletRequest request) {
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(header)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
