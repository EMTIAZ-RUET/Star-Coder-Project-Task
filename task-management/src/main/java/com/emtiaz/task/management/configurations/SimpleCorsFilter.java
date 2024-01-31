package com.emtiaz.task.management.configurations;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {

       public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException , ServletException
       {
           HttpServletResponse response = (HttpServletResponse) res;
           HttpServletRequest  request = (HttpServletRequest) req;

           Map<String,String> map = new HashMap<>();

           String originHeader = request.getHeader("origin");

           response.setHeader("Access-Control-Allow-Origin",originHeader);
           response.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,OPTIONS,DELETE");
           response.setHeader("Access-Control-Max-Age","3600");
           response.setHeader("Access-Control-Allow-Header","*");

           if("OPTIONS".equalsIgnoreCase(request.getMethod()))
           {
                response.setStatus(HttpServletResponse.SC_OK);
           }
           else
           {
               chain.doFilter(req,res);
           }



       }

       public void init(FilterConfig filterConfig)
       {

       }

       public void destroy()
       {

       }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
