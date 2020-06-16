package com.visuaweProject.error;

import java.util.PriorityQueue;

public enum EmBusinessError implements CommonError {
    PARAMETER_VALIDATION_ERROR(00001,"Invalid parameter"),
    UNKNOWN_ERROR(20002,"Unknown Error"),
    USER_NOT_EXIST(10001,"User not exist"),
    ;

    private int errCode;
    private String errMsg;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
