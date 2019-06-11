package com.bawei.entity.enums;

public enum OrderType {
    // 订单类型 申购：APPLY，赎回：REDEEM',
    APPLY("申购"),
    REDEEM("赎回"),
    ;

    private String desc;

    OrderType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
