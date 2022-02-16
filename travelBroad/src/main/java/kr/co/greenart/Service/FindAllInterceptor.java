package kr.co.greenart.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class FindAllInterceptor implements HandlerInterceptor {
	
	//가기전에 뺏는걸 프리핸드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("userId") != null) {
			return true;
		}else {
			response.sendRedirect("/mapping/login");
			return false;
		}
	}
	// 갔다 오는 것을 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}
	//뷰가 만들어지기 전에, 뷰가 만들어진 후 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
		
	}

	
}
