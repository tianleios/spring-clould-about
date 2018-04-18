package com.jiejing.dao2.stat;

import com.jiejing.model.InstStudentReferralRateCourseMonthly;
import com.jiejing.model.InstStudentReferralRateCourseMonthlyExample;
import com.jiejing.model.InstStudentReferralRateCourseMonthlyKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface InstStudentReferralRateCourseMonthlyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @SelectProvider(type=InstStudentReferralRateCourseMonthlySqlProvider.class, method="countByExample")
    int countByExample(InstStudentReferralRateCourseMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @DeleteProvider(type=InstStudentReferralRateCourseMonthlySqlProvider.class, method="deleteByExample")
    int deleteByExample(InstStudentReferralRateCourseMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @Delete({
        "delete from inst_student_referral_rate_course_monthly",
        "where inst_id = #{instId,jdbcType=BIGINT}",
          "and month = #{month,jdbcType=INTEGER}",
          "and course_id = #{courseId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(InstStudentReferralRateCourseMonthlyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @Insert({
        "insert into inst_student_referral_rate_course_monthly (inst_id, month, ",
        "course_id, referral_count, ",
        "new_count, referral_rate, ",
        "student_id, course_name)",
        "values (#{instId,jdbcType=BIGINT}, #{month,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=BIGINT}, #{referralCount,jdbcType=INTEGER}, ",
        "#{newCount,jdbcType=INTEGER}, #{referralRate,jdbcType=DOUBLE}, ",
        "#{studentId,jdbcType=BIGINT}, #{courseName,jdbcType=VARCHAR})"
    })
    int insert(InstStudentReferralRateCourseMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @InsertProvider(type=InstStudentReferralRateCourseMonthlySqlProvider.class, method="insertSelective")
    int insertSelective(InstStudentReferralRateCourseMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @SelectProvider(type=InstStudentReferralRateCourseMonthlySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="inst_id", property="instId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="month", property="month", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="referral_count", property="referralCount", jdbcType=JdbcType.INTEGER),
        @Result(column="new_count", property="newCount", jdbcType=JdbcType.INTEGER),
        @Result(column="referral_rate", property="referralRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.BIGINT),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR)
    })
    List<InstStudentReferralRateCourseMonthly> selectByExample(InstStudentReferralRateCourseMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @Select({
        "select",
        "inst_id, month, course_id, referral_count, new_count, referral_rate, student_id, ",
        "course_name",
        "from inst_student_referral_rate_course_monthly",
        "where inst_id = #{instId,jdbcType=BIGINT}",
          "and month = #{month,jdbcType=INTEGER}",
          "and course_id = #{courseId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="inst_id", property="instId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="month", property="month", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="referral_count", property="referralCount", jdbcType=JdbcType.INTEGER),
        @Result(column="new_count", property="newCount", jdbcType=JdbcType.INTEGER),
        @Result(column="referral_rate", property="referralRate", jdbcType=JdbcType.DOUBLE),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.BIGINT),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR)
    })
    InstStudentReferralRateCourseMonthly selectByPrimaryKey(InstStudentReferralRateCourseMonthlyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @UpdateProvider(type=InstStudentReferralRateCourseMonthlySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InstStudentReferralRateCourseMonthly record, @Param("example") InstStudentReferralRateCourseMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @UpdateProvider(type=InstStudentReferralRateCourseMonthlySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InstStudentReferralRateCourseMonthly record, @Param("example") InstStudentReferralRateCourseMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @UpdateProvider(type=InstStudentReferralRateCourseMonthlySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(InstStudentReferralRateCourseMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_student_referral_rate_course_monthly
     *
     * @mbggenerated Sat Apr 22 15:24:05 CST 2017
     */
    @Update({
        "update inst_student_referral_rate_course_monthly",
        "set referral_count = #{referralCount,jdbcType=INTEGER},",
          "new_count = #{newCount,jdbcType=INTEGER},",
          "referral_rate = #{referralRate,jdbcType=DOUBLE},",
          "student_id = #{studentId,jdbcType=BIGINT},",
          "course_name = #{courseName,jdbcType=VARCHAR}",
        "where inst_id = #{instId,jdbcType=BIGINT}",
          "and month = #{month,jdbcType=INTEGER}",
          "and course_id = #{courseId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(InstStudentReferralRateCourseMonthly record);
}