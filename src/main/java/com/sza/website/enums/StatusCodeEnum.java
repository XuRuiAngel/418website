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
     * 添加成功
     */
    ADD_SUCCESS(200, "添加成功"),
    /**
     * 更新成功
     */
    UPDATE_SUCCESS(200, "更新成功"),
    /**
     * 删除成功
     */
    DELETE_SUCCESS(200, "删除成功"),
    /**
     * 搜索成功
     */
    SEARCH_SUCCESS(200, "搜索成功"),
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
     * 添加失败
     */
    ADD_FAIL(501, "添加失败"),
    /**
     * 更新失败
     */
    UPDATE_FAIL(501, "更新失败"),
    /**
     * 删除失败
     */
    DELETE_FAIL(501, "删除失败"),
    /**
     * 搜索失败
     */
    SEARCH_FAIL(501, "搜索失败"),
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
