-- 供应商
INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('03290ba50c8d4cbc9b5f28ac4af51e1d','vendor001', 'vendor001name', 'vendor001cp', 'a0b70f81423141cd8bb2d57b2e6bbab1', 'vendor001cpid', 'vendor001phone', 'vendor001scc', 'vendor001ts', 'vendor001bl', 'vendor001tc', 'vendoradmin', now());

INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('ab67937b1f4444d68eb984bf814434cc','vendor002', 'vendor002name', 'vendor002cp', '3fef33a8c7094fdca53a78b96228aa4c', 'vendor002cpid', 'vendor002phone', 'vendor002scc', 'vendor002ts', 'vendor002bl', 'vendor002tc', 'vendoradmin', now());

INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('1729ec0c8da047cfbe895605d8ef1593','vendor003', 'vendor003name', 'vendor003cp', '662e256ad84742dfb708573e8a3ea92e', 'vendor003cpid', 'vendor003phone', 'vendor003scc', 'vendor003ts', 'vendor003bl', 'vendor003tc', 'vendoradmin', now());

INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('d81a892a00cb43679d7860c69fdab62f','vendor004', 'vendor004name', 'vendor004cp', 'a0b70f81423141cd8bb2d57b2e6bbab1', 'vendor004cpid', 'vendor004phone', 'vendor004scc', 'vendor004ts', 'vendor004bl', 'vendor004tc', 'vendoradmin', now());

INSERT INTO `vendor` (id, code, name, contact_person, vendor_group_id, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('6b3acb4d499b45eabb2ac857e650db11','vendor005', 'vendor005name', 'vendor005cp', 'a0b70f81423141cd8bb2d57b2e6bbab1', 'vendor005cpid', 'vendor005phone', 'vendor005scc', 'vendor005ts', 'vendor005bl', 'vendor005tc', 'vendoradmin', now());

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
