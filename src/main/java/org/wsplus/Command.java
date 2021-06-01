package org.wsplus;

import java.util.Map;

/**
 * @Author zwk
 * @Date 2021/5/31
 * @Version 1.0
 * @Description
 **/
public class Command {
    private String path;
    private String body;
    private Map<String,String> params;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
