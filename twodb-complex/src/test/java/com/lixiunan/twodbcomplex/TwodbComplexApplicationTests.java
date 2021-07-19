package com.lixiunan.twodbcomplex;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixiunan.twodbcomplex.mapper.ProductMapper;
import com.lixiunan.twodbcomplex.mapper.StoreMapper;
import entity.MallOrder;
import entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwodbComplexApplicationTests {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private StoreMapper storeMapper;

    /**
     *添加数据
     */
    @Test
    public void add() {
        for(int i = 0 ; i < 10 ; i ++){
            Product product = new Product();
            Long idLong = Long.valueOf(202110L + i);
            product.setId(idLong);
            Long storeIdLong = Long.valueOf(676 + i);
            product.setStoreId(storeIdLong);
            product.setProductName("complex第"+i+"个商品");
            product.setProductStatus(((i % 2)+1)+"");
            productMapper.insert(product);
        }
    }

    /**
     * 缺少参数不能查询
     */
    @Test
    public void queryRange(){
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.between("store_id",670L,680L);
        List<Product> products = productMapper.selectList(wrapper);
        products.forEach(product -> System.out.println(product));
    }

    /**
     * 支持（必须）混合ID复杂查询，如配置中的
     */
    @Test
    public void queryCourseComplex(){
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.between("id",202100L,202114L);
        wrapper.eq("store_id",677L);
        List<Product> products = productMapper.selectList(wrapper);
        products.forEach(product -> System.out.println(product));
    }

}
