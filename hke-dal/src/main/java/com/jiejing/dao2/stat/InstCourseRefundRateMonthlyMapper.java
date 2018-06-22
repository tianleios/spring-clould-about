package com.jiejing.dao2.stat;

import com.jiejing.model.InstCourseRefundRateMonthly;
import com.jiejing.model.InstCourseRefundRateMonthlyExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface InstCourseRefundRateMonthlyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_course_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:57 CST 2017
     */
    @SelectProvider(type=InstCourseRefundRateMonthlySqlProvider.class, method="countByExample")
    int countByExample(InstCourseRefundRateMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_course_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:57 CST 2017
     */
    @DeleteProvider(type=InstCourseRefundRateMonthlySqlProvider.class, method="deleteByExample")
    int deleteByExample(InstCourseRefundRateMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_course_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:57 CST 2017
     */
    @Insert({
        "insert into inst_course_refund_rate_monthly (month, inst_id, ",
        "inst_name, course_id, ",
        "course_name, student_count, ",
        "refund_student_count, refund_rate)",
        "values (#{month,jdbcType=INTEGER}, #{instId,jdbcType=BIGINT}, ",
        "#{instName,jdbcType=VARCHAR}, #{courseId,jdbcType=BIGINT}, ",
        "#{courseName,jdbcType=VARCHAR}, #{studentCount,jdbcType=INTEGER}, ",
        "#{refundStudentCount,jdbcType=INTEGER}, #{refundRate,jdbcType=DOUBLE})"
    })
    int insert(InstCourseRefundRateMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_course_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:57 CST 2017
     */
    @InsertProvider(type=InstCourseRefundRateMonthlySqlProvider.class, method="insertSelective")
    int insertSelective(InstCourseRefundRateMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_course_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:57 CST 2017
     */
    @SelectProvider(type=InstCourseRefundRateMonthlySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="month", property="month", jdbcType=JdbcType.INTEGER),
        @Result(column="inst_id", property="instId", jdbcType=JdbcType.BIGINT),
        @Result(column="inst_name", property="instName", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_count", property="studentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_student_count", property="refundStudentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_rate", property="refundRate", jdbcType=JdbcType.DOUBLE)
    })
    List<InstCourseRefundRateMonthly> selectByExample(InstCourseRefundRateMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_course_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:57 CST 2017
     */
    @UpdateProvider(type=InstCourseRefundRateMonthlySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InstCourseRefundRateMonthly record, @Param("example") InstCourseRefundRateMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_course_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:57 CST 2017
     */
    @UpdateProvider(type=InstCourseRefundRateMonthlySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InstCourseRefundRateMonthly record, @Param("example") InstCourseRefundRateMonthlyExample example);
}