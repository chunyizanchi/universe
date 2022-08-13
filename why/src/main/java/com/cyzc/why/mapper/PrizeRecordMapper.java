package com.cyzc.why.mapper;

import com.cyzc.why.entity.PrizeRecord;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


public interface PrizeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrizeRecord record);

    int insertSelective(PrizeRecord record);

    PrizeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrizeRecord record);

    int updateByPrimaryKey(PrizeRecord record);

    List<PrizeRecord> selectAll();
}