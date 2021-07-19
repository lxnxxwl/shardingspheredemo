package com.lixiunan.twodbhint;

import com.lixiunan.twodbhint.mapper.ProductMapper;
import entity.Product;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwodbHintApplicationTests {

    @Resource
    private ProductMapper productMapper;

    /**
     * 指定查询的表
     * SELECT  id,store_id,product_name,product_status  FROM product
     * Actual SQL: db1 ::: SELECT  id,store_id,product_name,product_status  FROM product_1
     * Actual SQL: db2 ::: SELECT  id,store_id,product_name,product_status  FROM product_1
     */
    @Test
    public void queryByHint1(){
        HintManager hintManager = HintManager.getInstance();
        hintManager.addTableShardingValue("product",1);
        List<Product> products = productMapper.selectList(null);
        products.forEach(product -> System.out.println(product));
        hintManager.close();
    }

    /**
     * Logic SQL: SELECT  id,store_id,product_name,product_status  FROM product
     * Actual SQL: db1 ::: SELECT  id,store_id,product_name,product_status  FROM product_2
     * Actual SQL: db2 ::: SELECT  id,store_id,product_name,product_status  FROM product_2
     */
    @Test
    public void queryByHint2(){
        HintManager hintManager = HintManager.getInstance();
        hintManager.addTableShardingValue("product",2);
        List<Product> products = productMapper.selectList(null);
        products.forEach(product -> System.out.println(product));
        hintManager.close();
    }

}
