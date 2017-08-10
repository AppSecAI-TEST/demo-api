package com.company.project.support;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Json Request
 *
 * @author wangzhj
 */
public class JsonBodyRequest extends HttpServletRequestWrapper {

    /**
     * 请求体
     */
    private byte[] body = new byte[]{};
    /**
     * 参数Map
     */
    private Map<String, Object> param;

    public JsonBodyRequest(HttpServletRequest request) {
        super(request);
        //可重复读
//        String bodyStr = HttpServlets.getBodyString(request);
//        if(!Strings.isNullOrEmpty(bodyStr)){
//            body = bodyStr.getBytes(Charset.forName("UTF-8"));
//            params = JsonUtil.fromJson(bodyStr);
//        }
    }

//    @Override
//    public BufferedReader getReader() throws IOException {
//        return new BufferedReader(new InputStreamReader(getInputStream()));
//    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream baIs = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return baIs.read();
            }
        };
    }

    @Override
    public Map<String, Object> getParameterMap() {
        return this.param;
    }
}
