package com.jiejing.dao2.stat;

import com.jiejing.model.StatStudentFunnel;
import com.jiejing.model.StatStudentFunnelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatStudentFunnelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    int countByExample(StatStudentFunnelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    int deleteByExample(StatStudentFunnelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long instId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    int insert(StatStudentFunnel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    int insertSelective(StatStudentFunnel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    List<StatStudentFunnel> selectByExample(StatStudentFunnelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    StatStudentFunnel selectByPrimaryKey(Long instId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") StatStudentFunnel record, @Param("example") StatStudentFunnelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") StatStudentFunnel record, @Param("example") StatStudentFunnelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(StatStudentFunnel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_student_funnel
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(StatStudentFunnel record);
}