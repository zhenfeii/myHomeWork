package com.gdkyit.utils;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class ResponseMessage {
    String code;
    String error;
    Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseMessage(String code, String error, Object data) {
        this.code = code;
        this.error = error;
        this.data = data;
    }
}
