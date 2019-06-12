package com.bawei.seller.service;

import com.bawei.api.ProductRpc;
import com.bawei.api.domain.ProductRpcReq;
import com.bawei.entity.Product;
import com.bawei.entity.enums.ProductStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRpcService {
    private static Logger LOG = LoggerFactory.getLogger(ProductRpcService.class);

    @Autowired
    private ProductRpc productRpc;

    // 查询全部产品
    public List<Product> findall(){
        ProductRpcReq req = new ProductRpcReq();
        List<String> status = new ArrayList<>();
        status.add(ProductStatus.IN_SELL.name());
        req.setStatusList(status);
        LOG.info("rpc查询全部产品,请求:{}",req);
        List<Product> result = productRpc.query(req);
        LOG.info("rpc查询全部产品,结果:{}",result);
        return result;
    }

    // 测试方法
    @PostConstruct
    public void testFindAll(){
        findall();
    }
}
