package com.bawei.api.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.math.BigDecimal;
import java.util.List;

public class ProductRpcReq {
    private List<String> idList;
    private BigDecimal minRewardRate;
    private BigDecimal maxRewardRate;
    private List<String> statusList;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public BigDecimal getMinRewardRate() {
        return minRewardRate;
    }

    public void setMinRewardRate(BigDecimal minRewardRate) {
        this.minRewardRate = minRewardRate;
    }

    public BigDecimal getMaxRewardRate() {
        return maxRewardRate;
    }

    public void setMaxRewardRate(BigDecimal maxRewardRate) {
        this.maxRewardRate = maxRewardRate;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }
}
