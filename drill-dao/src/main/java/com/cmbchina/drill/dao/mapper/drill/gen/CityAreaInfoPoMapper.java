package com.cmbchina.drill.dao.mapper.drill.gen;

import com.cmbchina.drill.dao.po.drill.CityAreaInfoPo;
import com.cmbchina.drill.dao.po.drill.CityAreaInfoPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityAreaInfoPoMapper {
    int countByExample(CityAreaInfoPoExample example);

    int deleteByExample(CityAreaInfoPoExample example);

    int deleteByPrimaryKey(String id);

    int insert(CityAreaInfoPo record);

    int insertSelective(CityAreaInfoPo record);

    List<CityAreaInfoPo> selectByExample(CityAreaInfoPoExample example);

    CityAreaInfoPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CityAreaInfoPo record, @Param("example") CityAreaInfoPoExample example);

    int updateByExample(@Param("record") CityAreaInfoPo record, @Param("example") CityAreaInfoPoExample example);

    int updateByPrimaryKeySelective(CityAreaInfoPo record);

    int updateByPrimaryKey(CityAreaInfoPo record);

    CityAreaInfoPo lockByPrimaryKey(@Param("id") String id);

    List<CityAreaInfoPo> lockByExample(CityAreaInfoPoExample example);

    void insertBatch(@Param("recordList") List<CityAreaInfoPo> recordList);
}