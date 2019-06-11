package com.bawei.entity.enums;

public enum OrderStatus {
    // 订单状态 初始化：INIT， 处理中：PROCESS，成功：SUCCESS，失败：FAIL',
    INIT("初始化"),
    PROCESS("处理中"),
    SUCCESS("成功"),
    FAIL("失败"),
    ;

    private String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
