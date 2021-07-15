package com.lixiunan.twodbstandard.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Random;

/**
 * @Description :
 * TODO 自己定制insert时按照什么算法去分发到不同表中：分片键的类型Lone传入泛型，确保此算法在范围查找时使用是有效的
 * @Author : lixiunan
 * @Date : 2021/7/15
 **/
public class MyTablePreciseAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        //把雪花算法生成的id取出
        Long id = shardingValue.getValue();
        //对id取摩得到表名的数字
        BigInteger key =
                BigInteger.valueOf(id).mod(new BigInteger("2")).add(new BigInteger("1"));
        //生成真实表的表名
        String tableName = shardingValue.getLogicTableName() + "_" + key;
        if(availableTargetNames.contains(tableName)){
            return tableName;
        }else {
            throw new UnsupportedOperationException("找不到表名");
        }
    }
}
