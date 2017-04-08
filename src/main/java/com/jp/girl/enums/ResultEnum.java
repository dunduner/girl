package com.jp.girl.enums;

/**
 * Created by Zhangning on 2017/4/8.
 */
public enum ResultEnum {
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    XIAOXUE(100,"我认为你还在上小学"),
    CHUZHONG(101,"你肯定这个年龄已经上初中")
    ;
    private  Integer code;

    private  String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
