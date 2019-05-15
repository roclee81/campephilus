CREATE TABLE `campephilus`.`info_device`
(
    `pk_id`                SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `device_code`          VARCHAR(45)       NOT NULL COMMENT '设备号，自行定义，需要设备号对应的仪器名',
    `device_serial_number` VARCHAR(45)       NOT NULL COMMENT '设备序列号，不一定唯一',
    `device_produce_date`  VARCHAR(10)       NOT NULL COMMENT '设备购买时间 eg: 2017-08-01',
    `device_service_life`  TINYINT           NOT NULL COMMENT '设备使用年限',
    `gmt_create`           DATETIME          NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`         DATETIME          NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_id`)
) COMMENT '设备信息表，信息需要手动输入';

CREATE TABLE `campephilus`.`info_hospital`
(
    `pk_hospital_code` VARCHAR(45) NOT NULL COMMENT '全国医院序列号，唯一',
    `hospital_name`    VARCHAR(45) NOT NULL COMMENT '医院名称',
    `hospital_area`    VARCHAR(45) NOT NULL COMMENT '医院区域',
    `hospital_level`   VARCHAR(45) NOT NULL COMMENT '医院的等级3甲等',
    `gmt_create`       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`     DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`pk_hospital_code`)
) COMMENT '医院信息表，信息需要手动输入';

CREATE TABLE `campephilus`.`info_operation`
(
    `pk_operation_number`  INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '手术顺序号',
    `operation_name`       VARCHAR(45)  NOT NULL COMMENT '手术名称',
    `operation_start_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '手术开始时间',
    `operation_end_time`   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '手术结束时间',
    `operation_state`      TINYINT      NOT NULL COMMENT '手术状态',
    `gmt_create`           DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`         DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `hospital_code`        VARCHAR(45)  NOT NULL COMMENT '医院国内代号，外键连接医院信息表',
    PRIMARY KEY (pk_operation_number)
) COMMENT '手术信息表4';

CREATE TABLE `campephilus`.`info_operation_mark`
(
    `pk_mark_id`        INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标记id，自动增长',
    `mark_type`         VARCHAR(32)  NOT NULL COMMENT '标记类型',
    `event_type`        VARCHAR(32)  NOT NULL COMMENT '事件类型',
    `event`             VARCHAR(32)  NOT NULL COMMENT '事件',
    `way`               VARCHAR(32)  NOT NULL COMMENT '途径',
    `dose`              VARCHAR(32)  NOT NULL COMMENT '剂量',
    `special_situation` VARCHAR(32) COMMENT '不良反应/特殊情况',
    `gmt_create`        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `operation_number`  INT UNSIGNED NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    PRIMARY KEY (pk_mark_id)
) COMMENT '标记信息表7';

CREATE TABLE `campephilus`.`info_patient`
(
    `pk_id`            SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID, 主键',
    `pk_patient_id`    VARCHAR(32)       NOT NULL COMMENT '病人身份证号',
    `admission_number` VARCHAR(32)       NOT NULL COMMENT '住院号',
    `sex`              TINYINT           NOT NULL COMMENT '性别0--男，1--女',
    `height`           TINYINT UNSIGNED  NOT NULL COMMENT '身高',
    `weight`           TINYINT UNSIGNED  NOT NULL COMMENT '体重',
    `age`              TINYINT UNSIGNED  NOT NULL COMMENT '年龄',
    `gmt_create`       DATETIME          NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`     DATETIME          NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `operation_number` INT UNSIGNED      NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    PRIMARY KEY (pk_id)
) COMMENT '病人信息表9';

