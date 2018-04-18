package com.jiejing.service;

/**
 * Created by zc on 15/12/1.
 */
public enum SequenceType {
    INST_USER_SEQUENCE(1, "inst_user_sequence"),
    VIDEO_ALBUM_SEQUENCE(10, "album_sequence"),
    VIDEO_SEQUENCE(11, "video_sequence"),
    INSTITUTION_SEQUENCE(12, "inst_sequence"),
    INST_TEACHER_SEQUENCE(13, "inst_teacher_sequence"),
    INST_CLASS_SEQUENCE(14, "inst_class_sequence"),
    INST_STUDENT_SEQUENCE(15, "inst_student_sequence"),
    XM_USER_SEQUENCE(16, "xm_user"),
    XM_TEACHER_SEQUENCE(17, "xm_teacher_sequence"),
    DEAL_SEQUENCE(18, "deal_sequence"),
    SCHEDULE_SEQUENCE(19, "schedule_sequence"),
    DOCUMENT_SEQUENCE(20, "document_sequence"),
    DOCUMENT_ATTACH_SEQUENCE(21, "document_attach_sequence"),
    INDEX_MODEL_SEQUENCE(22, "index_model_sequence"),
    INST_CONTRACT_SEQUENCE(23, "inst_contract_sequence"),
    INST_CONTRACT_STUDENT_COURSE_SEQUENCE(24, "inst_contract_student_course_sequence"),
    MESSAGE_SEQUENCE(25, "message_sequence"),
    INST_ADMIN_SEQUENCE(26, "inst_admin_sequence"),
    INST_COURSE_SEQUENCE(27, "inst_course_sequence"),
    INST_BATCH_SEQUENCE(28, "inst_batch_sequence");
    private int code;
    private String desc;

    private SequenceType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

}
