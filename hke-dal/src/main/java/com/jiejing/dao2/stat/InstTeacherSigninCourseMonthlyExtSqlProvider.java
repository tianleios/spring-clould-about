package com.jiejing.dao2.stat;

import com.jiejing.model.InstTeacherSigninCourseMonthlyExample;

import static org.apache.ibatis.jdbc.SqlBuilder.*;
import static org.apache.ibatis.jdbc.SqlBuilder.GROUP_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

public class InstTeacherSigninCourseMonthlyExtSqlProvider extends InstTeacherSigninCourseMonthlySqlProvider{

    /**
     * 获取按课程统计列表
     * @param example
     * @return
     */
    public String selectListByExampleGroupByCourse(InstTeacherSigninCourseMonthlyExample example){
        BEGIN();
        SELECT(" course_id as ref_id,inst_id,sum(count) count, " +
                " sum(total_number) total_number," +
                " sum(absent_number + leave_number + extra_number) absent_number," +
                "round(sum(total_number-absent_number-leave_number-extra_number)/sum(total_number)*100,2) percent");
        FROM("inst_teacher_signin_course_monthly");
        applyWhere(example,false);
        GROUP_BY("course_id,inst_id");
        String tmp = "";
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        if (example != null && example.getLimit() != null) {
            tmp = " limit " + example.getLimit().toString();
            if (example.getOffset() != null) {
                tmp = tmp + " offset " + example.getOffset().toString();
            }
        }
        return SQL() + tmp;
    }
    
    public String selectListByExampleGroupByTeacher(InstTeacherSigninCourseMonthlyExample example){
        BEGIN();
        SELECT("teacher_id as ref_id,inst_id,sum(count) count, " +
                " sum(total_number) total_number, " +
                " sum(absent_number + leave_number + extra_number) absent_number, " +
                "round(sum(total_number-absent_number-leave_number-extra_number)/sum(total_number)*100,2) percent");
        FROM("inst_teacher_signin_course_monthly");
        applyWhere(example,false);
        GROUP_BY("teacher_id,inst_id");
        String tmp = "";
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        if (example != null && example.getLimit() != null) {
            tmp = " limit " + example.getLimit().toString();
            if (example.getOffset() != null) {
                tmp = tmp + " offset " + example.getOffset().toString();
            }
        }
        return SQL() + tmp;
    }

    public String countByExampleGroupByCourse(InstTeacherSigninCourseMonthlyExample example){
        BEGIN();
        SELECT ("count(*)");
        FROM("inst_teacher_signin_course_monthly");
        applyWhere(example,false);
        GROUP_BY("course_id,inst_id");
        return " select count(*) from (" + SQL() + ") t";
    }

    public String countByExampleGroupByTeacher(InstTeacherSigninCourseMonthlyExample example){
        BEGIN();
        SELECT ("count(*)");
        FROM("inst_teacher_signin_course_monthly");
        applyWhere(example,false);
        GROUP_BY("teacher_id,inst_id");
        return " select count(*) from (" + SQL() + ") t";
    }
}