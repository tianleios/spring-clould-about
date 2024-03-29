package com.jiejing.dao2.stat;

import com.jiejing.model.InstContractCourseMonthly;
import com.jiejing.model.InstContractCourseMonthlyExample;
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

public interface InstContractCourseMonthlyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_contract_course_monthly
     *
     * @mbggenerated Thu Apr 20 18:02:28 CST 2017
     */
    @SelectProvider(type=InstContractCourseMonthlySqlProvider.class, method="countByExample")
    int countByExample(InstContractCourseMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_contract_course_monthly
     *
     * @mbggenerated Thu Apr 20 18:02:28 CST 2017
     */
    @DeleteProvider(type=InstContractCourseMonthlySqlProvider.class, method="deleteByExample")
    int deleteByExample(InstContractCourseMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_contract_course_monthly
     *
     * @mbggenerated Thu Apr 20 18:02:28 CST 2017
     */
    @Insert({
        "insert into inst_contract_course_monthly (inst_id, inst_name, ",
        "year, month, yearmonth, ",
        "course_id, course_name, ",
        "count_new, count_cont, ",
        "profit_new, profit_cont, ",
        "renew_rate)",
        "values (#{instId,jdbcType=BIGINT}, #{instName,jdbcType=VARCHAR}, ",
        "#{year,jdbcType=INTEGER}, #{month,jdbcType=INTEGER}, #{yearmonth,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=BIGINT}, #{courseName,jdbcType=VARCHAR}, ",
        "#{countNew,jdbcType=INTEGER}, #{countCont,jdbcType=INTEGER}, ",
        "#{profitNew,jdbcType=INTEGER}, #{profitCont,jdbcType=INTEGER}, ",
        "#{renewRate,jdbcType=DOUBLE})"
    })
    int insert(InstContractCourseMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_contract_course_monthly
     *
     * @mbggenerated Thu Apr 20 18:02:28 CST 2017
     */
    @InsertProvider(type=InstContractCourseMonthlySqlProvider.class, method="insertSelective")
    int insertSelective(InstContractCourseMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_contract_course_monthly
     *
     * @mbggenerated Thu Apr 20 18:02:28 CST 2017
     */
    @SelectProvider(type=InstContractCourseMonthlySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="inst_id", property="instId", jdbcType=JdbcType.BIGINT),
        @Result(column="inst_name", property="instName", jdbcType=JdbcType.VARCHAR),
        @Result(column="year", property="year", jdbcType=JdbcType.INTEGER),
        @Result(column="month", property="month", jdbcType=JdbcType.INTEGER),
        @Result(column="yearmonth", property="yearmonth", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.BIGINT),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="count_new", property="countNew", jdbcType=JdbcType.INTEGER),
        @Result(column="count_cont", property="countCont", jdbcType=JdbcType.INTEGER),
        @Result(column="profit_new", property="profitNew", jdbcType=JdbcType.INTEGER),
        @Result(column="profit_cont", property="profitCont", jdbcType=JdbcType.INTEGER),
        @Result(column="renew_rate", property="renewRate", jdbcType=JdbcType.DOUBLE)
    })
    List<InstContractCourseMonthly> selectByExample(InstContractCourseMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_contract_course_monthly
     *
     * @mbggenerated Thu Apr 20 18:02:28 CST 2017
     */
    @UpdateProvider(type=InstContractCourseMonthlySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InstContractCourseMonthly record, @Param("example") InstContractCourseMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_contract_course_monthly
     *
     * @mbggenerated Thu Apr 20 18:02:28 CST 2017
     */
    @UpdateProvider(type=InstContractCourseMonthlySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InstContractCourseMonthly record, @Param("example") InstContractCourseMonthlyExample example);
}