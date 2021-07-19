package com.lixiunan.twodbstandard.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @Description : TODO 自己实现分库策略
 * @Author : lixiunan
 * @Date : 2021/7/15
 **/
public class MyDBPreciseAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        //把雪花算法生成的id取出
        Long id = shardingValue.getValue();
        //对id取摩得到的数字
        BigInteger key =
                BigInteger.valueOf(id).mod(new BigInteger("2")).add(new BigInteger("1"));
        //生成真实表的表名
        String dbName = "db" + key;
        if(availableTargetNames.contains(dbName)){
            return dbName;
        }
        throw new UnsupportedOperationException("找不到数据库");
    }
}
