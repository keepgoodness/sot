package org.sot.interceptors;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Enumeration;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Jordan
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		String extension = uri.substring((uri.lastIndexOf(".") + 1));
		boolean isItLocalRes = Stream.of(new String[]{"png", "css", "js", "img", "jpg"}).anyMatch((String t) -> {
			return t.equals(extension);
		});
		Principal userPrincipal = request.getUserPrincipal();
		String user = (userPrincipal != null) ? userPrincipal.getName() : "not yet authenticated";
		if (!isItLocalRes) {
			log.info(
					LocalDate.now() + " " + LocalTime.now()
					+ "[request]"
					//					+ "[ IP: " + getRemoteAddr(request) + "]"
					+ "[ USER:" + user + "]"
					+ "[" + request.getMethod() + "]"
					+ " URL:" + request.getRequestURI() + getParameters(request));
		}
		return true;
	}

	private String getParameters(HttpServletRequest request) {
		StringBuffer posted = new StringBuffer();
		Enumeration<String> e = request.getParameterNames();
		if (e.hasMoreElements()) {
			posted.append("?");
		}
		while (e.hasMoreElements()) {
			if (posted.length() > 1) {
				posted.append("&");
			}
			String curr = (String) e.nextElement();
			posted.append(curr + "=" + request.getParameter(curr));
		}
		return posted.toString();
	}

	private String getRemoteAddr(HttpServletRequest request) {
		String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
		if (ipFromHeader != null && ipFromHeader.length() > 0) {
			log.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
			return ipFromHeader;
		}
		return request.getRemoteAddr();
	}

}
