package com.jp.girl.exception;

import com.jp.girl.dto.Result;
import com.jp.girl.dto.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private  final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof  GirlException){
            GirlException girlException = (GirlException)e;
            return  ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.info("[系统异常]",e,e.getMessage());
            return ResultUtil.error(-1,"未知错误");
        }

    }

}
