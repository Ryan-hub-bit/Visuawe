package com.visuaweProject.error;

//包装器业务异常类实现
public class BusinessException extends Exception implements CommonError {
    private  CommonError commonError;
    // pass parameter for receiving EmBusinessException directly
    public BusinessException(CommonError commonError)
    {
        super();
        this.commonError = commonError;

    }
    //receive customized error as parameter
    public BusinessException(CommonError commonError, String errMsg)
    {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }
    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    // this setErrMsg is to overwrite the errMsg in EmBusinessError
    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
        // when a class implements a interface, it should also be a type of the interface, so this is also a kind of CommonError

    }
}
