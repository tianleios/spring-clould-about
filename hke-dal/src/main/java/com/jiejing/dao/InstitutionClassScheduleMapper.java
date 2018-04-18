package com.jiejing.dao;

import com.jiejing.model.InstitutionClassSchedule;

public interface InstitutionClassScheduleMapper {

    // ********************************  1   每周    ***************************************//
    //1.1每周 与 每周
    void selectWeeklyClassConflict(InstitutionClassSchedule willClassSchedule);

    void selectWeeklyRoomConflict(InstitutionClassSchedule willClassSchedule);

    void selectWeeklyTeacherConflict(InstitutionClassSchedule willClassSchedule);

    void selectWeeklyStudentConflict(InstitutionClassSchedule willClassSchedule);

    //1.2  同1.1
    //1.3每周 与 课次
    void selectWeeklyCompareKCClassConflict();

    void selectWeeklyCompareKCRoomConflict();

    void selectWeeklyCompareKCTeacherConflict();

    void selectWeeklyCompareKCStudentConflict();


    // ******************************** 2    隔周    ********************************//
    //2.1 隔周 与 每周
    void selectSkipWeeklyCompareWeeklyClassConflict();

    void selectSkipWeeklyCompareWeeklyRoomConflict();

    void selectSkipWeeklyCompareWeeklyTeacherConflict();

    void selectSkipWeeklyCompareWeeklyStudentConflict();

    //2.2 隔周 与 隔周
    void selectSkipWeeklyCompareThisClassConflict();

    void selectSkipWeeklyCompareThisRoomConflict();

    void selectSkipWeeklyCompareThisTeacherConflict();

    void selectSkipWeeklyCompareThisStudentConflict();

    //2.3 隔周 与 课次
    void selectSkipWeeklyCompareKCClassConflict();

    void selectSkipWeeklyCompareKCRoomConflict();

    void selectSkipWeeklyCompareKCTeacherConflict();

    void selectSkipWeeklyCompareKCStudentConflict();


    // ********************************  3  课次       ********************************//
    //3.1 课次 与 课次
    void selectKCCompareKCClassConflict();

    void selectKCCompareKCRoomConflict();

    void selectKCCompareKCTeacherConflict();

    void selectKCCompareKCStudentConflict();

    //3.2 课次 与 每周
    void selectKCCompareWeeklyClassConflict();

    void selectKCCompareWeeklyRoomConflict();

    void selectKCCompareWeeklyTeacherConflict();

    void selectKCCompareWeeklyStudentConflict();

    //3.3 课次 与 隔周
    void selectKCCompareSkipWeeklyClassConflict();

    void selectKCCompareSkipWeeklyRoomConflict();

    void selectKCCompareSkipWeeklyTeacherConflict();

    void selectKCCompareSkipWeeklyStudentConflict();

}