CREATE TABLE center_institution (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name varchar(64) DEFAULT NULL COMMENT '机构名称',
  short_name varchar(32) DEFAULT NULL COMMENT '机构短命名',
  description varchar(255) NOT NULL COMMENT '机构描述',
  phone varchar(20) DEFAULT NULL COMMENT '机构电话',
  branch_number int DEFAULT 0 COMMENT '分校区数量',
  banner varchar(255) DEFAULT NULL COMMENT 'banner 图',
  status INT DEFAULT 0 NOT NULL COMMENT '0:有效,1:无效',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '中央机构';

CREATE TABLE institution (
  inst_id BIGINT NOT NULL PRIMARY KEY,
  cinst_name VARCHAR(20) NOT NULL COMMENT '中央机构名称',
  inst_admin VARCHAR(20) COMMENT '机构账号',
  teacher_number int DEFAULT 0 COMMENT '机构老师数量',
  student_number int DEFAULT 0 COMMENT '与小麦绑定的学生数量',
  deal_number int DEFAULT 0 COMMENT '机构订单数量',
  platform_income int DEFAULT 0 COMMENT '平台收入',
  royalty_rate int NOT NULL  COMMENT '提成%',
  name varchar(64) NOT NULL COMMENT '机构名称',
  description varchar(255) NOT NULL COMMENT '机构描述',
  phone varchar(20) DEFAULT NULL COMMENT '机构电话',
  banner varchar(255) DEFAULT NULL COMMENT 'banner 图',
  address VARCHAR(100) NOT NULL COMMENT '地址',
  address_code VARCHAR(255) NOT NULL COMMENT '地址code',
  city_code INT NOT NULL COMMENT '城市ID',
  status INT DEFAULT 0 NOT NULL COMMENT '0:有效,1:无效',
  latitude decimal(14,11) NOT NULL ,
  longitude decimal(14,11) NOT NULL ,
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '机构学区';

create table institution_admin (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  account VARCHAR(20) not null COMMENT '会员账号名称',
  inst_id BIGINT NOT NULL COMMENT '机构id',
  password VARCHAR(20) not null COMMENT '会员账号',
  salt VARCHAR(20) not null COMMENT '客户端提交的加密密码,在和solt加密一次生成最终密码',
  status int  default 1  COMMENT '0:开启,1:关闭',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '机构管理员账号';

create table institution_album (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  inst_id BIGINT(20) NOT NULL ,
  is_top int default 1 COMMENT '0:置顶,1:正常',
  photo VARCHAR(60) NOT NULL  COMMENT '照片',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '机构相册';


CREATE TABLE institution_student_case (
  id BIGINT(20)  PRIMARY KEY NOT NULL  AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL COMMENT '学生姓名',
  school VARCHAR(20) NOT NULL COMMENT '学生学校',
  description VARCHAR(300) NOT NULL COMMENT '描述',
  avatar VARCHAR(60) NOT NULL COMMENT '学生头像',
  inst_id BIGINT NOT NULL COMMENT '机构id',
  status int DEFAULT 1 COMMENT '0:可用 1:不可用',
  is_top int DEFAULT 1 COMMENT '0:置顶 1:不置顶',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '机构学生案例';


CREATE TABLE institution_course (
  course_id bigint PRIMARY KEY COMMENT '课程编号',
  name varchar(64) NOT NULL COMMENT '课程名称',
  description varchar(255) NOT NULL COMMENT '课程描述',
  city_code int DEFAULT NULL COMMENT '城市编码',
  address_code VARCHAR(10) NOT NULL  COMMENT '省,市,区',
  type int NOT NULL COMMENT '1:班课,2:1对1',
  applicable_student varchar(100) NOT NULL COMMENT '适用学生',
  banner varchar(255) NOT NULL COMMENT '课程banner',
  inst_id BIGINT NOT NULL COMMENT '机构id',
  inst_name VARCHAR(64) NOT NULL COMMENT '机构名',
  inst_teacher_id BIGINT NOT NULL COMMENT '老师id',
  inst_teacher_name VARCHAR(20) NOT NULL COMMENT '教师名称',
  max_number int(11) NOT NULL COMMENT '最大报名数',
  min_number int(11) NOT NULL COMMENT '最小报名数',
  remain int(11) NOT NULL COMMENT '剩余人数',
  begin_time TIMESTAMP NOT NULL COMMENT '课程开始时间',
  show_time TIMESTAMP NOT NULL  COMMENT '上架时间',
  subject int NOT NULL COMMENT '科目',
  grade int NOT NULL COMMENT '年级',
  class_hour INT NOT NULL COMMENT '课时',
  address varchar(255) NOT NULL COMMENT '上课地址',
  latitude decimal(14,11) NOT NULL COMMENT '纬度',
  longitude decimal(14,11) NOT NULL COMMENT '经度',
  price INT NOT NULL COMMENT '当前价格 分为单位',
  orig_price INT NOT NULL COMMENT '原价 分为单位',
  status INT NOT NULL COMMENT '1:未上架,2:开始报名,3:上课中,4:上课结束',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '机构课程';

CREATE TABLE institution_teacher (
  teacher_id BIGINT NOT NULL  PRIMARY KEY ,
  inst_id BIGINT NOT NULL,
  inst_name VARCHAR(64) NOT NULL ,
  name VARCHAR(20) NOT NULL ,
  gender int NOT NULL COMMENT '性别',
  job_begin_time TIMESTAMP NOT NULL  COMMENT '教学开始时间',
  subject int NOT NULL COMMENT '擅长科目',
  birthday TIMESTAMP NOT NULL ,
  phone VARCHAR(20) NOT NULL ,
  avatar VARCHAR(255) NOT NULL  COMMENT '头像',
  education INT NOT NULL  COMMENT '学历',
  university VARCHAR(60) NOT NULL  COMMENT '毕业学校',
  label VARCHAR(60) NOT NULL COMMENT '个人标签',
  description VARCHAR(500) NOT NULL COMMENT '简介',
  latitude decimal(14,11) NOT NULL COMMENT '纬度',
  longitude decimal(14,11) NOT NULL COMMENT '经度',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '机构老师';

CREATE TABLE institution_teacher_experience(
  id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  inst_teacher_id BIGINT NOT NULL ,
  begin_time TIMESTAMP NOT NULL ,
  end_time TIMESTAMP NOT NULL ,
  description VARCHAR(500) NOT NULL COMMENT '教学经历',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '教师工作经历';


create table institution_student (
  student_id BIGINT PRIMARY KEY  ,
  inst_id BIGINT NOT NULL  COMMENT '机构id',
  name VARCHAR(20) NOT NULL ,
  gender INT NOT NULL  COMMENT '性别',
  birthday TIMESTAMP NOT NULL ,
  grade int ,
  school_code int,
  school_name VARCHAR(60) COMMENT '学校名称',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '机构学生';


create table institution_student_course(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  grade INT NOT NULL ,
  subject INT NOT NULL ,
  inst_teacher_id BIGINT NOT NULL ,
  inst_teacher_name VARCHAR(20) NOT NULL ,
  inst_course_id BIGINT NOT NULL ,
  inst_course_name VARCHAR(20) NOT NULL ,
  inst_course_type INT NOT NULL,
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '学生报名的课程';


CREATE TABLE  institution_student_report (
  id BIGINT PRIMARY KEY  AUTO_INCREMENT,
  student_id BIGINT NOT NULL ,
  student_name  VARCHAR(20) NOT NULL ,
  inst_id BIGINT NOT NULL COMMENT '机构id',
  school_name VARCHAR(30) ,
  school_code INT,
  exam_date TIMESTAMP NOT NULL  COMMENT '考试时间',
  grade int NOT NULL ,
  subject int NOT NULL ,
  subject_full_score INT COMMENT '科目总分',
  score  int COMMENT '学生考试分数',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '学生成绩单';



create table institution_broadcast (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  inst_id BIGINT NOT NULL ,
  inst_name VARCHAR(60) NOT NULL ,
  title VARCHAR(60) NOT NULL COMMENT '标题',
  type int NOT NULL  COMMENT '1:新闻 ,2:活动',
  style int NOT NULL COMMENT '1:样式1,2:样式2,3:样式3,4:活动版式',
  show_time TIMESTAMP  COMMENT '发布时间',
  is_top int DEFAULT 1 COMMENT '0:置顶,1 不置顶',
  content VARCHAR(500) NOT NULL ,
  icons VARCHAR(50) NOT NULL  COMMENT '活动配图',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '机构黑板报';


create table institution_activity (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  inst_broadcast_id BIGINT NOT NULL ,
  begin_time TIMESTAMP COMMENT '活动开始时间',
  end_time TIMESTAMP  COMMENT '结束时间',
  address VARCHAR(60)  ,
  address_code VARCHAR(10) COMMENT '省,市,区',
  city_code int NOT NULL ,
  productNumber int COMMENT '活动人数 <0 无限制',
  price int COMMENT '报名费',
  apply_deadline TIMESTAMP NOT NULL COMMENT '报名截止时间'
)COMMENT '机构活动';


create table institution_applicant_record(
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
  inst_id BIGINT NOT NULL COMMENT '机构id',
  inst_name VARCHAR(20) NOT NULL COMMENT '机构名称',
  phone VARCHAR(20) NOT NULL ,
   name VARCHAR(20) NOT NULL ,
   birthday TIMESTAMP NOT NULL ,
   is_callback int DEFAULT 1 COMMENT '0:已经回访,1:未回访',
   status int DEFAULT 1 COMMENT '0:已经绑定,1 未绑定',
   note VARCHAR(100) COMMENT '备注',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '申请用户';


create table institution_member (
  id BIGINT PRIMARY KEY  AUTO_INCREMENT,
  inst_id BIGINT NOT NULL ,
  inst_name VARCHAR(32) COMMENT '机构名称',
  student_id BIGINT NOT NULL ,
  student_name VARCHAR(20) NOT NULL ,
  student_grade int COMMENT '年级',
  xm_user_id VARCHAR(20) NOT NULL  COMMENT 'c 端会员账号',
  xm_user_phone VARCHAR(15) NOT NULL  COMMENT 'c 端会员电话',
  xm_family_id BIGINT NOT NULL COMMENT 'c 端家庭成员账号',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间'
)COMMENT '机构从小麦获取的会员';


create table xm_user (
   user_id BIGINT PRIMARY KEY ,
   name VARCHAR(20) COMMENT '会员姓名',
   gender int COMMENT '性别',
   birthday TIMESTAMP COMMENT '生日',
   education VARCHAR(20) COMMENT '学历',
   university VARCHAR(20) COMMENT '毕业学校',
   phone VARCHAR(20) COMMENT '联系电话',
   family_number int COMMENT '成员数量',
   avatar VARCHAR(255) NOT NULL  COMMENT '头像',
   gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
   gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间'
)COMMENT '小麦账号';


create table xm_user_family (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  parent_id BIGINT NOT NULL ,
  name VARCHAR(20),
  gender int ,
  birthday TIMESTAMP ,
  grade int,
  school VARCHAR(20),
  status int DEFAULT 0 COMMENT '0:未绑定,1:绑定',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间'
)COMMENT '家庭成员,目前是小孩子';


create table xm_feedback (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   user_id BIGINT,
   phone VARCHAR(20),
   device_type int COMMENT '平台类型 android ,ios',
   device_name VARCHAR(10) COMMENT '平台名称 android,ios',
   status int DEFAULT 0 COMMENT '0:未回访,1:意见回访',
   note VARCHAR(20) COMMENT '备注',
   content VARCHAR(500) NOT NULL ,
   gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
   gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间'
)COMMENT '意见反馈';


create table xm_video (
  video_id BIGINT PRIMARY KEY ,
  title VARCHAR(20) NOT NULL COMMENT '视频名称',
  grade int NOT NULL  COMMENT '适用年级',
  subject int NOT NULL COMMENT '科目',
  city_code int NOT NULL COMMENT '城市',
  xm_teacher_name VARCHAR(20) NOT NULL COMMENT '小麦老师',
  xm_teacher_id BIGINT NOT NULL,
  price int NOT NULL COMMENT '价格',
  cover_img VARCHAR(50) NOT NULL  COMMENT '视频封面',
  applicable_student VARCHAR(20) NOT NULL COMMENT '适用人群',
  label VARCHAR(50) NOT NULL COMMENT '特点',
  url VARCHAR(60) NOT NULL COMMENT '视频地址',
  description VARCHAR(500) COMMENT '描述',
  status int NOT NULL  COMMENT '1:下架,2:上架,3:删除',
  play_times int  DEFAULT 0 COMMENT '播放次数',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '小麦精品课程';


create table xm_video_album (
   album_id BIGINT PRIMARY KEY ,
   grade int NOT NULL ,
   subject int NOT NULL ,
   city_code int NOT NULL ,
   xm_teacher_id BIGINT,
   xm_teacher_name VARCHAR(20),
   cover_img VARCHAR(50) NOT NULL COMMENT '专辑封面',
   applicable_student VARCHAR(20) NOT NULL COMMENT '适用人群',
   label VARCHAR(50) NOT NULL ,
   play_times int DEFAULT 0 COMMENT '播放次数',
   status int NOT NULL  COMMENT '1:下架,2:上架',
   description VARCHAR(500) NOT NULL COMMENT '描述',
   gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
   gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
   operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
   operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '小麦视频专辑';


create table xm_album_mapping_video (
  id BIGINT PRIMARY KEY  AUTO_INCREMENT,
  album_id BIGINT NOT NULL ,
  video_id BIGINT NOT NULL ,
  video_title VARCHAR(20) NOT NULL ,
  video_teacher VARCHAR(20) NOT NULL COMMENT '视频教师',
  video_price int NOT NULL COMMENT '视频价格',
  video_cover VARCHAR(255) NOT NULL
)COMMENT '专辑下的视频';


create table xm_advert (
  id BIGINT PRIMARY KEY  AUTO_INCREMENT,
  show_time TIMESTAMP NOT NULL COMMENT '发布时间',
  city_code int NOT NULL COMMENT '城市code',
  city_name VARCHAR(20) NOT NULL COMMENT '城市名称',
  direct_url VARCHAR(30) NOT NULL COMMENT '跳转地址',
  status int NOT NULL COMMENT '0:开启,1:关闭',
  banner VARCHAR(30) NOT NULL COMMENT '广告banner',
  is_top int COMMENT '0:置顶,1:不置顶',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '广告配置';


create table xm_support_city (
  id BIGINT PRIMARY KEY  AUTO_INCREMENT,
  code int NOT NULL ,
  name VARCHAR(20) NOT NULL ,
  status int NOT NULL COMMENT '0:开通,1:关闭',
  is_show  int NOT NULL COMMENT '0:显示,1:隐藏',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '小麦开通的城市';


create table xm_teacher (
  teacher_id BIGINT PRIMARY KEY ,
  name VARCHAR(20) NOT NULL ,
  gender int NOT NULL COMMENT '性别',
  city_code int NOT NULL ,
  city_name VARCHAR(20) NOT NULL ,
  email VARCHAR(30) ,
  education INT NOT NULL  COMMENT '学历',
  university VARCHAR(60) NOT NULL  COMMENT '毕业学校',
  birthday TIMESTAMP NOT NULL ,
  job_begin_time TIMESTAMP NOT NULL  COMMENT '教学开始时间',
  subject int NOT NULL COMMENT '擅长科目',
  phone VARCHAR(20) NOT NULL ,
  avatar VARCHAR(60) NOT NULL  COMMENT '头像',
  label VARCHAR(60) NOT NULL COMMENT '个人标签',
  description VARCHAR(500) NOT NULL COMMENT '简介',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '小麦老师';


create table index_video (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(20) NOT NULL ,
  album_id BIGINT NOT NULL ,
  video_records VARCHAR(20) NOT NULL  COMMENT '视频集中选择的视频video_id,video_id ..',
  is_top int default 1 COMMENT '0:置顶,1:不置顶',
  status int NOT NULL  COMMENT '0:可用,1:不可用',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间',
  operator_id VARCHAR(30) NOT NULL COMMENT '后台录入人员id',
  operator_name VARCHAR(30) NOT NULL COMMENT '后台录入人员姓名'
)COMMENT '首页视频';

create table deal (
  deal_id BIGINT NOT NULL ,
  userId varchar(20) NOT NULL,
  phone varchar(20) NOT NULL ,
  product_number int(11) NOT NULL ,
  product_name varchar(255) NOT NULL,
  product_img  varchar(255) DEFAULT NULL,
  product_type int NOT NULL ,
  belong_id BIGINT DEFAULT NULL COMMENT '从属id',
  belong_name varchar(64) DEFAULT NULL COMMENT '从属name',
  total_price int NOT NULL ,
  complete_price int NOT NULL ,
  pay_time timestamp NOT NULL ,
  complete_time TIMESTAMP NOT NULL ,
  deal_type int NOT NULL COMMENT '订单类型:1平台订单,2机构订单',
  status int NOT NULL COMMENT '1:待支付,2:支付确认中,3:支付失败,4:支付完成',
  gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
  gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间'
)COMMENT '订单';


create table deal_product (
   deal_id BIGINT PRIMARY KEY ,
   product_id BIGINT NOT NULL ,
   product_type int NOT NULL ,
   product_name varchar(255) DEFAULT NULL,
   belong_id BIGINT DEFAULT NULL COMMENT '从属id',
   belong_name varchar(64) DEFAULT NULL COMMENT '从属name',
   price int NOT NULL COMMENT '成交价格',
   original_price int NOT NULL ,
   product_img varchar(255) DEFAULT NULL,
   gmt_create TIMESTAMP NOT NULL COMMENT '创建时间',
   gmt_modify TIMESTAMP NOT NULL COMMENT '修改时间'
)COMMENT '订单商品表';


create table xm_user_asset (
   userId BIGINT(20) NOT NULL ,
   assert_id BIGINT NOT NULL ,
   assert_type int NOT NULL COMMENT '资产类型 1:视频,2:资料'
)COMMENT '用户资产表';

create table xm_user_token (
   userId BIGINT(20) PRIMARY KEY,
   token varchar(64) NOT NULL
)COMMENT '用户token表';

create table xm_user_mapping_institution(
  id BIGINT(20) PRIMARY KEY,
  user_id BIGINT(20) NOT NULL COMMENT '用户id',
  inst_id BIGINT(20) NOT NULL COMMENT '机构id',
  gmt_create timestamp NULL DEFAULT NULL,
  gmt_modify timestamp NULL DEFAULT NULL
)COMMENT '用户关注机构表';

create table xm_version (
   id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
   platform int(11) NOT NULL,
   release_no varchar(64) NOT NULL,
   release_code int(11) NOT NULL,
   release_url varchar(255) NOT NULL,
   release_note varchar(255) NOT NULL,
   forced int(11) DEFAULT NULL,
   status tinyint(1) DEFAULT NULL,
   gmt_create timestamp NULL DEFAULT NULL,
   gmt_modify timestamp NULL DEFAULT NULL
)COMMENT '版本表';

CREATE TABLE deal_third_record (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  payment_type int(11) DEFAULT NULL,
  subject varchar(255) DEFAULT NULL,
  buyer_email varchar(255) DEFAULT NULL,
  trade_no varchar(64) DEFAULT NULL,
  out_trade_no varchar(64) DEFAULT NULL,
  notify_type varchar(255) DEFAULT NULL,
  pay_type int(11) DEFAULT NULL,
  feedback_count int(11) DEFAULT NULL,
  trade_status varchar(16) DEFAULT NULL,
  gmt_create timestamp NULL DEFAULT NULL,
  quantity int(11) DEFAULT NULL,
  seller_id varchar(64) DEFAULT NULL,
  notify_time timestamp NULL DEFAULT NULL,
  body varchar(255) DEFAULT NULL,
  is_total_fee_adjust varchar(10) DEFAULT NULL,
  total_fee int(11) DEFAULT NULL,
  seller_email varchar(255) DEFAULT NULL,
  price int(11) DEFAULT NULL,
  buyer_id varchar(64) DEFAULT NULL,
  notify_id varchar(64) DEFAULT NULL,
  use_coupon varchar(10) DEFAULT NULL,
  sign_type varchar(20) DEFAULT NULL,
  sign varchar(255) DEFAULT NULL,
  discount decimal(10,4) DEFAULT NULL,
  PRIMARY KEY (id)
) COMMENT '支付宝回馈表';

create table xm_sequence (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  seq_code INT NOT NULL COMMENT '业务代码',
  seq_name VARCHAR(20) NOT NULL COMMENT '业务名称',
  value BIGINT NOT NULL,
  step int NOT NULL
)COMMENT 'sequence 生成';
create UNIQUE INDEX seq_code_index on  xm_sequence(seq_code);

INSERT into xm_sequence(seq_code, seq_namem,value, step) VALUE (10,'机构id')














































