package com.jiejing.dao2.stat;

import com.jiejing.model.InstTeacherClassHourCourseMonthlyExample;
import com.jiejing.vo.ClassHourVO;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface InstTeacherClassHourCourseMonthlyExtMapper {

    @SelectProvider(type = InstTeacherClassHourCourseMonthlyExtSqlProvider.class, method = "sumClassHourByExample")
    Long sumClassHourByExample(InstTeacherClassHourCourseMonthlyExample example);
    
    @SelectProvider(type = InstTeacherClassHourCourseMonthlyExtSqlProvider.class, method = "selectListByExampleGroupByCourse")
    List<ClassHourVO> selectListByExampleGroupByCourse(InstTeacherClassHourCourseMonthlyExample example);

    @SelectProvider(type = InstTeacherClassHourCourseMonthlyExtSqlProvider.class, method = "selectListByExampleGroupByTeacher")
    List<ClassHourVO> selectListByExampleGroupByTeacher(InstTeacherClassHourCourseMonthlyExample example);
    
    @SelectProvider(type = InstTeacherClassHourCourseMonthlyExtSqlProvider.class, method = "countByExampleGroupByCourse")
    Integer countByExampleGroupByCourse(InstTeacherClassHourCourseMonthlyExample example);

    @SelectProvider(type = InstTeacherClassHourCourseMonthlyExtSqlProvider.class, method = "countByExampleGroupByTeacher")
    Integer countByExampleGroupByTeacher(InstTeacherClassHourCourseMonthlyExample example);
}