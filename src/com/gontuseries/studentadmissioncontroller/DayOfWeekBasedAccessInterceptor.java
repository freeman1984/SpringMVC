package com.gontuseries.studentadmissioncontroller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws IOException {
		System.out.println("calling prehandle method : ");
		Calendar cal = Calendar.getInstance();

		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			response.getWriter().write(
					"the website is close on a  " + dayOfWeek
							+ ", try another day");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out
				.println("handlerinterceptoradaptor called posthandle method for	"
						+ request.getRequestURI().toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out
				.println("handlerinterceptoradaptor called afterCompletion method for	"
						+ request.getRequestURI().toString());
	}
}
