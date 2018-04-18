package com.jiejing.dao2.stat;

import com.jiejing.model.InstTeacherClassHourCourseMonthlyExample;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class InstTeacherClassHourCourseMonthlyExtSqlProvider extends InstTeacherClassHourCourseMonthlySqlProvider{

    /**
     * 统计课时
     * @param example
     * @return
     */
    public String sumClassHourByExample(InstTeacherClassHourCourseMonthlyExample example){
        BEGIN();
        SELECT ("sum(class_hour)");
        FROM("inst_teacher_class_hour_course_monthly");
        applyWhere(example,false);
        return SQL();
    }

    /**
     * 获取按课程统计列表
     * @param example
     * @return
     */
    public String selectListByExampleGroupByCourse(InstTeacherClassHourCourseMonthlyExample example){
        BEGIN();
        SELECT("inst_id,course_id as ref_id,sum(class_hour) value,type");
        FROM("inst_teacher_class_hour_course_monthly");
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

    public String selectListByExampleGroupByTeacher(InstTeacherClassHourCourseMonthlyExample example){
        BEGIN();
        SELECT("inst_id,teacher_id as ref_id,sum(class_hour) value");
        FROM("inst_teacher_class_hour_course_monthly");
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


    public String countByExampleGroupByCourse(InstTeacherClassHourCourseMonthlyExample example){
        BEGIN();
        SELECT ("count(*)");
        FROM("inst_teacher_class_hour_course_monthly");
        applyWhere(example,false);
        GROUP_BY("course_id,inst_id");
        return " select count(*) from (" + SQL() + ") t";
    }

    public String countByExampleGroupByTeacher(InstTeacherClassHourCourseMonthlyExample example){
        BEGIN();
        SELECT ("count(*)");
        FROM("inst_teacher_class_hour_course_monthly");
        applyWhere(example,false);
        GROUP_BY("teacher_id,inst_id");
        return " select count(*) from (" + SQL() + ") t";
    }
}