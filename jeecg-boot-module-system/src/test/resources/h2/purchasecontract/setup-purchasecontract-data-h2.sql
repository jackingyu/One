-- 物料
INSERT INTO `material` (id, material_name, material_description, material_code, material_group_code, one_time_flag, create_by, create_time)
VALUES ('6ad7e77fd7b6418db75a6d20d5da2777','purchase_contract_m_001', 'purchase_contract_m_001_d', 'PM001', 1, 0, 'materialadmin', now());

INSERT INTO `material` (id, material_name, material_description, material_code, material_group_code, one_time_flag, create_by, create_time)
VALUES ('ecddb00b47d94ad0a5b7c9282a3664f6','purchase_contract_m_002', 'purchase_contract_m_002_d', 'PM002', 2, 0, 'materialadmin', now());
-- 供应商
INSERT INTO `vendor` (id, vendor_code, vendor_name, contact_person, vendor_group_code, contact_person_id, contact_phone, social_credit_code, tax_subject, business_license, tax_code, create_by, create_time)
VALUES ('603c6b21dd484511814484d08267ae63','purchase_vendor_v_001', 'purchase_vendor_001_name', 'purchase_vendor_001_cp', 1, 'purchase_vendor_001_cpi', 'purchase_vendor_001_cp', 'purchase_vendor_001_scc', 'purchase_vendor_001_ts', 'purchase_vendor_001_bl', 'purchase_vendor_001_tc', 'vendoradmin', now());
-- 公司
INSERT INTO `company` (id, company_code, company_name, create_by, create_time)
VALUES ('3e574a585c5043f6a1b4fed124f6e16b','purchase_company_001', 'purchase_company_001_name', 'partneradmin', now());
-- 项目
INSERT INTO `project`(`id`, `company_id`, `project_name`, `comments`, `create_by`, `create_time`)
VALUES ('e7d501cdc0a7442b96383f1b63b97ff3', '3e574a585c5043f6a1b4fed124f6e16b','purchase_project_001','purchase_project_001_comment', 'projectadmin', now());
