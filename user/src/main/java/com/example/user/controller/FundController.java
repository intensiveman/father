package com.example.user.controller;

import com.example.user.mapper.FundNvlMapper;
import com.example.user.model.FundNvl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fund")
public class FundController {


    @Autowired
    private FundNvlMapper fundNvlMapper;



    @RequestMapping("/get")
    public String getFund(Integer id) {
        FundNvl fundNvl = fundNvlMapper.selectByPrimaryKey(id);
        return fundNvl.toString();
    }
}
