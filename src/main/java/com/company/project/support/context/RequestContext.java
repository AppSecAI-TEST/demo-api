package com.company.project.support.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求上下文
 *
 * @author wangzhj
 */
public class RequestContext {

    /**
     * HttpServletRequest
     */
    private HttpServletRequest request;
    /**
     * HttpServletResponse
     */
    private HttpServletResponse response;

    public RequestContext(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }
}
