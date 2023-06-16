package com.example.furniture.admin.server.common.web;

/**
 * @author YGKING  e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/14 17:46
 */
public enum ServiceCode {

    /**
     * 操作成功
     */
    OK(20000),
    /**
     * 请求参数格式错误
     */
    ERROR_BAD_REQUEST(40000),
    /**
     * 数据不存在
     */
    ERROR_NOT_FOUND(40400),
    /**
     * 数据冲突
     */
    ERROR_CONFLICT(40900),
    /**
     * 未知错误
     */
    ERROR_UNKNOWN(99999)
    ;
    
    private final Integer value;

    ServiceCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
