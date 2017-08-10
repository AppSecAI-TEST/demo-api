package com.company.project.auth.filter;

import org.apache.shiro.web.servlet.AdviceFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Api认证
 *
 * @author wangzhj
 */
public class ApiAuth extends AdviceFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAuth.class);

    @Override
    protected boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        try {

        } catch (Exception ex) {
            throw ex;
        }
        return true;
    }

    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
        LOGGER.info("postHandle......");
    }

    @Override
    public void afterCompletion(ServletRequest servletRequest, ServletResponse servletResponse,
                                Exception ex) throws Exception {
    }
}
