package com.example.user_management_system.component;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登入拦截器：对用户 session 进行检查
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      Object loginUser = request.getSession().getAttribute("loginUser");
      if(loginUser == null){  // 未登入，不能放行
         request.setAttribute("errorMessage", "用户尚未登入，请先登入");
         request.getRequestDispatcher("/login").forward(request, response);
         return false;
      }else{   // 已登入，放行
         return true;
      }
   }

   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
   }

   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
   }
}
