package com.sza.website.exception;


import com.sza.website.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.sza.website.enums.StatusCodeEnum.FAIL;

@Getter
@AllArgsConstructor
public class MyException extends RuntimeException{

    /**
     * 错误码
     */
    private Integer code = FAIL.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public MyException(String message) {
        this.message = message;
    }

    public MyException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getMsg();
    }
}
