package com.jiejing.dao2.stat;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.jiejing.model.InstScoreCourseHistory;
import com.jiejing.model.InstScoreCourseHistoryExample.Criteria;
import com.jiejing.model.InstScoreCourseHistoryExample.Criterion;
import com.jiejing.model.InstScoreCourseHistoryExample;
import java.util.List;
import java.util.Map;

public class InstScoreCourseHistorySqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_score_course_history
     *
     * @mbggenerated Tue Apr 18 09:54:09 CST 2017
     */
    public String countByExample(InstScoreCourseHistoryExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("inst_score_course_history");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_score_course_history
     *
     * @mbggenerated Tue Apr 18 09:54:09 CST 2017
     */
    public String deleteByExample(InstScoreCourseHistoryExample example) {
        BEGIN();
        DELETE_FROM("inst_score_course_history");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_score_course_history
     *
     * @mbggenerated Tue Apr 18 09:54:09 CST 2017
     */
    public String insertSelective(InstScoreCourseHistory record) {
        BEGIN();
        INSERT_INTO("inst_score_course_history");
        
        if (record.getInstId() != null) {
            VALUES("inst_id", "#{instId,jdbcType=BIGINT}");
        }
        
        if (record.getCount() != null) {
            VALUES("count", "#{count,jdbcType=INTEGER}");
        }
        
        if (record.getSumScore() != null) {
            VALUES("sum_score", "#{sumScore,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            VALUES("score", "#{score,jdbcType=DOUBLE}");
        }
        
        if (record.getCourseId() != null) {
            VALUES("course_id", "#{courseId,jdbcType=BIGINT}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_score_course_history
     *
     * @mbggenerated Tue Apr 18 09:54:09 CST 2017
     */
    public String selectByExample(InstScoreCourseHistoryExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("inst_id");
        } else {
            SELECT("inst_id");
        }
        SELECT("count");
        SELECT("sum_score");
        SELECT("score");
        SELECT("course_id");
        FROM("inst_score_course_history");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        String tmp = "";
        if (example != null && example.getLimit() != null) {
            tmp = " limit " + example.getLimit().toString();
            if (example.getOffset() != null) {
                tmp = tmp + " offset " + example.getOffset().toString();
            }
        }
        return SQL() + tmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_score_course_history
     *
     * @mbggenerated Tue Apr 18 09:54:09 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        InstScoreCourseHistory record = (InstScoreCourseHistory) parameter.get("record");
        InstScoreCourseHistoryExample example = (InstScoreCourseHistoryExample) parameter.get("example");
        
        BEGIN();
        UPDATE("inst_score_course_history");
        
        if (record.getInstId() != null) {
            SET("inst_id = #{record.instId,jdbcType=BIGINT}");
        }
        
        if (record.getCount() != null) {
            SET("count = #{record.count,jdbcType=INTEGER}");
        }
        
        if (record.getSumScore() != null) {
            SET("sum_score = #{record.sumScore,jdbcType=INTEGER}");
        }
        
        if (record.getScore() != null) {
            SET("score = #{record.score,jdbcType=DOUBLE}");
        }
        
        if (record.getCourseId() != null) {
            SET("course_id = #{record.courseId,jdbcType=BIGINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_score_course_history
     *
     * @mbggenerated Tue Apr 18 09:54:09 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("inst_score_course_history");
        
        SET("inst_id = #{record.instId,jdbcType=BIGINT}");
        SET("count = #{record.count,jdbcType=INTEGER}");
        SET("sum_score = #{record.sumScore,jdbcType=INTEGER}");
        SET("score = #{record.score,jdbcType=DOUBLE}");
        SET("course_id = #{record.courseId,jdbcType=BIGINT}");
        
        InstScoreCourseHistoryExample example = (InstScoreCourseHistoryExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inst_score_course_history
     *
     * @mbggenerated Tue Apr 18 09:54:09 CST 2017
     */
    protected void applyWhere(InstScoreCourseHistoryExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}