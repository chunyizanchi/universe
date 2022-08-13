package com.cyzc.springboot.mapper;


import com.cyzc.springboot.entity.PrizeRecord;
import java.util.List;

public interface PrizeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrizeRecord record);

    int insertSelective(PrizeRecord record);

    PrizeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrizeRecord record);

    int updateByPrimaryKey(PrizeRecord record);

    List<PrizeRecord> selectAll();
}