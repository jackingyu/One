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

-- 公司
INSERT INTO `company` (id, company_code, company_name, create_by, create_time)
VALUES ('eaa2aab69d74443ebc025ee4fd76b882','测试公司001', '测试公司001名称', 'partneradmin', now());

INSERT INTO `company` (id, company_code, company_name, create_by, create_time)
VALUES ('c4c5b99daa35489abd0ea322b0893891','测试公司002', '测试公司002名称', 'partneradmin', now());

INSERT INTO `company` (id, company_code, company_name, create_by, create_time)
VALUES ('7f836ea97c2e4375a1cc025101f51fd7','测试公司003', '测试公司003名称', 'partneradmin', now());

INSERT INTO `company` (id, company_code, company_name, create_by, create_time)
VALUES ('73ae5fa2d59f4240acf224de80c82886','测试公司004', '测试公司004名称', 'partneradmin', now());

INSERT INTO `company` (id, company_code, company_name, create_by, create_time)
VALUES ('f74b9926bb3946ba8ef513fd79e8bb91','测试公司005', '测试公司005名称', 'partneradmin', now());

-- 银行账户
INSERT INTO `bank_account` (id, bank_id, sub_branch_id, bank_account_name, bank_account, create_by, create_time)
VALUES ('8f1556b40937492bb1fbeeba086fc110','1001', '10011111011', '测试银行账户001', '11111111111111111', 'partneradmin', now());

INSERT INTO `bank_account` (id, bank_id, sub_branch_id, bank_account_name, bank_account, create_by, create_time)
VALUES ('c2c755524e6c40fcba1b8632d6c311b0','1001', '10011111012', '测试银行账户002', '22222222222222222', 'partneradmin', now());

INSERT INTO `bank_account` (id, bank_id, sub_branch_id, bank_account_name, bank_account, create_by, create_time)
VALUES ('f24c34579de64f13825d47d0319a1a3f','1001', '10011111013', '测试银行账户003', '33333333333333333', 'partneradmin', now());

-- 合作伙伴-银行账户关系
INSERT INTO `partner_bankaccount_rel` (id, partner_id, bank_account_id, partner_type, create_by, create_time)
VALUES ('0c1adefea163407cbd75f8d1810fbb23','eaa2aab69d74443ebc025ee4fd76b882', '8f1556b40937492bb1fbeeba086fc110', 1, 'partneradmin', now());

INSERT INTO `partner_bankaccount_rel` (id, partner_id, bank_account_id, partner_type, create_by, create_time)
VALUES ('bf1c5cac91ad4d98a1070deb48cc1e5b','eaa2aab69d74443ebc025ee4fd76b882', 'c2c755524e6c40fcba1b8632d6c311b0', 1, 'partneradmin', now());

INSERT INTO `partner_bankaccount_rel` (id, partner_id, bank_account_id, partner_type, create_by, create_time)
VALUES ('5064ab3a049b4522b6571fab4ba330b7','eaa2aab69d74443ebc025ee4fd76b882', 'f24c34579de64f13825d47d0319a1a3f', 1, 'partneradmin', now());