package com.bawei.manager.service;

import com.bawei.entity.Product;
import com.bawei.entity.enums.ProductStatus;
import com.bawei.manager.error.ErrorEnum;
import com.bawei.manager.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Assert.notNull(product.getId(),ErrorEnum.ID_NOT_NULL.getCode());
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

    /**
     * 复杂查询
     * @param idList
     * @param minRewardRate
     * @param maxRewardRate
     * @param statusList
     * @param pageable
     * @return
     */
    public Page<Product> query(List<String> idList, BigDecimal minRewardRate,
                               BigDecimal maxRewardRate, List<String> statusList, Pageable pageable) {
        LOG.debug("查询产品,idList={},minRewardRate={},maxRewardRate={},statusList={},pageable={}",
                idList,minRewardRate,maxRewardRate,statusList,pageable);
        Specification<Product> specification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Expression<String> idCol = root.get("id");
                Expression<BigDecimal> rewardRateCol = root.get("rewardRate");
                Expression<String> statusCol = root.get("status");
                List<Predicate> predicates = new ArrayList<>();
                if (idList!=null && idList.size()>0){
                    predicates.add(idCol.in(idList));
                }
                if (minRewardRate!=null && BigDecimal.ZERO.compareTo(minRewardRate) < 0) {
                    predicates.add(cb.ge(rewardRateCol, minRewardRate));
                }
                if (maxRewardRate!=null && BigDecimal.ZERO.compareTo(maxRewardRate) < 0) {
                    predicates.add(cb.le(rewardRateCol, maxRewardRate));
                }

                if (statusList!=null && statusList.size()>0){
                    predicates.add(statusCol.in(statusList));
                }
                criteriaQuery.where(predicates.toArray(new Predicate[0]));
                return null;
            }
        };

        Page<Product> page = repository.findAll(specification, pageable);
        LOG.debug("查询产品，结果={}", page);
        return page;
    }
}
