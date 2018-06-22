package com.jiejing.dao2.stat;

import com.jiejing.model.CrmInstAbutmentMonthly;
import com.jiejing.model.CrmInstAbutmentMonthlyExample;
import com.jiejing.model.CrmInstAbutmentMonthlyKey;
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

public interface CrmInstAbutmentMonthlyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @SelectProvider(type=CrmInstAbutmentMonthlySqlProvider.class, method="countByExample")
    int countByExample(CrmInstAbutmentMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @DeleteProvider(type=CrmInstAbutmentMonthlySqlProvider.class, method="deleteByExample")
    int deleteByExample(CrmInstAbutmentMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @Delete({
        "delete from crm_inst_abutment_monthly",
        "where sign_year = #{signYear,jdbcType=INTEGER}",
          "and sign_month = #{signMonth,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(CrmInstAbutmentMonthlyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @Insert({
        "insert into crm_inst_abutment_monthly (sign_year, sign_month, ",
        "count_sinst, signed_money, ",
        "cum_count_sinst, cum_signed_money)",
        "values (#{signYear,jdbcType=INTEGER}, #{signMonth,jdbcType=INTEGER}, ",
        "#{countSinst,jdbcType=INTEGER}, #{signedMoney,jdbcType=INTEGER}, ",
        "#{cumCountSinst,jdbcType=INTEGER}, #{cumSignedMoney,jdbcType=INTEGER})"
    })
    int insert(CrmInstAbutmentMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @InsertProvider(type=CrmInstAbutmentMonthlySqlProvider.class, method="insertSelective")
    int insertSelective(CrmInstAbutmentMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @SelectProvider(type=CrmInstAbutmentMonthlySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="sign_year", property="signYear", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sign_month", property="signMonth", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="count_sinst", property="countSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="signed_money", property="signedMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_count_sinst", property="cumCountSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_signed_money", property="cumSignedMoney", jdbcType=JdbcType.BIGINT)
    })
    List<CrmInstAbutmentMonthly> selectByExampleWithRowbounds(CrmInstAbutmentMonthlyExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @SelectProvider(type=CrmInstAbutmentMonthlySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="sign_year", property="signYear", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sign_month", property="signMonth", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="count_sinst", property="countSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="signed_money", property="signedMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_count_sinst", property="cumCountSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_signed_money", property="cumSignedMoney", jdbcType=JdbcType.INTEGER)
    })
    List<CrmInstAbutmentMonthly> selectByExample(CrmInstAbutmentMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @Select({
        "select",
        "sign_year, sign_month, count_sinst, signed_money, cum_count_sinst, cum_signed_money",
        "from crm_inst_abutment_monthly",
        "where sign_year = #{signYear,jdbcType=INTEGER}",
          "and sign_month = #{signMonth,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="sign_year", property="signYear", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sign_month", property="signMonth", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="count_sinst", property="countSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="signed_money", property="signedMoney", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_count_sinst", property="cumCountSinst", jdbcType=JdbcType.INTEGER),
        @Result(column="cum_signed_money", property="cumSignedMoney", jdbcType=JdbcType.INTEGER)
    })
    CrmInstAbutmentMonthly selectByPrimaryKey(CrmInstAbutmentMonthlyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @UpdateProvider(type=CrmInstAbutmentMonthlySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CrmInstAbutmentMonthly record, @Param("example") CrmInstAbutmentMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @UpdateProvider(type=CrmInstAbutmentMonthlySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CrmInstAbutmentMonthly record, @Param("example") CrmInstAbutmentMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @UpdateProvider(type=CrmInstAbutmentMonthlySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CrmInstAbutmentMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_inst_abutment_monthly
     *
     * @mbggenerated Wed Mar 29 16:49:18 CST 2017
     */
    @Update({
        "update crm_inst_abutment_monthly",
        "set count_sinst = #{countSinst,jdbcType=INTEGER},",
          "signed_money = #{signedMoney,jdbcType=INTEGER},",
          "cum_count_sinst = #{cumCountSinst,jdbcType=INTEGER},",
          "cum_signed_money = #{cumSignedMoney,jdbcType=INTEGER}",
        "where sign_year = #{signYear,jdbcType=INTEGER}",
          "and sign_month = #{signMonth,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CrmInstAbutmentMonthly record);
}