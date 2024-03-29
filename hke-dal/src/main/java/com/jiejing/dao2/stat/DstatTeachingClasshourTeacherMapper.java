package com.jiejing.dao2.stat;

import com.jiejing.model.DstatTeachingClasshourTeacher;
import com.jiejing.model.DstatTeachingClasshourTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DstatTeachingClasshourTeacherMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_teacher
     *
     * @mbggenerated
     */
    int countByExample(DstatTeachingClasshourTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_teacher
     *
     * @mbggenerated
     */
    int deleteByExample(DstatTeachingClasshourTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_teacher
     *
     * @mbggenerated
     */
    int insert(DstatTeachingClasshourTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_teacher
     *
     * @mbggenerated
     */
    int insertSelective(DstatTeachingClasshourTeacher record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_teacher
     *
     * @mbggenerated
     */
    List<DstatTeachingClasshourTeacher> selectByExample(DstatTeachingClasshourTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_teacher
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DstatTeachingClasshourTeacher record, @Param("example") DstatTeachingClasshourTeacherExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dstat_teaching_classhour_teacher
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DstatTeachingClasshourTeacher record, @Param("example") DstatTeachingClasshourTeacherExample example);

    void batchInsert(@Param("items") List<DstatTeachingClasshourTeacher> items);
}