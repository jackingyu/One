package com.elnido.modules.masterdata.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.elnido.modules.masterdata.entity.BankAccount;
import com.elnido.modules.masterdata.entity.Vendor;
import com.elnido.modules.masterdata.entity.VendorGroup;
import com.elnido.modules.masterdata.enums.PartnerTypeEnum;
import com.elnido.modules.masterdata.model.VendorPage;
import com.elnido.modules.masterdata.service.BankAccountService;
import com.elnido.modules.masterdata.service.VendorGroupService;
import com.elnido.modules.masterdata.service.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

import static com.elnido.modules.masterdata.Constants.I18N.General.*;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "银行账户(公司、供应商、客户)维护")
@RestController
@RequestMapping("/masterdata/bankaccounts/")
public class BankAccountController {

    @Resource
    private BankAccountService bankAccountService;

    @Resource
    private MessageUtils messageUtils;

    @PutMapping()
    @ApiOperation(value = "银行账户表-更新银行账户", notes = "银行账户-更新银行账户")
    public Result<?> updateBankAccount(@RequestBody BankAccount bankAccount) {
        Result<Boolean> result = new Result<>();
        if (Objects.isNull(bankAccount) || StringUtils.isBlank(bankAccount.getId())) {
            String domain = messageUtils.get(BANK_ACCOUNT_DOMAIN_NAME);
            String field = messageUtils.get(ID_FIELD_NAME);

            String template = messageUtils.get(SHOULD_NOT_NULL);

            String errorMsg = MessageFormat.format(template, domain + ":" + field);
            return result.error500(errorMsg);
        }

        boolean updated = bankAccountService.updateById(bankAccount);
        result.setResult(updated);
        result.setSuccess(updated);
        return result;
    }
}
