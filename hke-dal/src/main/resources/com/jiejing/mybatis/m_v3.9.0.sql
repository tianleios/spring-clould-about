
-- 新增机构流水表
CREATE TABLE `crm_institution_journal` (
  `id` bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `payment_date` datetime NOT NULL COMMENT '支付时间',
  `payment_type` int(11) NOT NULL COMMENT '支付方式',
  `payment_amount` int(11) NOT NULL COMMENT '支付金额',
  `s_inst_id` bigint(20) NOT NULL COMMENT '机构ID',
  `abutment_id` bigint(20) NOT NULL COMMENT '合同ID',
  `finance_audit_status` int(4) DEFAULT '0' COMMENT '财务审核状态',
  `finance_audit_id` bigint(20) DEFAULT NULL COMMENT '财务审核人ID',
  `journal_type` int(4) DEFAULT NULL COMMENT '流水类型',
  `remark` varchar(255) DEFAULT NULL COMMENT '流水备注',
  `gmt_create` datetime NOT NULL,
  `gmt_modify` datetime NOT NULL
) AUTO_INCREMENT=967 COMMENT='机构流水表|hgz|2017-08-17';
CREATE INDEX crm_institution_journal_abutment_id_index ON xiaomai.crm_institution_journal (abutment_id DESC);

-- 服务表新增字段
ALTER TABLE xiaomai.crm_account_service ADD service_type INT(4) DEFAULT '1' NOT NULL COMMENT '服务类型';
ALTER TABLE xiaomai.crm_account_service ADD giving_period INT(4) DEFAULT '0' COMMENT '赠送时间/(月)';
ALTER TABLE xiaomai.crm_account_service ADD sign_date DATETIME NULL COMMENT '签约日期';
ALTER TABLE xiaomai.crm_account_service ADD inst_id BIGINT(20) NULL COMMENT '校区ID';
ALTER TABLE xiaomai.crm_account_service ADD s_inst_id BIGINT(20) NOT NULL COMMENT '机构ID';
ALTER TABLE xiaomai.crm_account_service ADD abutment_id BIGINT(20) NOT NULL COMMENT '合同ID';
ALTER TABLE xiaomai.crm_account_service ADD open_flag TINYINT(1) DEFAULT 0 NOT NULL COMMENT '开户标记|0未开户|1已开户';
ALTER TABLE xiaomai.crm_institution_abutment MODIFY kp_phone VARCHAR(50) COMMENT '机构负责人电话号码';
-- 同步服务表数据
update crm_account_service s, crm_institution_account a
set s.abutment_id = a.abutment_id,
  s.inst_id = a.inst_id,
  s.s_inst_id = a.sinst_id,
  s.open_flag = ifnull(a.open_flag, 0)
where s.account_id = a.account_id;
update crm_account_service s, crm_institution_abutment a
set s.sign_date = a.sign_date
where s.abutment_id = a.abutment_id;
