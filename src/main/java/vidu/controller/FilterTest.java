package vidu.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/servlet2"})
public class FilterTest implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Chay filter");
		
		if(request.getParameter("uname") != null && request.getParameter("psw") != null) {
			if("Huy".equals(request.getParameter("uname")) && "123".equals(request.getParameter("psw"))) {
				System.out.println("Filter cho qua");
				chain.doFilter(request, response); // filter dong y cho qua
			}
			else {
				System.out.println("Filter deo cho qua");
				request.getRequestDispatcher("/views/trang-chu.jsp").forward(request, response);
			}
		} else {
			System.out.println("Ai cho m ma m vao???");
			request.getRequestDispatcher("/views/trang-chu.jsp").forward(request, response);
		}	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
