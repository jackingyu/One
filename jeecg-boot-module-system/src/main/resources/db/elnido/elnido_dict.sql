-- 字典:物料组
INSERT INTO `sys_dict` (`id`, `dict_name`, `dict_code`, `description`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `type`)
VALUES ('846bff712c4f483095e9f68f50f6ec44', '物料组名称', 'material_group', '物料组名称', '0', 'admin', '2020-02-09 00:00:00', 'admin', '2020-02-09 00:00:00', '0');

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('ffa3834600d843d8b76bd8ebe97c987a', '846bff712c4f483095e9f68f50f6ec44', '钢铁', '1', '', 1, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('025a69d2b608445584920f97bcdff5d1', '846bff712c4f483095e9f68f50f6ec44', '水泥', '2', '', 2, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('6178abf167d54b379cf9f73f9cfbedd7', '846bff712c4f483095e9f68f50f6ec44', '螺丝钉', '3', '', 3, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('b6fa5511353843e0bad5458c9fa98b3b', '846bff712c4f483095e9f68f50f6ec44', '一次性物料', '4', '', 4, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);

-- 字典：物料类型
INSERT INTO `sys_dict` (`id`, `dict_name`, `dict_code`, `description`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `type`)
VALUES ('27a0b6674516492588a51961a216772b', '一次性物料标识', 'material_property', '0一次性物料1非一次性物料', '0', 'admin', '2020-02-09 00:00:00', 'admin', '2020-02-09 00:00:00', '1');

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('2df22bd33bd04fcd86555ff945cb0fe8', '27a0b6674516492588a51961a216772b', '是', '0', '', 1, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('ce21e32ac6f240b18a977c11ca859adc', '27a0b6674516492588a51961a216772b', '否', '1', '', 2, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);