package com.bawei.api;

import com.bawei.api.domain.ProductRpcReq;
import com.bawei.entity.Product;
import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.List;

/**
 * 产品相关的rpc服务
 */
@JsonRpcService("rpc/product")
public interface ProductRpc {
    // 复杂查询接口
    List<Product> query(ProductRpcReq req);

    // 单个查询接口
    Product findOne(String id);
}
