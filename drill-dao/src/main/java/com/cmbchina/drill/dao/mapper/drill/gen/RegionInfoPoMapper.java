package com.cmbchina.drill.dao.mapper.drill.gen;

import com.cmbchina.drill.dao.po.drill.RegionInfoPo;
import com.cmbchina.drill.dao.po.drill.RegionInfoPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionInfoPoMapper {
    int countByExample(RegionInfoPoExample example);

    int deleteByExample(RegionInfoPoExample example);

    int deleteByPrimaryKey(String id);

    int insert(RegionInfoPo record);

    int insertSelective(RegionInfoPo record);

    List<RegionInfoPo> selectByExample(RegionInfoPoExample example);

    RegionInfoPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RegionInfoPo record, @Param("example") RegionInfoPoExample example);

    int updateByExample(@Param("record") RegionInfoPo record, @Param("example") RegionInfoPoExample example);

    int updateByPrimaryKeySelective(RegionInfoPo record);

    int updateByPrimaryKey(RegionInfoPo record);

    RegionInfoPo lockByPrimaryKey(@Param("id") String id);

    List<RegionInfoPo> lockByExample(RegionInfoPoExample example);

    void insertBatch(@Param("recordList") List<RegionInfoPo> recordList);
}