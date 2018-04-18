package com.jiejing.dao2.stat;

import com.jiejing.model.InstTeacherSigninCourseMonthlyExample;
import com.jiejing.vo.AttendanceItemVO;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface InstTeacherSigninCourseMonthlyExtMapper extends InstTeacherSigninCourseMonthlyMapper{
    

    @SelectProvider(type = InstTeacherSigninCourseMonthlyExtSqlProvider.class, method = "selectListByExampleGroupByCourse")
    List<AttendanceItemVO> selectListByExampleGroupByCourse(InstTeacherSigninCourseMonthlyExample example);

    @SelectProvider(type = InstTeacherSigninCourseMonthlyExtSqlProvider.class, method = "selectListByExampleGroupByTeacher")
    List<AttendanceItemVO> selectListByExampleGroupByTeacher(InstTeacherSigninCourseMonthlyExample example);

    @SelectProvider(type = InstTeacherSigninCourseMonthlyExtSqlProvider.class, method = "countByExampleGroupByCourse")
    Integer countByExampleGroupByCourse(InstTeacherSigninCourseMonthlyExample example);

    @SelectProvider(type = InstTeacherSigninCourseMonthlyExtSqlProvider.class, method = "countByExampleGroupByTeacher")
    Integer countByExampleGroupByTeacher(InstTeacherSigninCourseMonthlyExample example);
}