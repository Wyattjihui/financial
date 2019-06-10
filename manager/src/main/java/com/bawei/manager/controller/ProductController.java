package com.bawei.manager.controller;

import com.bawei.entity.Product;
import com.bawei.manager.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static Logger LOG =LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
     * 添加产品
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){
        System.out.println("product+============="+product);
        LOG.info("创建产品,参数:{}",product);
        Product result = productService.addProduct(product);
        LOG.info("创建产品,结果:{}",result);
        return result;
    }

    /**
     * 查询单个产品
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findOne(@PathVariable String id){
       LOG.info("查询单个产品,id={}",id);
       Product result = productService.findOne(id);
       LOG.info("查询单个产品,结果:{}",result);
        return  result;
    }


}
