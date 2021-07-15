package com.lixiunan.twodb;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.lixiunan.twodb.mapper.MallOrderMapper;
import entity.MallOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TwodbApplicationTests {
    @Resource
    private MallOrderMapper orderMapper;

    /**
     * 向两个数据库四张表插入数据
     */
    @Test
    public void addOrderToDB() {
        for(int i = 0 ; i < 10 ; i ++){
            MallOrder order = new MallOrder();
            order.setOrderName("分库后的第"+i+"个订单");
            orderMapper.insert(order);
        }
    }

    /**
     * 按id查找某条数据
     * Logic  SQL: SELECT  id,order_name  FROM mall_order WHERE (id = ?)
     * Actual SQL: db2 ::: SELECT  id,order_name  FROM mall_order_2
     * shardingsphere已经按策略优化查询sql，仅在id可能存在的test2库的mall_order_2这张表中进行一次查询
     */
    @Test
    public void queryDataById(){
        QueryWrapper<MallOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("id",1415550634731560961L);
        MallOrder mallOrder = orderMapper.selectOne(wrapper);
        System.out.println(mallOrder);
    }

    /**
     * 范围查询：ID在xxx～zzz之间的所有数据查询
     * Inline strategy cannot support this type sharding:RangeRouteValue
     * 使用inline模式是不支持范围查询的
     */
    @Test
    public void queryDataByRang(){
        QueryWrapper<MallOrder> wrapper = new QueryWrapper<>();
        wrapper.between("id",1415550634731560961L,1415550634748338178L);
        List<MallOrder> mallOrders = orderMapper.selectList(wrapper);
        mallOrders.forEach(mallOrder -> System.out.println(mallOrder));
    }

    /**
     * 按id排序查询出所有数据
     * Logic  SQL: SELECT  id,order_name  FROM mall_order
     * Actual SQL: db1 ::: SELECT  id,order_name  FROM mall_order_1
     * Actual SQL: db1 ::: SELECT  id,order_name  FROM mall_order_2
     * Actual SQL: db2 ::: SELECT  id,order_name  FROM mall_order_1
     * Actual SQL: db2 ::: SELECT  id,order_name  FROM mall_order_2
     * 两个库的四张表全部查询一遍（有待优化）
     */
    @Test
    public void queryDataBySort(){
        QueryWrapper<MallOrder> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<MallOrder> mallOrders = orderMapper.selectList(wrapper);
        mallOrders.forEach(mallOrder -> System.out.println(mallOrder));
    }

}
