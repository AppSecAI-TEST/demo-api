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

        LOGGER.info("ParameterMap===>" + request.getParameterMap());
        Map<String, Object> result;
        try {
            //参数
            Map<String, Object> param = request.getParameterMap();
            LOGGER.info("===> i: {}");
            //包装
            RequestContext cxt = new RequestContext(request, response);
            SessionUserInfo userInfo = null;
            //验证
            checkData(userInfo, cxt, param);
            //执行
            Map<String, Object> data = execute(userInfo, cxt, param);
            //结果
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
     * @param param
     */
    public abstract void checkData(SessionUserInfo userInfo, RequestContext cxt,
                                   Map<String, Object> param);

    /**
     * 执行逻辑
     *
     * @param userInfo
     * @param cxt
     * @param param
     * @return Map<String, Object>
     */
    public abstract Map<String, Object> execute(SessionUserInfo userInfo, RequestContext cxt,
                                                Map<String, Object> param);
}
