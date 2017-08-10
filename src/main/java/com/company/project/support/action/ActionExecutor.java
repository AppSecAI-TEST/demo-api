package com.company.project.support.action;

import com.company.project.support.action.Action;
import com.company.project.webapi.web.support.context.SpringContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action执行器
 *
 * @author wangzhj
 */
public class ActionExecutor {

    /**
     * 执行Action
     *
     * @param request
     * @param response
     * @param clazz  执行类
     * @return Map<String, Object>
     */
    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response,
                                              Class<? extends Action> clazz) {
        if (!SpringContext.containsBean(clazz)) {
            throw new IllegalStateException("Bean不存在");
        }
        Action action = SpringContext.getBean(clazz);
        return action.doExecute(request, response);
    }
}
