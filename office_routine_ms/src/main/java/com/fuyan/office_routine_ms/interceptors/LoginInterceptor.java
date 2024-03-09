package com.fuyan.office_routine_ms.interceptors;


import com.fuyan.office_routine_ms.pojo.User;
import com.fuyan.office_routine_ms.servcie.UserService;
import com.fuyan.office_routine_ms.utils.JwtUtil;
import com.fuyan.office_routine_ms.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户过滤拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals("OPTIONS")){ // 直接响应数据 （***** 这里是最重要的if ***）
            //response.setStatus(200);
            return true;
        }
        //获取token                                                  
        String token = request.getHeader("Authorization");
        try {
            //根据token获取redis中的用户
            Map<Object, Object> claims = stringRedisTemplate.opsForHash().entries(token);
            shoUserInfo(claims,request,token);
            if (claims.isEmpty()){
                response.setStatus(401);
                return false;//不放行
            }
            //把业务数据存到ThreadLocal中
            ThreadLocalUtil.set(claims);
            //刷新token的有效期
            stringRedisTemplate.expire(token,30, TimeUnit.MINUTES);
            return true;//放行
        }catch (Exception e){
            response.setStatus(401);
            return false;//不放行
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }


    public void shoUserInfo(Map<Object, Object> claims,HttpServletRequest request,String token){
        User user = userService.findByUsername((String) claims.get("username"));
        System.out.println("-------------------------------------------------------------");
        System.out.println("用户令牌：" + token);
        System.out.println("用户信息：" + user);
        System.out.println("请求方法：" + request.getMethod()+":"+ request.getRequestURI());
        System.out.println("-------------------------------------------------------------");
    }

}


