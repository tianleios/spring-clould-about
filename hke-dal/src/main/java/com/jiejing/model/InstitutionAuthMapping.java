package com.jiejing.model;

import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "institution_auth_mapping")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionAuthMapping {
    /**
     * 校区ID
     */
    @Id
    @Column(name = "inst_id")
    private Long instId;

    /**
     * 权限CODE集
     */
    private String permissions;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    // institution_auth_mapping columns
    public static class column {
        public static final String instId = "instId";

        public static final String permissions = "permissions";

        public static final String gmtCreate = "gmtCreate";

        public static final String gmtModify = "gmtModify";
    }
}