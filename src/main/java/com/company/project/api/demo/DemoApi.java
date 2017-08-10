package com.company.project.api.demo;

import com.company.project.support.action.ActionExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wangzhj on 2017/8/10.
 */
@Controller
@RequestMapping("/demo")
public class DemoApi {

    @RequestMapping("/say_hi")
    @ResponseBody
    public Map<String, Object> say_hi(HttpServletRequest request, HttpServletResponse response) {
        return ActionExecutor.execute(request, response, Action_say_hi.class);
    }

    @RequestMapping("/say_bye")
    @ResponseBody
    public Map<String, Object> say_bye(HttpServletRequest request, HttpServletResponse response) {
        return ActionExecutor.execute(request, response, Action_say_hi.class);
    }
}
