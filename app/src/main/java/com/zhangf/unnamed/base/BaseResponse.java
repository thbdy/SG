package com.zhangf.unnamed.base;

public class BaseResponse<T> {

    /**
     * error : 0
     * errorMsg : 280445ce9cc4bb7a5771befe9f3371ce
     * extra : http://bbs.sgamer.com/api/uc.php?time=1531184831&code=058a1qKIwhiv7Iid2K%2BRMBQPEpoNeuyq33HcU40Tci7hMSsjDSfI2xotPp%2FGHKQ3nIpCBk7fCiOmSZY2WdbTeSFz%2FFqjMYDQax%2FK9RJGFtnTQyZcjS%2FnSZMVyJOpTyM6vYnC3jBeMF%2FlVCcZK%2B37AtTTsk%2BTaGqFCE8D2%2BsZ%2B4eg
     */

    private int error;
    private String errorMsg;
    private T extra;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getExtra() {
        return extra;
    }

    public void setExtra(T extra) {
        this.extra = extra;
    }
}
