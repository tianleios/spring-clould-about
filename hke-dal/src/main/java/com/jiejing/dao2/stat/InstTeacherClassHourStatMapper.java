package com.jiejing.dao2.stat;

import com.jiejing.model.InstTeacherClassHourStat;
import com.jiejing.model.InstTeacherClassHourStatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InstTeacherClassHourStatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    int countByExample(InstTeacherClassHourStatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    int deleteByExample(InstTeacherClassHourStatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    int insert(InstTeacherClassHourStat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    int insertSelective(InstTeacherClassHourStat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    List<InstTeacherClassHourStat> selectByExample(InstTeacherClassHourStatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    InstTeacherClassHourStat selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") InstTeacherClassHourStat record, @Param("example") InstTeacherClassHourStatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") InstTeacherClassHourStat record, @Param("example") InstTeacherClassHourStatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(InstTeacherClassHourStat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_stat
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(InstTeacherClassHourStat record);

    List<InstTeacherClassHourStat> selectByTeacherIdList(@Param("teacherIdList") List<Long> teacherIdList);


    void updateDeltaClassHour(@Param("instId") Long instId, @Param("month") Long month, @Param("deltaCheckedClassHour") Integer deltaCheckedClassHour, @Param("teacherIdList") List<Long> teacherIdList);
}