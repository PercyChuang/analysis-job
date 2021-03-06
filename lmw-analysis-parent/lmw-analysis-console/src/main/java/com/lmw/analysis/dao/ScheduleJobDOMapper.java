package com.lmw.analysis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.lmw.analysis.model.ScheduleJobDO;
import com.lmw.analysis.model.ScheduleJobDOCriteria;
@Repository
public interface ScheduleJobDOMapper extends BaseMapper {
    int countByExample(ScheduleJobDOCriteria example);

    int deleteByExample(ScheduleJobDOCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(ScheduleJobDO record);

    int insertSelective(ScheduleJobDO record);

    List<ScheduleJobDO> selectByExampleWithRowbounds(ScheduleJobDOCriteria example, RowBounds rowBounds);

    List<ScheduleJobDO> selectByExample(ScheduleJobDOCriteria example);

    ScheduleJobDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ScheduleJobDO record, @Param("example") ScheduleJobDOCriteria example);

    int updateByExample(@Param("record") ScheduleJobDO record, @Param("example") ScheduleJobDOCriteria example);

    int updateByPrimaryKeySelective(ScheduleJobDO record);

    int updateByPrimaryKey(ScheduleJobDO record);

    int updateByScheduleId(ScheduleJobDO record);

    int updateStateByPrimaryKey(ScheduleJobDO record);
}