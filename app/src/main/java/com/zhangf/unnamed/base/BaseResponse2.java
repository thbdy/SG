package com.zhangf.unnamed.base;

public class BaseResponse2<T> {
    private String Version;
    private String Charset;
    private T Variables;
    private String request_id;
    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getCharset() {
        return Charset;
    }

    public void setCharset(String charset) {
        Charset = charset;
    }

    public T getVariables() {
        return Variables;
    }

    public void setVariables(T variables) {
        Variables = variables;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }




}
