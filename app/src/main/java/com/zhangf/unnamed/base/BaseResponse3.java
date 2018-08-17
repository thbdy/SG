package com.zhangf.unnamed.base;

public class BaseResponse3<T> {

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    private int error;
    private T items;

}
