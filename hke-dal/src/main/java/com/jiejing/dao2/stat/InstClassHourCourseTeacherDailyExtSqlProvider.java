package com.jiejing.dao2.stat;

import com.jiejing.model.InstClassHourCourseTeacherDailyExample;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class InstClassHourCourseTeacherDailyExtSqlProvider extends InstClassHourCourseTeacherDailySqlProvider{


    /**
     * 统计课时
     * @param example
     * @return
     */
    public String sumClassHourByExample(InstClassHourCourseTeacherDailyExample example){
        BEGIN();
        SELECT ("sum(class_hour)");
        FROM("inst_class_hour_course_teacher_daily");
        applyWhere(example,false);
        return SQL();
    }

    /**
     * 统计课消
     * @param example
     * @return
     */
    public String sumPriceByExample(InstClassHourCourseTeacherDailyExample example){
        BEGIN();
        SELECT ("sum(price)");
        FROM("inst_class_hour_course_teacher_daily");
        applyWhere(example,false);
        return SQL();
    }

    /**
     * 获取按课程统计列表
     * @param example
     * @return
     */
    public String selectListByExampleGroupByCourse(InstClassHourCourseTeacherDailyExample example){
        BEGIN();
        SELECT("inst_id,course_id as ref_id,sum(class_hour) value,type");
        FROM("inst_class_hour_course_teacher_daily");
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

    /**
     * 获取按课程统计列表
     * @param example
     * @return
     */
    public String selectCostListByExampleGroupByCourse(InstClassHourCourseTeacherDailyExample example){
        BEGIN();
        SELECT("inst_id,course_id as ref_id,sum(price) value,type");
        FROM("inst_class_hour_course_teacher_daily");
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

    public String selectListByExampleGroupByTeacher(InstClassHourCourseTeacherDailyExample example){
        BEGIN();
        SELECT("inst_id,teacher_id as ref_id,sum(class_hour) value");
        FROM("inst_class_hour_course_teacher_daily");
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

    public String selectCostListByExampleGroupByTeacher(InstClassHourCourseTeacherDailyExample example){
        BEGIN();
        SELECT("inst_id,teacher_id as ref_id,sum(price) value");
        FROM("inst_class_hour_course_teacher_daily");
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

    public String countByExampleGroupByCourse(InstClassHourCourseTeacherDailyExample example){
        BEGIN();
        SELECT ("count(*)");
        FROM("inst_class_hour_course_teacher_daily");
        applyWhere(example,false);
        GROUP_BY("course_id,inst_id");
        return " select count(*) from (" + SQL() + ") t";
    }

    public String countByExampleGroupByTeacher(InstClassHourCourseTeacherDailyExample example){
        BEGIN();
        SELECT ("count(*)");
        FROM("inst_class_hour_course_teacher_daily");
        applyWhere(example,false);
        GROUP_BY("teacher_id,inst_id");
        return " select count(*) from (" + SQL() + ") t";
    }
}