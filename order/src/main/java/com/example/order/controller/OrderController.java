package com.example.order.controller;

import com.example.order.mapper.FundNvlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class OrderController {


    @Autowired
    private FundNvlMapper fundNvlMapper;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        return fundNvlMapper.selectByPrimaryKey(1).toString();
    }

    @RequestMapping("/helloDev")
    public String helloDev() {
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        return fundNvlMapper.selectByPrimaryKey(1).toString();
    }

    @RequestMapping("/helloMerge")
    public String helloMerge() {
        System.out.println("777");
        System.out.println("888");
        return fundNvlMapper.selectByPrimaryKey(1).toString();
    }

}
