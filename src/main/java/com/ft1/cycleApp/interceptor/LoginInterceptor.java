package com.ft1.cycleApp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** define a interceptor */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * check if global session object has uid, if has, then pass, if not, redirection to login page
     * @param request request object
     * @param response response object
     * @param handler handler(url+controller: mapping)
     * @return if return value is true represent pass current request, if false, represent intercept current request
     * @throws Exception
     * */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // HttpServletRequest object to get session object
        Object obj = request.getSession().getAttribute("uid");
        if (obj == null) {
            // user hasn't logged in to system, redirection to login page
            response.sendRedirect("/web/login.html");
            // after invoke
            return false;
        }

        // request pass
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
