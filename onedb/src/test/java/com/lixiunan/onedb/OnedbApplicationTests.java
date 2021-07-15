package com.lixiunan.onedb;

import com.lixiunan.onedb.mapper.MallOrderMapper;
import entity.MallOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnedbApplicationTests {

    @Resource
    private MallOrderMapper orderMapper;

    @Test
    public void addOrder(){
        for(int i = 0 ; i < 10 ; i ++){
            MallOrder order = new MallOrder();
            order.setOrderName("第"+i+"个订单");
            orderMapper.insert(order);
        }
    }

}
