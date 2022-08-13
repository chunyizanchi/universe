package com.cyzc.why.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyzc.why.entity.PointsLuckDrawRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointsLuckDrawRecordMapper extends BaseMapper<PointsLuckDrawRecord> {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(PointsLuckDrawRecord record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    PointsLuckDrawRecord selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(PointsLuckDrawRecord record);
}