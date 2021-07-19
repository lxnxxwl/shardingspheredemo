package com.lixiunan.twodbcomplex.algorithm;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description : TODO
 * @Author : lixiunan
 * @Date : 2021/7/19
 **/
public class MyComplexTableAlgorithm implements ComplexKeysShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<Long> shardingValue) {
        //获取店铺ID集合
        Collection<Long> storeIdCollection =
                shardingValue.getColumnNameAndShardingValuesMap().get("store_id");
        //获取真实表前缀名称
        String logicTableName = shardingValue.getLogicTableName();
        //创建新集合
        ArrayList<String> result = new ArrayList<String>();
        //策略为取摩尔
        for (Long storeId : storeIdCollection){
            BigInteger storeIdInteger = BigInteger.valueOf(storeId);
            BigInteger key =
                    (storeIdInteger.mod(new BigInteger("2"))).add(new BigInteger("1"));
            result.add(logicTableName+"_"+key);
        }
        return result;
    }
}
