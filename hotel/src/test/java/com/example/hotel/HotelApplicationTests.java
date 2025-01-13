package com.example.hotel;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.hotel.mapper.TbHotelMapper;
import com.example.hotel.model.TbHotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HotelApplicationTests {

    @Autowired
    private TbHotelMapper hotelMapper;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<TbHotel> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(TbHotel::getId, 60223L);

        List<TbHotel> tbHotels = hotelMapper.selectList(wrapper);
        System.out.println(tbHotels.size());
    }

}
