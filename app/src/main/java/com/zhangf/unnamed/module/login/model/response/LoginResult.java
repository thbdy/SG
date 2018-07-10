package com.zhangf.unnamed.module.login.model.response;

public class LoginResult {

    /**
     * errorMsg : 参数错误
     * error : 1
     */

    private String errorMsg;
    private int error;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}
