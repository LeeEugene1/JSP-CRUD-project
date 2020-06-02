package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		String encodingType = servletRequest.getCharacterEncoding();
		
		if (encodingType == null) {
			encodingType = "UTF-8";
		}
		
		servletRequest.setCharacterEncoding(encodingType);
		
		chain.doFilter(servletRequest, servletResponse);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
