CREATE DATABASE IF NOT EXISTS test  CHARACTER SET  utf8;
USE test;
CREATE TABLE `interface_info` (
    `api_id`          INT(11)      NOT NULL AUTO_INCREMENT   COMMENT 'ID',
    `api_method`      VARCHAR(12)  NOT NULL                  COMMENT 'HttpMethod：GET、PUT、POST',
    `api_path`        VARCHAR(512) NOT NULL                  COMMENT '拦截路径',
    `api_status`      INT(2)       NOT NULL                  COMMENT '状态：0草稿，1发布，2有变更，3禁用',
    `api_comment`     VARCHAR(255)     NULL                  COMMENT '注释',
    `api_type`        VARCHAR(24)  NOT NULL                  COMMENT '脚本类型：SQL、DataQL',
    `api_script`      MEDIUMTEXT   NOT NULL                  COMMENT '查询脚本：xxxxxxx',
    `api_schema`      MEDIUMTEXT       NULL                  COMMENT '接口的请求/响应数据结构',
    `api_sample`      MEDIUMTEXT       NULL                  COMMENT '请求/响应/请求头样本数据',
    `api_create_time` DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `api_gmt_time`    DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`api_id`)
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='Dataway 中的API';

CREATE TABLE `interface_release` (
    `pub_id`          INT(11)      NOT NULL AUTO_INCREMENT   COMMENT 'Publish ID',
    `pub_api_id`      INT(11)      NOT NULL                  COMMENT '所属API ID',
    `pub_method`      VARCHAR(12)  NOT NULL                  COMMENT 'HttpMethod：GET、PUT、POST',
    `pub_path`        VARCHAR(512) NOT NULL                  COMMENT '拦截路径',
    `pub_status`      INT(2)       NOT NULL                  COMMENT '状态：0有效，1无效（可能被下线）',
    `pub_type`        VARCHAR(24)  NOT NULL                  COMMENT '脚本类型：SQL、DataQL',
    `pub_script`      MEDIUMTEXT   NOT NULL                  COMMENT '查询脚本：xxxxxxx',
    `pub_script_ori`  MEDIUMTEXT   NOT NULL                  COMMENT '原始查询脚本，仅当类型为SQL时不同',
    `pub_schema`      MEDIUMTEXT       NULL                  COMMENT '接口的请求/响应数据结构',
    `pub_sample`      MEDIUMTEXT       NULL                  COMMENT '请求/响应/请求头样本数据',
    `pub_release_time`DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间（下线不更新）',
    PRIMARY KEY (`pub_id`)
) ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='Dataway API 发布历史。';

CREATE INDEX idx_interface_release ON interface_release (pub_api_id);
