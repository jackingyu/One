DROP TABLE IF EXISTS `material_group`;
CREATE TABLE `material_group`  (
  `id` varchar(32),
  `material_group_name` varchar(255) DEFAULT NULL ,
  `material_group_code` int(11) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  `create_time` TIMESTAMP,
  `update_by` varchar(32) DEFAULT NULL ,
  `update_time` TIMESTAMP,
  `del_flag` tinyint(1) DEFAULT 0
);


DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `id` varchar(32) NOT NULL,
  `material_name` varchar(255) DEFAULT NULL,
  `material_description` varchar(255)  DEFAULT NULL ,
  `material_code` varchar(255) DEFAULT NULL ,
  `material_group_code` int(11) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL ,
  `create_time` TIMESTAMP,
  `update_by` varchar(32) DEFAULT NULL,
  `update_time` TIMESTAMP ,
  `del_flag` tinyint(1) DEFAULT 0
);

DROP TABLE IF EXISTS `banks`;
CREATE TABLE `banks` (
  `sub_branch_name` varchar(255) NOT NULL,
  `sub_branch_id` varchar(50) DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) NOT NULL,
  `bank_id` int(11) DEFAULT NULL
);