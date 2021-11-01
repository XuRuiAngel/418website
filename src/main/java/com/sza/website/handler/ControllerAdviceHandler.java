package com.sza.website.handler;

import com.sza.website.exception.MyException;
import com.sza.website.vo.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.Objects;

import static com.sza.website.enums.StatusCodeEnum.SYSTEM_ERROR;
import static com.sza.website.enums.StatusCodeEnum.VALID_ERROR;


/**
 * 全局异常处理
 **/
@Log4j2
@RestControllerAdvice
public class ControllerAdviceHandler {

    /**
     * 处理服务异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(value = MyException.class)
    public Result<?> errorHandler(MyException e) {
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 处理参数校验异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> errorHandler(MethodArgumentNotValidException e) {
        return Result.fail(VALID_ERROR.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * 处理数据绑定异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(BindException.class)
    public Result<?> errorHandler(BindException e) {
        return Result.fail(VALID_ERROR.getCode(), Objects.requireNonNull(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage()));
    }

    /**
     * 处理系统异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> errorHandler(Exception e) {
        e.printStackTrace();
        return Result.fail(SYSTEM_ERROR.getCode(), SYSTEM_ERROR.getMsg());
    }

}
