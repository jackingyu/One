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

-- 字典：供应商类型
INSERT INTO `sys_dict` (`id`, `dict_name`, `dict_code`, `description`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `type`)
VALUES ('064ff911ed4d401696c105f2b4fb6220', '供应商分组', 'vendor_group', '供应商分组', '0', 'admin', '2020-02-09 00:00:00', 'admin', '2020-02-09 00:00:00', '0');

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('32a60361e02345cb9e64faa32fc1001d', '064ff911ed4d401696c105f2b4fb6220', '钢铁材料商', '1', '', 1, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('404146de8eea4455a0fa8472168ba44e', '064ff911ed4d401696c105f2b4fb6220', '水泥材料商', '2', '', 2, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('c83341327ca3442891ff88ea8c45055f', '064ff911ed4d401696c105f2b4fb6220', '黄沙材料商', '3', '', 2, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);

-- 字典：客户类型
INSERT INTO `sys_dict` (`id`, `dict_name`, `dict_code`, `description`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `type`)
VALUES ('5265a67e79e34060a556e608ae3e5125', '客户分组', 'customer_group', '客户分组', '0', 'admin', '2020-02-09 00:00:00', 'admin', '2020-02-09 00:00:00', '0');

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('c578865104f84deea11c712225718ec1', '5265a67e79e34060a556e608ae3e5125', '材料商', '1', '', 1, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('dd411151c574461e97041baba07b9bdd', '5265a67e79e34060a556e608ae3e5125', '分包商', '2', '', 2, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `item_text`, `item_value`, `description`, `sort_order`, `status`, `create_by`, `create_time`, `update_by`, `update_time`)
VALUES ('6a5b8473e7c44f46a383ff579f03352e', '5265a67e79e34060a556e608ae3e5125', '建设单位', '3', '', 2, '1', 'admin', '2020-02-09 00:00:00', NULL, NULL);