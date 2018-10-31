package com.xuan.springappinfo.utils.shiro;

import com.xuan.springappinfo.utils.Result;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公共异常类
 * 捕获shiro验证出现的异常
 */
@ControllerAdvice
public class ShiroException {

    @ExceptionHandler(value = UnknownAccountException.class)
    public @ResponseBody
    Result UnknownAccountException() {
        return Result.getCustomize(false, -1, "账号不存在");
    }

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public @ResponseBody
    Result IncorrectCredentialsException() {
        return Result.getCustomize(false, -1, "密码错误");
    }

    @ExceptionHandler(value = AuthorizationException.class)
    public @ResponseBody
    Result AuthorizationExceptionHandler() {
        return Result.getCustomize(false, -1, "权限不足！");
    }

    @ExceptionHandler(value = UnsupportedTokenException.class)
    public @ResponseBody
    Result UnsupportedTokenException() {
        return Result.getCustomize(false, -1, "身份令牌异常，不支持的身份令牌");
    }

    @ExceptionHandler(value = LockedAccountException.class)
    public @ResponseBody
    Result LockedAccountException() {
        return Result.getCustomize(false, -1, "帐号锁定");
    }

    @ExceptionHandler(value = ExcessiveAttemptsException.class)
    public @ResponseBody
    Result ExcessiveAttemptsException() {
        return Result.getCustomize(false, -1, "认证次数超过限制");
    }

}
