DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` varchar(32) NOT NULL ,
  `dict_name` varchar(100) ,
  `dict_code` varchar(100) ,
  `description` varchar(255) ,
  `del_flag` int(1) ,
  `create_by` varchar(32) ,
  `create_time` TIMESTAMP ,
  `update_by` varchar(32) ,
  `update_time` TIMESTAMP ,
  `type` int(1) ,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` varchar(32) ,
  `dict_id` varchar(32) ,
  `item_text` varchar(100) ,
  `item_value` varchar(100) ,
  `description` varchar(255) ,
  `sort_order` int(10) ,
  `status` int(11) ,
  `create_by` varchar(32) ,
  `create_time` TIMESTAMP ,
  `update_by` varchar(32) ,
  `update_time` TIMESTAMP,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `id` varchar(32) NOT NULL ,
  `material_name` varchar(255) DEFAULT NULL ,
  `material_description` varchar(255)  DEFAULT NULL ,
  `material_code` varchar(255) DEFAULT NULL ,
  `material_group_code` int(11) DEFAULT NULL,
  `one_time_flag` int(1) DEFAULT 0 ,
  `create_by` varchar(32) DEFAULT NULL ,
  `create_time` TIMESTAMP ,
  `update_by` varchar(32) DEFAULT NULL,
  `update_time` TIMESTAMP ,
  `del_flag` tinyint(1) DEFAULT 0
);

DROP TABLE IF EXISTS `banks`;
CREATE TABLE `banks` (
  `sub_branch_name` varchar(255) NOT NULL ,
  `sub_branch_id` varchar(50) DEFAULT NULL ,
  `province_id` int(11) DEFAULT NULL ,
  `province` varchar(255) DEFAULT NULL ,
  `city_id` int(11) DEFAULT NULL ,
  `city` varchar(255) DEFAULT NULL ,
  `bank_name` varchar(255) NOT NULL ,
  `bank_id` int(11) DEFAULT NULL
);

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` varchar(32) ,
  `company_code` varchar(32) NOT NULL ,
  `company_name` varchar(255) NOT NULL ,
  `create_by` varchar(32) DEFAULT NULL ,
  `create_time` TIMESTAMP ,
  `update_by` varchar(32) DEFAULT NULL ,
  `update_time` TIMESTAMP ,
  `del_flag` tinyint(1) DEFAULT 0 ,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `bank_account`;
CREATE TABLE `bank_account`  (
  `id` varchar(32) NOT NULL ,
  `bank_id` varchar(32) NOT NULL ,
  `sub_branch_id` varchar(32) NOT NULL ,
  `bank_account` varchar(32) NOT NULL ,
  `bank_account_name` varchar(255) NOT NULL ,
  `create_by` varchar(32) ,
  `create_time` TIMESTAMP ,
  `update_by` varchar(32) ,
  `update_time` TIMESTAMP ,
  `del_flag` tinyint(1) DEFAULT 0 ,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `partner_bankaccount_rel`;
CREATE TABLE `partner_bankaccount_rel`  (
  `id` varchar(32) NOT NULL ,
  `partner_id` varchar(32) NOT NULL ,
  `bank_account_id` varchar(32) NOT NULL ,
  `partner_type` char(1) DEFAULT 1 ,
  `create_by` varchar(32) ,
  `create_time` TIMESTAMP ,
  `update_by` varchar(32) ,
  `update_time` TIMESTAMP ,
  `del_flag` tinyint(1) DEFAULT 0 ,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `vendor_group`;
CREATE TABLE `vendor_group`  (
  `id` varchar(32) NOT NULL ,
  `vendor_group_name` varchar(255) ,
  `vendor_group_code` int(11) ,
  `create_by` varchar(32) ,
  `create_time` TIMESTAMP ,
  `update_by` varchar(32) ,
  `update_time` TIMESTAMP ,
  `del_flag` tinyint(1) DEFAULT 0 ,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor`  (
  `id` varchar(32) NOT NULL ,
  `code` varchar(32) ,
  `name` varchar(32) ,
  `vendor_group_id` varchar(32) ,
  `contact_person` varchar(20) ,
  `contact_person_id` varchar(30) ,
  `contact_phone` varchar(30) ,
  `social_credit_code` varchar(30) ,
  `tax_subject` varchar(20) ,
  `business_license` varchar(30) ,
  `tax_code` varchar(30) ,
  `create_by` varchar(32) ,
  `create_time` TIMESTAMP ,
  `update_by` varchar(32) ,
  `update_time` TIMESTAMP ,
  `del_flag` tinyint(1) DEFAULT 0 ,
  PRIMARY KEY (`id`)
);