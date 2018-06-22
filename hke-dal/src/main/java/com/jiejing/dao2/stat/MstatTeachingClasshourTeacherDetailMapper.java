package com.jiejing.dao2.stat;

import com.jiejing.model.MstatTeachingClasshourTeacherDetail;
import com.jiejing.model.MstatTeachingClasshourTeacherDetailExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MstatTeachingClasshourTeacherDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_teacher_detail
     *
     * @mbggenerated
     */
    int countByExample(MstatTeachingClasshourTeacherDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_teacher_detail
     *
     * @mbggenerated
     */
    int deleteByExample(MstatTeachingClasshourTeacherDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_teacher_detail
     *
     * @mbggenerated
     */
    int insert(MstatTeachingClasshourTeacherDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_teacher_detail
     *
     * @mbggenerated
     */
    int insertSelective(MstatTeachingClasshourTeacherDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_teacher_detail
     *
     * @mbggenerated
     */
    List<MstatTeachingClasshourTeacherDetail> selectByExample(MstatTeachingClasshourTeacherDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_teacher_detail
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MstatTeachingClasshourTeacherDetail record, @Param("example") MstatTeachingClasshourTeacherDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_teacher_detail
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MstatTeachingClasshourTeacherDetail record, @Param("example") MstatTeachingClasshourTeacherDetailExample example);

    List<Map> selectListByExampleGroupByCourse(@Param("monthStart") Long monthStart,
                                               @Param("monthEnd") Long monthEnd,
                                               @Param("instIds") List<Long> instIds,
                                               @Param("typeList") List<Long> typeList,
                                               @Param("offset") Integer offset,
                                               @Param("limit") Integer limit);

    Long sumClassHourByExample(@Param("monthStart") Long monthStart,
                               @Param("monthEnd") Long monthEnd,
                               @Param("instIds") List<Long> instIds,
                               @Param("typeList") List<Long> typeList);

    int countByExampleGroupByCourse(@Param("monthStart") Long monthStart,
                                    @Param("monthEnd") Long monthEnd,
                                    @Param("instIds") List<Long> instIds,
                                    @Param("typeList") List<Long> typeList);
}