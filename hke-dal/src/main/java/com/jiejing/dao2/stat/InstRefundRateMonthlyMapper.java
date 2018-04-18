package com.jiejing.dao2.stat;

import com.jiejing.model.InstRefundRateMonthly;
import com.jiejing.model.InstRefundRateMonthlyExample;
import com.jiejing.model.InstRefundRateMonthlyKey;
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

public interface InstRefundRateMonthlyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @SelectProvider(type=InstRefundRateMonthlySqlProvider.class, method="countByExample")
    int countByExample(InstRefundRateMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @DeleteProvider(type=InstRefundRateMonthlySqlProvider.class, method="deleteByExample")
    int deleteByExample(InstRefundRateMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @Delete({
        "delete from inst_refund_rate_monthly",
        "where inst_id = #{instId,jdbcType=BIGINT}",
          "and month = #{month,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(InstRefundRateMonthlyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @Insert({
        "insert into inst_refund_rate_monthly (inst_id, month, ",
        "inst_name, student_count, ",
        "refund_student_count, refund_rate)",
        "values (#{instId,jdbcType=BIGINT}, #{month,jdbcType=INTEGER}, ",
        "#{instName,jdbcType=VARCHAR}, #{studentCount,jdbcType=INTEGER}, ",
        "#{refundStudentCount,jdbcType=INTEGER}, #{refundRate,jdbcType=DOUBLE})"
    })
    int insert(InstRefundRateMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @InsertProvider(type=InstRefundRateMonthlySqlProvider.class, method="insertSelective")
    int insertSelective(InstRefundRateMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @SelectProvider(type=InstRefundRateMonthlySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="inst_id", property="instId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="month", property="month", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="inst_name", property="instName", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_count", property="studentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_student_count", property="refundStudentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_rate", property="refundRate", jdbcType=JdbcType.DOUBLE)
    })
    List<InstRefundRateMonthly> selectByExample(InstRefundRateMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @Select({
        "select",
        "inst_id, month, inst_name, student_count, refund_student_count, refund_rate",
        "from inst_refund_rate_monthly",
        "where inst_id = #{instId,jdbcType=BIGINT}",
          "and month = #{month,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="inst_id", property="instId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="month", property="month", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="inst_name", property="instName", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_count", property="studentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_student_count", property="refundStudentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="refund_rate", property="refundRate", jdbcType=JdbcType.DOUBLE)
    })
    InstRefundRateMonthly selectByPrimaryKey(InstRefundRateMonthlyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @UpdateProvider(type=InstRefundRateMonthlySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") InstRefundRateMonthly record, @Param("example") InstRefundRateMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @UpdateProvider(type=InstRefundRateMonthlySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") InstRefundRateMonthly record, @Param("example") InstRefundRateMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @UpdateProvider(type=InstRefundRateMonthlySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(InstRefundRateMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_refund_rate_monthly
     *
     * @mbggenerated Thu Apr 20 15:14:32 CST 2017
     */
    @Update({
        "update inst_refund_rate_monthly",
        "set inst_name = #{instName,jdbcType=VARCHAR},",
          "student_count = #{studentCount,jdbcType=INTEGER},",
          "refund_student_count = #{refundStudentCount,jdbcType=INTEGER},",
          "refund_rate = #{refundRate,jdbcType=DOUBLE}",
        "where inst_id = #{instId,jdbcType=BIGINT}",
          "and month = #{month,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(InstRefundRateMonthly record);
}