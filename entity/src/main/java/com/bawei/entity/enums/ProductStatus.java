package com.bawei.entity.enums;

/**
 * 产品状态
 */
public enum ProductStatus {
    AUDINTING("审核中"),
    IN_SELL("销售中"),
    LOCKED("暂停销售"),
    FINISHED("已结束"),
    ;
    //  状态 审核中：AUDINTING，销售中：IN_SELL，暂停销售：LOCKED，已结束：FINISHED,

    private String desc;

    ProductStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
