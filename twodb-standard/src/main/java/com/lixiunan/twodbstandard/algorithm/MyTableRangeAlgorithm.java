package com.lixiunan.twodbstandard.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description : TODO 定制范围查找时分表查找策略
 * @Author : lixiunan
 * @Date : 2021/7/15
 **/
public class MyTableRangeAlgorithm implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(
            Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        String logicTableName = shardingValue.getLogicTableName();
        //范围查询表
        return Arrays.asList(logicTableName+"_1",logicTableName+"_2");
    }
}
