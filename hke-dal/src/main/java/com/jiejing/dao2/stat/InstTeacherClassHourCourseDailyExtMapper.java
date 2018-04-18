package com.jiejing.dao2.stat;

import com.jiejing.model.InstTeacherClassHourCourseDailyExample;
import com.jiejing.vo.ClassHourVO;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface InstTeacherClassHourCourseDailyExtMapper {

    @SelectProvider(type = InstTeacherClassHourCourseDailyExtSqlProvider.class, method = "sumClassHourByExample")
    Long sumClassHourByExample(InstTeacherClassHourCourseDailyExample example);

    @SelectProvider(type = InstTeacherClassHourCourseDailyExtSqlProvider.class, method = "selectListByExampleGroupByCourse")
    List<ClassHourVO> selectListByExampleGroupByCourse(InstTeacherClassHourCourseDailyExample example);

    @SelectProvider(type = InstTeacherClassHourCourseDailyExtSqlProvider.class, method = "selectListByExampleGroupByTeacher")
    List<ClassHourVO> selectListByExampleGroupByTeacher(InstTeacherClassHourCourseDailyExample example);

    @SelectProvider(type = InstTeacherClassHourCourseDailyExtSqlProvider.class, method = "countByExampleGroupByCourse")
    Integer countByExampleGroupByCourse(InstTeacherClassHourCourseDailyExample example);

    @SelectProvider(type = InstTeacherClassHourCourseDailyExtSqlProvider.class, method = "countByExampleGroupByTeacher")
    Integer countByExampleGroupByTeacher(InstTeacherClassHourCourseDailyExample example);
}