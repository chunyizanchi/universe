package com.cyzc.springboot.mapper;


import com.cyzc.springboot.entity.Prize;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PrizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Prize record);

    int insertSelective(Prize record);

    Prize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Prize record);

    int updateByPrimaryKey(Prize record);

    List<Prize> findAll();

    List<Prize> selectPrizeByActId(@Param("actId") Integer actId);

    Optional<List<Prize>> selectPrizeByActId2(@Param("actId") Integer actId);
}