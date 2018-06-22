package com.jiejing.dao2.stat;

import com.jiejing.model.StatInstTeacherOccupancyMonthly;
import com.jiejing.model.StatInstTeacherOccupancyMonthlyExample;
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

public interface StatInstTeacherOccupancyMonthlyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_inst_teacher_occupancy_monthly
     *
     * @mbggenerated Fri Apr 21 17:56:18 CST 2017
     */
    @SelectProvider(type=StatInstTeacherOccupancyMonthlySqlProvider.class, method="countByExample")
    int countByExample(StatInstTeacherOccupancyMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_inst_teacher_occupancy_monthly
     *
     * @mbggenerated Fri Apr 21 17:56:18 CST 2017
     */
    @DeleteProvider(type=StatInstTeacherOccupancyMonthlySqlProvider.class, method="deleteByExample")
    int deleteByExample(StatInstTeacherOccupancyMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_inst_teacher_occupancy_monthly
     *
     * @mbggenerated Fri Apr 21 17:56:18 CST 2017
     */
    @Insert({
        "insert into stat_inst_teacher_occupancy_monthly (class_count, snap_month, ",
        "teacher_id, teacher_name, ",
        "inst_id, inst_name, ",
        "class_capacity, student_count, ",
        "teacher_occupancy)",
        "values (#{classCount,jdbcType=BIGINT}, #{snapMonth,jdbcType=INTEGER}, ",
        "#{teacherId,jdbcType=BIGINT}, #{teacherName,jdbcType=VARCHAR}, ",
        "#{instId,jdbcType=BIGINT}, #{instName,jdbcType=VARCHAR}, ",
        "#{classCapacity,jdbcType=BIGINT}, #{studentCount,jdbcType=INTEGER}, ",
        "#{teacherOccupancy,jdbcType=DOUBLE})"
    })
    int insert(StatInstTeacherOccupancyMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_inst_teacher_occupancy_monthly
     *
     * @mbggenerated Fri Apr 21 17:56:18 CST 2017
     */
    @InsertProvider(type=StatInstTeacherOccupancyMonthlySqlProvider.class, method="insertSelective")
    int insertSelective(StatInstTeacherOccupancyMonthly record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_inst_teacher_occupancy_monthly
     *
     * @mbggenerated Fri Apr 21 17:56:18 CST 2017
     */
    @SelectProvider(type=StatInstTeacherOccupancyMonthlySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="class_count", property="classCount", jdbcType=JdbcType.BIGINT),
        @Result(column="snap_month", property="snapMonth", jdbcType=JdbcType.INTEGER),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.BIGINT),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="inst_id", property="instId", jdbcType=JdbcType.BIGINT),
        @Result(column="inst_name", property="instName", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_capacity", property="classCapacity", jdbcType=JdbcType.BIGINT),
        @Result(column="student_count", property="studentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="teacher_occupancy", property="teacherOccupancy", jdbcType=JdbcType.DOUBLE)
    })
    List<StatInstTeacherOccupancyMonthly> selectByExample(StatInstTeacherOccupancyMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_inst_teacher_occupancy_monthly
     *
     * @mbggenerated Fri Apr 21 17:56:18 CST 2017
     */
    @UpdateProvider(type=StatInstTeacherOccupancyMonthlySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StatInstTeacherOccupancyMonthly record, @Param("example") StatInstTeacherOccupancyMonthlyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stat_inst_teacher_occupancy_monthly
     *
     * @mbggenerated Fri Apr 21 17:56:18 CST 2017
     */
    @UpdateProvider(type=StatInstTeacherOccupancyMonthlySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StatInstTeacherOccupancyMonthly record, @Param("example") StatInstTeacherOccupancyMonthlyExample example);
}