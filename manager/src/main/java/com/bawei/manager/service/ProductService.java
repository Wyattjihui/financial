package com.bawei.manager.service;

import com.bawei.entity.Product;
import com.bawei.entity.enums.ProductStatus;
import com.bawei.manager.repositories.ProductRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;


@Service
public class ProductService {

    private static Logger LOG = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository repository;

    /**
     * 添加产品
     * @param product
     * @return
     */
    public Product addProduct(Product product){
        LOG.debug("创建产品,参数:{}",product);
        // 校验数据
        checkProduct(product);
        // 设置默认值
        setDefault(product);
        Product result = repository.save(product);
        LOG.debug("创建产品,结果:{}",result);
        return result;
    }

    /**
     * 设置默认值
     * 创建时间,更新时间,投资步长,锁定期,状态
     * @param product
     */
    private void setDefault(Product product) {
        // 设置创建时间
        if (product.getCreateAt()==null){
            product.setCreateAt(new Date());
        }
        // 设置更新时间
        if (product.getUpdateAt()==null){
            product.setUpdateAt(new Date());
        }
        // 设置投资步长
        if (product.getStepAmount()==null){
            product.setStepAmount(BigDecimal.ZERO);
        }
        //设置锁定期
        if (product.getLockTerm()==null){
            product.setLockTerm(0);
        }
        // 设置状态为审核中
        if (product.getStatus()==null){
            product.setStatus(ProductStatus.AUDINTING.name());
        }

    }

    /**
     * 产品校验数据
     * 1 非空校验
     * 2 收益率要在0-30以内
     * 3 投资步长需为整数
     * @param product
     */
    private void checkProduct(Product product) {
        Assert.notNull(product.getId(),"数据id不可为空");
        Assert.notNull(product.getName(),"名称不可为空");
        Assert.notNull(product.getThresholdAmount(),"起投金额不可为空");
        Assert.notNull(product.getStepAmount(),"投资步长不可为空");
        Assert.notNull(product.getLockTerm(),"锁定期不可为空");
        Assert.notNull(product.getRewardRate(),"收益率不可为空");
        Assert.notNull(product.getStatus(),"状态不可为空");
        Assert.isTrue(BigDecimal.ZERO.compareTo(product.getRewardRate())<0
        && BigDecimal.valueOf(30).compareTo(product.getRewardRate())>=0,"收益率范围错误");
        Assert.isTrue(BigDecimal.valueOf(product.getStepAmount().longValue())
                .compareTo(product.getStepAmount())==0,"投资步长需为整数");
    }


    /**
     * 查询单个产品
     * @param id
     * @return
     */
    public Product findOne(String id) {
        LOG.debug("查询单个产品,id={}",id);
        Product result = repository.findOne(id);
        LOG.debug("查询单个产品,结果:{}",result);
        return result;
    }
}
