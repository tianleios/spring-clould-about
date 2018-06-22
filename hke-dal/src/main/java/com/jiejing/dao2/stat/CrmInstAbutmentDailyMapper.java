package com.jiejing.dao2.stat;

import com.jiejing.model.CrmInstAbutmentDaily;
import com.jiejing.model.CrmInstAbutmentDailyExample;
import java.util.Date;
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
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface CrmInstAbutmentDailyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @SelectProvider(type=CrmInstAbutmentDailySqlProvider.class, method="countByExample")
    int countByExample(CrmInstAbutmentDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @DeleteProvider(type=CrmInstAbutmentDailySqlProvider.class, method="deleteByExample")
    int deleteByExample(CrmInstAbutmentDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @Delete({
        "delete from crm_inst_abutment_daily",
        "where sign_date = #{signDate,jdbcType=DATE}"
    })
    int deleteByPrimaryKey(Date signDate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @Insert({
        "insert into crm_inst_abutment_daily (sign_date, count_sinst, ",
        "signed_money, cum_count_sinst, ",
        "cum_signed_money, cum_month_count_sinst, ",
        "cum_month_signed_money)",
        "values (#{signDate,jdbcType=DATE}, #{countSinst,jdbcType=INTEGER}, ",
        "#{signedMoney,jdbcType=INTEGER}, #{cumCountSinst,jdbcType=INTEGER}, ",
        "#{cumSignedMoney,jdbcType=INTEGER}, #{cumMonthCountSinst,jdbcType=INTEGER}, ",
        "#{cumMonthSignedMoney,jdbcType=INTEGER})"
    })
    int insert(CrmInstAbutmentDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @InsertProvider(type=CrmInstAbutmentDailySqlProvider.class, method="insertSelective")
    int insertSelective(CrmInstAbutmentDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @SelectProvider(type=CrmInstAbutmentDailySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="sign_date", property="signDate", jdbcType=JdbcType.DATE, id=true),
        @Result(column="count_sinst", property="countSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="signed_money", property="signedMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_count_sinst", property="cumCountSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_signed_money", property="cumSignedMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_month_count_sinst", property="cumMonthCountSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_month_signed_money", property="cumMonthSignedMoney", jdbcType=JdbcType.INTEGER)
    })
    List<CrmInstAbutmentDaily> selectByExampleWithRowbounds(CrmInstAbutmentDailyExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @SelectProvider(type=CrmInstAbutmentDailySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="sign_date", property="signDate", jdbcType=JdbcType.DATE, id=true),
        @Result(column="count_sinst", property="countSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="signed_money", property="signedMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_count_sinst", property="cumCountSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_signed_money", property="cumSignedMoney", jdbcType=JdbcType.BIGINT),
        @Result(column="cum_month_count_sinst", property="cumMonthCountSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_month_signed_money", property="cumMonthSignedMoney", jdbcType=JdbcType.INTEGER)
    })
    List<CrmInstAbutmentDaily> selectByExample(CrmInstAbutmentDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @Select({
        "select",
        "sign_date, count_sinst, signed_money, cum_count_sinst, cum_signed_money, cum_month_count_sinst, ",
        "cum_month_signed_money",
        "from crm_inst_abutment_daily",
        "where sign_date = #{signDate,jdbcType=DATE}"
    })
    @Results({
        @Result(column="sign_date", property="signDate", jdbcType=JdbcType.DATE, id=true),
        @Result(column="count_sinst", property="countSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="signed_money", property="signedMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_count_sinst", property="cumCountSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_signed_money", property="cumSignedMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_month_count_sinst", property="cumMonthCountSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_month_signed_money", property="cumMonthSignedMoney", jdbcType=JdbcType.INTEGER)
    })
    CrmInstAbutmentDaily selectByPrimaryKey(Date signDate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @UpdateProvider(type=CrmInstAbutmentDailySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CrmInstAbutmentDaily record, @Param("example") CrmInstAbutmentDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @UpdateProvider(type=CrmInstAbutmentDailySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CrmInstAbutmentDaily record, @Param("example") CrmInstAbutmentDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @UpdateProvider(type=CrmInstAbutmentDailySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CrmInstAbutmentDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_daily
     *
     * @mbggenerated Mon Apr 17 10:52:30 CST 2017
     */
    @Update({
        "update crm_inst_abutment_daily",
        "set count_sinst = #{countSinst,jdbcType=INTEGER},",
          "signed_money = #{signedMoney,jdbcType=INTEGER},",
          "cum_count_sinst = #{cumCountSinst,jdbcType=INTEGER},",
          "cum_signed_money = #{cumSignedMoney,jdbcType=INTEGER},",
          "cum_month_count_sinst = #{cumMonthCountSinst,jdbcType=INTEGER},",
          "cum_month_signed_money = #{cumMonthSignedMoney,jdbcType=INTEGER}",
        "where sign_date = #{signDate,jdbcType=DATE}"
    })
    int updateByPrimaryKey(CrmInstAbutmentDaily record);
}