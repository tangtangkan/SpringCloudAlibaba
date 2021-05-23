package com.ttk.controller;

import com.ttk.entities.CommonResult;
import com.ttk.entities.Product;
import com.ttk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/product/findById/{pid}", method = RequestMethod.GET)
    public CommonResult<Product> findById (@PathVariable("pid") Long pid) {
        Product product = productService.findById(pid);
        if (product != null) {
            return new CommonResult<Product>(200, "查询成功，端口" + port, product);
        } else {
            return new CommonResult<>(404, "没有此条数据", null);
        }
    }

}
