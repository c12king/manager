package com.utis;

import java.util.Calendar;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;  


public class TimeInterceptor extends HandlerInterceptorAdapter {  
    // 继承HandlerInterceptorAdapter类  
 

 /* @Override
  public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
	  if(request.getSession().getAttribute("user")==null){
		  return true;
	  }else{
		  response.sendRedirect("/login/login.jsp"); // 返回提示页面  
		  return false;
	  }
	
 
  }  
  @Override
public void afterCompletion(HttpServletRequest request,
		HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
	// TODO Auto-generated method stub
	super.afterCompletion(request, response, handler, ex);
}
  @Override
public void postHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
	// TODO Auto-generated method stub
	super.postHandle(request, response, handler, modelAndView);
}*/
}