package com.sza.website.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 接口状态码枚举
 *
 * @author yezhqiu
 * @date 2021/06/11
 **/
@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 没有操作权限
     */
    AUTHORIZED(403, "没有操作权限"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(500, "系统异常"),
    /**
     * 失败
     */
    FAIL(501, "操作失败"),
    /**
     * 参数校验失败
     */
    VALID_ERROR(502, "参数格式不正确"),
    /**
     * 用户名已存在
     */
    USERNAME_EXIST(503, "用户名已存在"),
    /**
     * 用户名不存在
     */
    USERNAME_NOT_EXIST(52002, "用户名不存在");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String msg;

}
