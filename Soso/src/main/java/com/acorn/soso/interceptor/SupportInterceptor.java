package com.acorn.soso.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


//admin 계정으로 로그인 했을때 support 페이지 기능 활성화 할 인터셉터
@Component
public class SupportInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
	throws Exception{
		//세션 객체의 참조값을 얻어와서 
	    HttpSession session=request.getSession();
	    String id=(String)session.getAttribute("id");
	    // 사용자 ID가 "admin"인 경우에만 isAdmin 속성을 추가하여 전달
	    boolean isAdmin = id != null && id.equals("admin");
	    request.setAttribute("isAdmin", isAdmin);
	  //admin 계정이라면 흐름 이어가기
	return true;
	}

}
