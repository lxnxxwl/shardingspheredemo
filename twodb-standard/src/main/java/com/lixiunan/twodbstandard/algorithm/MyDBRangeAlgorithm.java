package com.lixiunan.twodbstandard.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description : TODO
 * @Author : lixiunan
 * @Date : 2021/7/15
 **/
public class MyDBRangeAlgorithm implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(
            Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        //范围查询库
        return Arrays.asList("db1","db2");
    }
}
