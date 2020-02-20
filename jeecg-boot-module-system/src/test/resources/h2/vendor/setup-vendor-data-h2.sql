-- 供应商
INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('03290ba50c8d4cbc9b5f28ac4af51e1d','供应商001', '供应商001名称', '供应商001联系人', 'a0b70f81423141cd8bb2d57b2e6bbab1', '供应商001联系人身份证', '供应商001电话', '供应商001社会信用代码', '供应商001纳税人资格', '供应商001营业执照号码', '供应商001税务登记号', 'vendoradmin', now());

INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('ab67937b1f4444d68eb984bf814434cc','供应商002', '供应商002名称', '供应商002联系人', '3fef33a8c7094fdca53a78b96228aa4c', '供应商002联系人身份证', '供应商002电话', '供应商002社会信用代码', '供应商002纳税人资格', '供应商002营业执照号码', '供应商002税务登记号', 'vendoradmin', now());

INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('1729ec0c8da047cfbe895605d8ef1593','供应商003', '供应商003名称', '供应商003联系人', '662e256ad84742dfb708573e8a3ea92e', '供应商003联系人身份证', '供应商003电话', '供应商003社会信用代码', '供应商003纳税人资格', '供应商003营业执照号码', '供应商003税务登记号', 'vendoradmin', now());

INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('d81a892a00cb43679d7860c69fdab62f','供应商004', '供应商004名称', '供应商004联系人', 'a0b70f81423141cd8bb2d57b2e6bbab1', '供应商004联系人身份证', '供应商004电话', '供应商004社会信用代码', '供应商004纳税人资格', '供应商004营业执照号码', '供应商004税务登记号', 'vendoradmin', now());

INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('6b3acb4d499b45eabb2ac857e650db11','供应商005', '供应商005名称', '供应商005联系人', 'a0b70f81423141cd8bb2d57b2e6bbab1', '供应商005联系人身份证', '供应商005电话', '供应商005社会信用代码', '供应商005纳税人资格', '供应商005营业执照号码', '供应商005税务登记号', 'vendoradmin', now());

-- 银行账户
INSERT INTO `bank_account` (id, bank_id, sub_branch_id, bank_account_name, bank_account,create_by, create_time)
VALUES ('00b1e873c39d46cd9eab3575299d9b75','1001', '10011111011', '测试银行账户004', '44444444444444444', 'vendoradmin', now());

INSERT INTO `bank_account` (id, bank_id, sub_branch_id, bank_account_name, bank_account, create_by, create_time)
VALUES ('f966ddc237ed4c6888e3b029cbd3b6b8','1001', '10011111012', '测试银行账户005', '55555555555555555', 'vendoradmin', now());

INSERT INTO `bank_account` (id, bank_id, sub_branch_id, bank_account_name, bank_account, create_by, create_time)
VALUES ('e65dc6f83cb1469b9b1d410cf2d6d202','1001', '10011111013', '测试银行账户006', '66666666666666666', 'vendoradmin', now());

-- 供应商-银行账户关系
INSERT INTO `partner_bankaccount_rel` (id, partner_id, bank_account_id, partner_type, create_by, create_time)
VALUES ('64e0a142121148b5811230e02f6f009c','6b3acb4d499b45eabb2ac857e650db11', '00b1e873c39d46cd9eab3575299d9b75', 'K', 'vendoradmin', now());

INSERT INTO `partner_bankaccount_rel` (id, partner_id, bank_account_id, partner_type, create_by, create_time)
VALUES ('76caa8d117854c4d84c3ca0aea90d7c8','6b3acb4d499b45eabb2ac857e650db11', 'f966ddc237ed4c6888e3b029cbd3b6b8', 'K', 'vendoradmin', now());

INSERT INTO `partner_bankaccount_rel` (id, partner_id, bank_account_id, partner_type, create_by, create_time)
VALUES ('ef7dfb57b53d472a900d572a9579c70e','6b3acb4d499b45eabb2ac857e650db11', 'e65dc6f83cb1469b9b1d410cf2d6d202', 'K', 'vendoradmin', now());