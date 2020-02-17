-- 物料组
INSERT INTO `material_group` (id, material_group_name, material_group_code, create_by, create_time)
VALUES ('cb58da1014094888b8cb36fb13cadad1','钢铁', 1, 'materialadmin', now());

INSERT INTO `material_group` (id, material_group_name, material_group_code, create_by, create_time)
VALUES ('2fa87424500d11eab77f2e728ce88125','水泥', 2, 'materialadmin', now());

INSERT INTO `material_group` (id, material_group_name, material_group_code, create_by, create_time)
VALUES ('3c381050500d11eab77f2e728ce88125','一次性物料', 3, 'materialadmin', now());

INSERT INTO `material_group` (id, material_group_name, material_group_code, create_by, create_time)
VALUES ('45b067f4500d11eab77f2e728ce88125','螺丝钉', 4, 'materialadmin', now());

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

-- 银行
INSERT INTO `banks` VALUES ('招商银行股份有限公司北京华贸城支行','10011111011',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京海淀支行','10011111012',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京静安里支行','10011111013',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京德胜门支行','10011111014',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京清华园支行','10011111015',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京金融街支行','10011111016',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京方庄支行','10011111017',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京万泉河支行','10011111018',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京大运村支行','10011111019',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京首体支行','100111110110',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京建外大街支行','100111110111',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京万通中心支行','100111110112',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京望京西园支行','100111110113',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京万达广场支行','100111110114',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京东直门支行','100111110115',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京北苑路支行','100111110116',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京慧忠北里支行','100111110117',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京世纪城支行','100111110118',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京朝外大街支行','100111110119',11,'北京市',1101,'北京市','招商银行',1001),('招商银行股份有限公司北京望京支行','100111110120',11,'北京市',1101,'北京市','招商银行',1001);