package com.jiejing.dao2.stat;

import com.jiejing.model.MstatTeachingClasshourInst;
import com.jiejing.model.MstatTeachingClasshourInstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MstatTeachingClasshourInstMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    int countByExample(MstatTeachingClasshourInstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    int deleteByExample(MstatTeachingClasshourInstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    int insert(MstatTeachingClasshourInst record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    int insertSelective(MstatTeachingClasshourInst record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    List<MstatTeachingClasshourInst> selectByExample(MstatTeachingClasshourInstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    MstatTeachingClasshourInst selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MstatTeachingClasshourInst record, @Param("example") MstatTeachingClasshourInstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MstatTeachingClasshourInst record, @Param("example") MstatTeachingClasshourInstExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MstatTeachingClasshourInst record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mstat_teaching_classhour_inst
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MstatTeachingClasshourInst record);

    void batchInsert(@Param("items") List<MstatTeachingClasshourInst> items);
}