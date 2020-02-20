-- 物料
INSERT INTO `material` (id, material_name, material_description, material_code, material_group_code, create_by, create_time)
VALUES ('e6384b48501b11eab77f2e728ce88125','测试物料001', '测试物料001描述', 'M001', 1, 'materialadmin', now());

INSERT INTO `material` (id, material_name, material_description, material_code, material_group_code, create_by, create_time)
VALUES ('ffe777c6501b11eab77f2e728ce88125','测试物料002', '测试物料002描述', 'M002', 1, 'materialadmin', now());

INSERT INTO `material` (id, material_name, material_description, material_code, material_group_code, create_by, create_time)
VALUES ('13b5096c501c11eab77f2e728ce88125','测试物料003', '测试物料003描述', 'M003', 1, 'materialadmin', now());

INSERT INTO `material` (id, material_name, material_description, material_code, material_group_code, create_by, create_time)
VALUES ('20f09fc4501c11eab77f2e728ce88125','测试物料004', '测试物料004描述', 'M004', 1, 'materialadmin', now());

INSERT INTO `material` (id, material_name, material_description, material_code, material_group_code, create_by, create_time)
VALUES ('349fb71c501c11eab77f2e728ce88125','测试物料005', '测试物料005描述', 'M005', 2, 'materialadmin', now());

-- 供应商分组
INSERT INTO `vendor_group` (vendor_group_name, vendor_group_code, create_by, create_time)
VALUES ('钢铁材料商', 1, 'vendoradmin', now());

INSERT INTO `vendor_group` (vendor_group_name, vendor_group_code, create_by, create_time)
VALUES ('水泥材料商', 2, 'vendoradmin', now());

INSERT INTO `vendor_group` (vendor_group_name, vendor_group_code, create_by, create_time)
VALUES ('黄沙材料商', 3, 'vendoradmin', now());