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
