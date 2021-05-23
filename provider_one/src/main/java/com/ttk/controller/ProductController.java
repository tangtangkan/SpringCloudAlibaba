package com.ttk.controller;

import com.ttk.entities.CommonResult;
import com.ttk.entities.Product;
import com.ttk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    private final DiscoveryClient discoveryClient;

    @Autowired
    public ProductController(ProductService productService, DiscoveryClient discoveryClient) {
        this.productService = productService;
        this.discoveryClient = discoveryClient;
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

    @RequestMapping(value = "/product/discovery", method = RequestMethod.GET)
    public DiscoveryClient discovery () {
        List<String> services = discoveryClient.getServices();
        for (String str : services) {
            System.out.println("微服务" + str);
        }
        List<ServiceInstance> provider = discoveryClient.getInstances("PROVIDER");
        for (ServiceInstance serviceInstance : provider) {
            System.out.println("名称：" + serviceInstance.getInstanceId() + "，地址：" + serviceInstance.getHost() + ",端口：" + serviceInstance.getPort() + "，路径：" + serviceInstance.getUri());
        }
        return discoveryClient;
    }

}
