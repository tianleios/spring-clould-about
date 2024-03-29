package com.jiejing.dao2.stat;

import com.jiejing.model.InstTeacherClassHourCourseDaily;
import com.jiejing.model.InstTeacherClassHourCourseDailyExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface InstTeacherClassHourCourseDailyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_course_daily
     *
     * @mbggenerated Fri May 05 17:16:29 CST 2017
     */
    @SelectProvider(type=InstTeacherClassHourCourseDailySqlProvider.class, method="countByExample")
    int countByExample(InstTeacherClassHourCourseDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_course_daily
     *
     * @mbggenerated Fri May 05 17:16:29 CST 2017
     */
    @DeleteProvider(type=InstTeacherClassHourCourseDailySqlProvider.class, method="deleteByExample")
    int deleteByExample(InstTeacherClassHourCourseDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_course_daily
     *
     * @mbggenerated Fri May 05 17:16:29 CST 2017
     */
    @Insert({
        "insert into inst_teacher_class_hour_course_daily (inst_id, course_id, ",
        "teacher_id, class_hour, ",
        "type, day)",
        "values (#{instId,jdbcType=BIGINT}, #{courseId,jdbcType=BIGINT}, ",
        "#{teacherId,jdbcType=BIGINT}, #{classHour,jdbcType=BIGINT}, ",
        "#{type,jdbcType=BIGINT}, #{day,jdbcType=DATE})"
    })
    int insert(InstTeacherClassHourCourseDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_course_daily
     *
     * @mbggenerated Fri May 05 17:16:29 CST 2017
     */
    @InsertProvider(type=InstTeacherClassHourCourseDailySqlProvider.class, method="insertSelective")
    int insertSelective(InstTeacherClassHourCourseDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_course_daily
     *
     * @mbggenerated Fri May 05 17:16:29 CST 2017
     */
    @SelectProvider(type=InstTeacherClassHourCourseDailySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="inst_id", property="instId", jdbcType=JdbcType.BIGINT),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.BIGINT),
        @Result(column="class_hour", property="classHour", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.BIGINT),
        @Result(column="day", property="day", jdbcType=JdbcType.DATE)
    })
    List<InstTeacherClassHourCourseDaily> selectByExample(InstTeacherClassHourCourseDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_course_daily
     *
     * @mbggenerated Fri May 05 17:16:29 CST 2017
     */
    @UpdateProvider(type=InstTeacherClassHourCourseDailySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InstTeacherClassHourCourseDaily record, @Param("example") InstTeacherClassHourCourseDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_teacher_class_hour_course_daily
     *
     * @mbggenerated Fri May 05 17:16:29 CST 2017
     */
    @UpdateProvider(type=InstTeacherClassHourCourseDailySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InstTeacherClassHourCourseDaily record, @Param("example") InstTeacherClassHourCourseDailyExample example);
}