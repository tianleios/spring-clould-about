package com.jiejing.dao2.stat;

import com.jiejing.model.InstClassHourCourseTeacherDailyExample;
import com.jiejing.vo.ClassHourVO;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface InstClassHourCourseTeacherDailyExtMapper {

    @SelectProvider(type = InstClassHourCourseTeacherDailyExtSqlProvider.class, method = "sumClassHourByExample")
    Long sumClassHourByExample(InstClassHourCourseTeacherDailyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherDailyExtSqlProvider.class, method = "sumPriceByExample")
    Long sumPriceByExample(InstClassHourCourseTeacherDailyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherDailyExtSqlProvider.class, method = "selectListByExampleGroupByCourse")
    List<ClassHourVO> selectListByExampleGroupByCourse(InstClassHourCourseTeacherDailyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherDailyExtSqlProvider.class, method = "selectListByExampleGroupByTeacher")
    List<ClassHourVO> selectListByExampleGroupByTeacher(InstClassHourCourseTeacherDailyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherDailyExtSqlProvider.class, method = "selectCostListByExampleGroupByCourse")
    List<ClassHourVO> selectCostListByExampleGroupByCourse(InstClassHourCourseTeacherDailyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherDailyExtSqlProvider.class, method = "selectCostListByExampleGroupByTeacher")
    List<ClassHourVO> selectCostListByExampleGroupByTeacher(InstClassHourCourseTeacherDailyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherDailyExtSqlProvider.class, method = "countByExampleGroupByCourse")
    Integer countByExampleGroupByCourse(InstClassHourCourseTeacherDailyExample example);

    @SelectProvider(type = InstClassHourCourseTeacherDailyExtSqlProvider.class, method = "countByExampleGroupByTeacher")
    Integer countByExampleGroupByTeacher(InstClassHourCourseTeacherDailyExample example);
}