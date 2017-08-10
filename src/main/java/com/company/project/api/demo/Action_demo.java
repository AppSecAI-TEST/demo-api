package com.company.project.api.demo;

import com.company.project.support.action.BaseAction;
import com.company.project.support.context.RequestContext;
import com.company.project.support.context.SessionUserInfo;

import java.util.Map;

/**
 * Created by wangzhj on 2017/8/10.
 */
public class Action_demo extends BaseAction {

    @Override
    public void checkData(SessionUserInfo userInfo, RequestContext cxt, Map<String, Object> param) {
        LOGGER.info("sdfsfsdf");
    }

    @Override
    public Map<String, Object> execute(SessionUserInfo userInfo, RequestContext cxt, Map<String, Object> param) {
        return null;
    }
}
