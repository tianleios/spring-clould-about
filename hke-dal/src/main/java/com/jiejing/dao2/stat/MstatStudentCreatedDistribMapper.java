package com.jiejing.dao2.stat;

import com.jiejing.model.MstatStudentCreatedDistrib;
import com.jiejing.model.MstatStudentCreatedDistribExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MstatStudentCreatedDistribMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_student_created_distrib
     *
     * @mbggenerated
     */
    int countByExample(MstatStudentCreatedDistribExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_student_created_distrib
     *
     * @mbggenerated
     */
    int deleteByExample(MstatStudentCreatedDistribExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_student_created_distrib
     *
     * @mbggenerated
     */
    int insert(MstatStudentCreatedDistrib record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_student_created_distrib
     *
     * @mbggenerated
     */
    int insertSelective(MstatStudentCreatedDistrib record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_student_created_distrib
     *
     * @mbggenerated
     */
    List<MstatStudentCreatedDistrib> selectByExample(MstatStudentCreatedDistribExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_student_created_distrib
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MstatStudentCreatedDistrib record, @Param("example") MstatStudentCreatedDistribExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_student_created_distrib
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MstatStudentCreatedDistrib record, @Param("example") MstatStudentCreatedDistribExample example);
}