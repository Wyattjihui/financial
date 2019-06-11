package com.bawei.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "ordert")
public class Order {

    @Id
    private String orderId;   // 订单编号',
    private String chanId;   // 渠道编号 套壳公司编号',
    private String productId;   // 产品编号',
    private String chanuserId;   // 用户编号 套壳公司的用户编号',
    /**
     * @see com.bawei.entity.enums.OrderType
     */
    private String orderType;   // 订单类型 申购：APPLY，赎回：REDEEM',
    /**
     * @see com.bawei.entity.enums.OrderStatus
     */
    private String orderStatus;   // '订单状态 初始化：INIT， 处理中：PROCESS，成功：SUCCESS，失败：FAIL',
    private String outerorderId;   // 外部订单编号 套壳公司的订单编号',
    private String amount;   // 订单金额',
    private String memo;   // 备注',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;   // 创建时间',
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;   // 更新时间',

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getChanId() {
        return chanId;
    }

    public void setChanId(String chanId) {
        this.chanId = chanId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getChanuserId() {
        return chanuserId;
    }

    public void setChanuserId(String chanuserId) {
        this.chanuserId = chanuserId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOuterorderId() {
        return outerorderId;
    }

    public void setOuterorderId(String outerorderId) {
        this.outerorderId = outerorderId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
