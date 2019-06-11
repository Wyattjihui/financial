package com.bawei.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product {
    @Id
    private String id;   //  编号
    private String name;   //  名称
    private BigDecimal thresholdAmount;   // 起投金额,
    private BigDecimal stepAmount;   //  投资步长,
    private Integer lockTerm;   //  锁定期 单位天,
    private BigDecimal rewardRate;   //  收益率 0-100，百分比,
    /**
     * @see com.bawei.entity.enums.ProductStatus
     */
    @ApiModelProperty(value = "状态",dataType = "com.bawei.entity.enums.ProductStatus")
    private String status;   //   状态 审核中：AUDINTING，销售中：IN_SELL，暂停销售：LOCKED，已结束：FINISHED,
    private String memo;   //  varch 备注,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;   //  创建时间,
    private String createUser;   //  创建者ID,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;   //  更新时间,
    private String updateUser;   //   更新者ID,

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public Product() {
    }

    public Product(String id, String name, BigDecimal thresholdAmount, BigDecimal stepAmount, Integer lockTerm, BigDecimal rewardRate, String status, String memo, Date createAt, String createUser, Date updateAt, String updateUser) {
        this.id = id;
        this.name = name;
        this.thresholdAmount = thresholdAmount;
        this.stepAmount = stepAmount;
        this.lockTerm = lockTerm;
        this.rewardRate = rewardRate;
        this.status = status;
        this.memo = memo;
        this.createAt = createAt;
        this.createUser = createUser;
        this.updateAt = updateAt;
        this.updateUser = updateUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getThresholdAmount() {
        return thresholdAmount;
    }

    public void setThresholdAmount(BigDecimal thresholdAmount) {
        this.thresholdAmount = thresholdAmount;
    }

    public BigDecimal getStepAmount() {
        return stepAmount;
    }

    public void setStepAmount(BigDecimal stepAmount) {
        this.stepAmount = stepAmount;
    }

    public Integer getLockTerm() {
        return lockTerm;
    }

    public void setLockTerm(Integer lockTerm) {
        this.lockTerm = lockTerm;
    }

    public BigDecimal getRewardRate() {
        return rewardRate;
    }

    public void setRewardRate(BigDecimal rewardRate) {
        this.rewardRate = rewardRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
