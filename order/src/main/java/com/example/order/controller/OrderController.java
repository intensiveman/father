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
        return fundNvlMapper.selectByPrimaryKey(1).toString();
    }

}
