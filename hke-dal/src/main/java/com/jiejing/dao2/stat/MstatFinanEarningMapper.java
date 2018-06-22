package com.jiejing.dao2.stat;

import com.jiejing.model.MstatFinanEarning;
import com.jiejing.model.MstatFinanEarningExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MstatFinanEarningMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_finan_earning
     *
     * @mbggenerated
     */
    int countByExample(MstatFinanEarningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_finan_earning
     *
     * @mbggenerated
     */
    int deleteByExample(MstatFinanEarningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_finan_earning
     *
     * @mbggenerated
     */
    int insert(MstatFinanEarning record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_finan_earning
     *
     * @mbggenerated
     */
    int insertSelective(MstatFinanEarning record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_finan_earning
     *
     * @mbggenerated
     */
    List<MstatFinanEarning> selectByExample(MstatFinanEarningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_finan_earning
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MstatFinanEarning record, @Param("example") MstatFinanEarningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_finan_earning
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MstatFinanEarning record, @Param("example") MstatFinanEarningExample example);

    void batchInsert(@Param("items") List<MstatFinanEarning> items);

}