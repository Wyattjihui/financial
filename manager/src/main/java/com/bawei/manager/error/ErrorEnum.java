package com.bawei.manager.error;

import java.util.Map;

/**
 * 错误种类
 */
public enum ErrorEnum {
    ID_NOT_NULL("F001","编号不可为空",false),
    UNKNOWN("999","未知异常",false),
    ;
    private String code;
    private String message;
    private boolean canRetry;

    ErrorEnum(String code, String message, boolean canRetry) {
        this.code = code;
        this.message = message;
        this.canRetry = canRetry;
    }

    public static ErrorEnum getByCode(String code) {
        for (ErrorEnum value : ErrorEnum.values()) {
            if (value.getCode().equals(code)){
                return value;
            }
        }
        return UNKNOWN;
    }


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCanRetry() {
        return canRetry;
    }
}