CREATE TABLE `campephilus`.`info_before_operation`
(
    `pk_before_operation_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID, 主键',
    `anesthesia_mode`        VARCHAR(32)       NOT NULL COMMENT '麻醉方式',
    `is_urgent`              TINYINT           NOT NULL COMMENT '是否急诊',
    `is_strong`              TINYINT           NOT NULL COMMENT '是否增强',
    `ASA_level`              TINYINT           NOT NULL COMMENT 'ASA等级',
    `medical_history`        TEXT              NOT NULL COMMENT '既往病史',
    `special_case`           TEXT              NOT NULL COMMENT '特殊情况',
    `gmt_create`             DATETIME          NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`           DATETIME          NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `patient_id`             INT UNSIGNED      NOT NULL COMMENT '病人身份证号',
    `admission_number`       VARCHAR(32)       NOT NULL COMMENT '住院号',
    PRIMARY KEY (pk_before_operation_id)
) ) COMMENT '病人术前诊断信息表10';

CREATE TABLE `campephilus`.`info_after_operation`
(
    `pk_after_operation_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID, 主键',
    `feedback_content`      TEXT              NOT NULL COMMENT '反馈信息',
    `gmt_create`            DATETIME          NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`          DATETIME          NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `patient_id`            INT UNSIGNED      NOT NULL COMMENT '病人身份证号',
    `admission_number`      VARCHAR(32)       NOT NULL COMMENT '住院号',
    PRIMARY KEY (pk_after_operation_id)
) COMMENT '病人术后反馈表11';

# CREATE TABLE `campephilus`.`collector_info`
# (
#     `pk_collector_id`  INT UNSIGNED NOT NULL PRIMARY KEY,
#     `app_version`      VARCHAR(45)  NOT NULL COMMENT '',
#     `hardware_version` VARCHAR(45)  NOT NULL,
#     `gmt_create`       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#     `gmt_modified`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
#     `operation_number` INT UNSIGNED NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
#     PRIMARY KEY (pk_collector_id)
# ) COMMENT '采集器信息表8';

CREATE TABLE `campephilus`.`device_hospital_relation`
(
    `pk_id`                SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `device_producer`      VARCHAR(45)          NOT NULL COMMENT '设备生产厂商',
    `device_serial_number` VARCHAR(45)          NOT NULL COMMENT '设备序列号，不一定唯一',
    `hospital_id`          VARCHAR(45)          NOT NULL COMMENT '全国医院序列号，唯一',
    `purchase_time`        DATE                 NOT NULL COMMENT '购买时间',
    `purchase_address`     VARCHAR(45)          NOT NULL COMMENT '购买地址',
    `comment_to_device`    TEXT,
    `gmt_create`           DATETIME             NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`         DATETIME             NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (pk_id)
) COMMENT '医院——医疗设备关系表3';


CREATE TABLE `campephilus`.`data_norwamd_9002s`
(
    `pk_norwamd_9002s_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增长',
    `BS`                  TINYINT      NOT NULL COMMENT '0-100 无效值 -1',
    `EMG`                 TINYINT      NOT NULL COMMENT '0-100 无效值 -1',
    `SQI`                 TINYINT      NOT NULL COMMENT '0-100 无效值 -1',
    `CSI`                 TINYINT      NOT NULL COMMENT '0-100 无效值 -1',
    `gmt_create`          DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `operation_number`    INT UNSIGNED NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    PRIMARY KEY (pk_norwamd_9002s_id)
) COMMENT '诺和9002s的数据表5';

CREATE TABLE `campephilus`.`data_pearlcare_yy106`
(
    `pk_pearlcare_yy106_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增长',
    `SQI`                   TINYINT      NOT NULL COMMENT '0-100 无效值 -1',
    `AI`                    TINYINT      NOT NULL COMMENT '0-100 无效值 -1',
    `EMG`                   TINYINT      NOT NULL COMMENT '0-100 无效值 -1',
    `BSR`                   TINYINT      NOT NULL COMMENT '0-100 无效值 -1',
    `gmt_create`            DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`          DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `operation_number`      INT UNSIGNED NOT NULL COMMENT '手术顺序号，外键连接手术信息表',
    PRIMARY KEY (pk_pearlcare_yy106_id)
) COMMENT '普可yy106的数据表6';