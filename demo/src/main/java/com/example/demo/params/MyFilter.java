package com.example.demo.params;

import org.apache.catalina.filters.RequestFilter;
import org.apache.juli.logging.Log;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/myservlet")
public class MyFilter extends /*OncePerRequestFilter*/ RequestFilter {

   /* @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ServletContext servletContext = request.getServletContext();

        servletContext.log("/myservlet was filtered!");

        filterChain.doFilter(request, response);

    }*/

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext servletContext = servletRequest.getServletContext();

        servletContext.log("/myservlet was filtered!");

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    protected Log getLogger() {
        return null;
    }
}
