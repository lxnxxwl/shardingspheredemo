package com.lixiunan.twodbstandard;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixiunan.twodbstandard.mapper.MallOrderMapper;
import entity.MallOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TwodbStandardApplicationTests {

    @Resource
    private MallOrderMapper orderMapper;
    /**
     * 向两个数据库四张表插入数据
     */
    @Test
    public void addOrderToDB() {
        for(int i = 0 ; i < 10 ; i ++){
            MallOrder order = new MallOrder();
            order.setOrderName("standard中第"+i+"个订单");
            orderMapper.insert(order);
        }
    }

    /**
     * 范围查询：
     * Logic SQL: SELECT  id,order_name  FROM mall_order WHERE (id BETWEEN ? AND ?)
     * Actual SQL: db1 ::: SELECT  id,order_name  FROM mall_order_1 WHERE (id BETWEEN ? AND ?) ::: [1415550634731560961, 1415550634748338178]
     * Actual SQL: db1 ::: SELECT  id,order_name  FROM mall_order_2 WHERE (id BETWEEN ? AND ?) ::: [1415550634731560961, 1415550634748338178]
     * Actual SQL: db2 ::: SELECT  id,order_name  FROM mall_order_1 WHERE (id BETWEEN ? AND ?) ::: [1415550634731560961, 1415550634748338178]
     * Actual SQL: db2 ::: SELECT  id,order_name  FROM mall_order_2 WHERE (id BETWEEN ? AND ?) ::: [1415550634731560961, 1415550634748338178]
     *
     *
     * 使用inline模式是不支持范围查询的，standard可以按照算法提供的方法或表名库名进行范围查找
     */
    @Test
    public void queryDataByRang(){
        QueryWrapper<MallOrder> wrapper = new QueryWrapper<>();
        wrapper.between("id",1415550634731560961L,1415550634748338178L);
        List<MallOrder> mallOrders = orderMapper.selectList(wrapper);
        mallOrders.forEach(mallOrder -> System.out.println(mallOrder));
    }

}
