package com.company.project.auth.filter;

import com.company.project.support.JsonBodyRequest;
import org.apache.shiro.web.servlet.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Api哨兵
 *
 * @author wangzhj
 */
public class ApiGuard extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiGuard.class);

    @Override
    protected void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        LOGGER.info("SSS");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            //Post提交
            String method = request.getMethod();
//            if (!"POST".equals(method.toUpperCase())) {
//                return;
//            }
            String uri = request.getRequestURI();
            //LOGGER.info("URI[{}]'s content type is [{}]", uri, request.getContentType());

            JsonBodyRequest myRequest = new JsonBodyRequest(request);
            //继续执行
            filterChain.doFilter(myRequest, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
