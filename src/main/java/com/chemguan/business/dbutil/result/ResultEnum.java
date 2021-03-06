package com.chemguan.business.dbutil.result;

import lombok.Getter;

/**
 * Created by sw on 18/10/8.
 */
@Getter
public enum ResultEnum {
    USER_EXISTS(4001,"用户已经存在"),
    USER_NOT_EXISTS(4002,"用户不存在"),
    SAVE_ERROR(4003,"添加失败"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
