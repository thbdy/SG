package com.zhangf.unnamed.module.main.model;

/**
 * Created by 75232 on 2018/9/5
 * Email：752323877@qq.com
 */
public class SignResult {

    /**
     * error : 0
     * errorMSG : 签到成功,获得金币25木头29
     */

    private int error;
    private String errorMSG;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrorMSG() {
        return errorMSG;
    }

    public void setErrorMSG(String errorMSG) {
        this.errorMSG = errorMSG;
    }
}
