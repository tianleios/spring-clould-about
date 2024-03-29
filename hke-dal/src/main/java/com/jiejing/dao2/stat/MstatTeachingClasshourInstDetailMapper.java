package com.jiejing.dao2.stat;

import com.jiejing.model.MstatTeachingClasshourInstDetail;
import com.jiejing.model.MstatTeachingClasshourInstDetailExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MstatTeachingClasshourInstDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int countByExample(MstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int deleteByExample(MstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int insert(MstatTeachingClasshourInstDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int insertSelective(MstatTeachingClasshourInstDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    List<MstatTeachingClasshourInstDetail> selectByExample(MstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    MstatTeachingClasshourInstDetail selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MstatTeachingClasshourInstDetail record, @Param("example") MstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MstatTeachingClasshourInstDetail record, @Param("example") MstatTeachingClasshourInstDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MstatTeachingClasshourInstDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MstatTeachingClasshourInstDetail record);

    List<Map> selectCostListByExampleGroupByCourse(@Param("monthStart") Long monthStart,
                                               @Param("monthEnd") Long monthEnd,
                                               @Param("instIds") List<Long> instIds,
                                               @Param("typeList") List<Long> typeList,
                                               @Param("offset") Integer offset,
                                               @Param("limit") Integer limit);

    Long sumPriceByExample(@Param("monthStart") Long monthStart,
                               @Param("monthEnd") Long monthEnd,
                               @Param("instIds") List<Long> instIds,
                               @Param("typeList") List<Long> typeList);

    int countByExampleGroupByCourse(@Param("monthStart") Long monthStart,
                                    @Param("monthEnd") Long monthEnd,
                                    @Param("instIds") List<Long> instIds,
                                    @Param("typeList") List<Long> typeList);


}