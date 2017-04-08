package com.jp.girl.exception;

import com.jp.girl.enums.ResultEnum;

import javax.persistence.criteria.CriteriaBuilder;

public class GirlException extends RuntimeException{

    private Integer code;


    public GirlException (ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code =resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
