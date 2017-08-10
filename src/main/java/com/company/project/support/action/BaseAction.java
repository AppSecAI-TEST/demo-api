package com.company.project.support.action;

import com.company.project.support.Results;
import com.company.project.support.context.RequestContext;
import com.company.project.support.context.SessionUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandles;
import java.util.Map;

/**
 * 基础Action
 *
 * @author wangzhj
 */
public abstract class BaseAction implements Action {

    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public final Map<String, Object> doExecute(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> result;
        try {
            Map<String, Object> params = request.getParameterMap();
            LOGGER.info("===> i: {}");
            //
            RequestContext cxt = new RequestContext(request, response);
            SessionUserInfo userInfo = null;
            //
            checkData(userInfo, cxt, params);
            //
            Map<String, Object> data = execute(userInfo, cxt, params);
            //
            result = Results.buildOk(data);
            LOGGER.info("===> o: {}");
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * 验证参数
     *
     * @param userInfo
     * @param cxt
     * @param params
     */
    public abstract void checkData(SessionUserInfo userInfo, RequestContext cxt, Map<String, Object> params);

    /**
     * 执行逻辑
     *
     * @param userInfo
     * @param cxt
     * @param params
     * @return Map<String, Object>
     */
    public abstract Map<String, Object> execute(SessionUserInfo userInfo, RequestContext cxt, Map<String, Object> params);
}
