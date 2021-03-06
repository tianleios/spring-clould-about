CREATE DATABASE mytest;

-- 用户表
CREATE TABLE t_user(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL,
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


-- 角色表
CREATE TABLE t_role(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  role_name VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- 权限表
CREATE TABLE t_permission(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  permission_name VARCHAR(255) NOT NULL,
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- 用户_角色_关系表
CREATE TABLE t_user_role(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  role_id INT NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- 角色_权限_关系表
CREATE TABLE t_role_permission(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  role_id INT NOT NULL ,
  permission_id INT NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;