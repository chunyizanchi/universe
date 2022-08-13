package com.cyzc.why.mapper;

import com.cyzc.why.entity.TpExternalActSource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TpExternalActSourceMapper {
    /**
     * delete by primary key
     * @param externalActSourceId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String externalActSourceId);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(TpExternalActSource record);

    /**
     * select by primary key
     * @param externalActSourceId primary key
     * @return object by primary key
     */
    TpExternalActSource selectByPrimaryKey(String externalActSourceId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TpExternalActSource record);
}