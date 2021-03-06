package com.jiejing.dao2.stat;

import com.jiejing.model.DstatTeachingClasshourInstDetail;
import com.jiejing.model.DstatTeachingClasshourInstDetailExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DstatTeachingClasshourInstDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int countByExample(DstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int deleteByExample(DstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int insert(DstatTeachingClasshourInstDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int insertSelective(DstatTeachingClasshourInstDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    List<DstatTeachingClasshourInstDetail> selectByExample(DstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    DstatTeachingClasshourInstDetail selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DstatTeachingClasshourInstDetail record, @Param("example") DstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DstatTeachingClasshourInstDetail record, @Param("example") DstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(DstatTeachingClasshourInstDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(DstatTeachingClasshourInstDetail record);

    List<Map> selectCostListByExampleGroupByCourse(@Param("beginDate") Date beginDate,
                                                   @Param("endDate") Date endDate,
                                                   @Param("instIds") List<Long> instIds,
                                                   @Param("typeList") List<Long> typeList,
                                                   @Param("offset") Integer offset,
                                                   @Param("limit") Integer limit);

    Long sumPriceByExample(@Param("beginDate") Date beginDate,
                               @Param("endDate") Date endDate,
                               @Param("instIds") List<Long> instIds,
                               @Param("typeList") List<Long> typeList);

    int countByExampleGroupByCourse(@Param("beginDate") Date beginDate,
                                    @Param("endDate") Date endDate,
                                    @Param("instIds") List<Long> instIds,
                                    @Param("typeList") List<Long> typeList);
}