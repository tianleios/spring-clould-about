package com.jiejing.dao2.stat;

import com.jiejing.model.InstClassHourCourseTeacherMonthlyExample;
import com.jiejing.vo.ClassHourVO;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface InstClassHourCourseTeacherMonthlyExtMapper {

    @SelectProvider(type = InstClassHourCourseTeacherMonthlyExtSqlProvider.class, method = "sumClassHourByExample")
    Long sumClassHourByExample(InstClassHourCourseTeacherMonthlyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherMonthlyExtSqlProvider.class, method = "sumPriceByExample")
    Long sumPriceByExample(InstClassHourCourseTeacherMonthlyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherMonthlyExtSqlProvider.class, method = "selectListByExampleGroupByCourse")
    List<ClassHourVO> selectListByExampleGroupByCourse(InstClassHourCourseTeacherMonthlyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherMonthlyExtSqlProvider.class, method = "selectListByExampleGroupByTeacher")
    List<ClassHourVO> selectListByExampleGroupByTeacher(InstClassHourCourseTeacherMonthlyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherMonthlyExtSqlProvider.class, method = "selectCostListByExampleGroupByCourse")
    List<ClassHourVO> selectCostListByExampleGroupByCourse(InstClassHourCourseTeacherMonthlyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherMonthlyExtSqlProvider.class, method = "selectCostListByExampleGroupByTeacher")
    List<ClassHourVO> selectCostListByExampleGroupByTeacher(InstClassHourCourseTeacherMonthlyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherMonthlyExtSqlProvider.class, method = "countByExampleGroupByCourse")
    Integer countByExampleGroupByCourse(InstClassHourCourseTeacherMonthlyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherMonthlyExtSqlProvider.class, method = "countByExampleGroupByTeacher")
    Integer countByExampleGroupByTeacher(InstClassHourCourseTeacherMonthlyExample example);
}