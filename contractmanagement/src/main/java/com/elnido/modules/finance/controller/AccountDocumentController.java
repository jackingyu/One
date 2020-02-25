package com.elnido.modules.finance.controller;

import com.elnido.modules.finance.entity.AccountDocument;
import com.elnido.modules.finance.service.AccountDocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@Api(tags = "供应商仪表盘")
@RestController
@RequestMapping("/finance/accountdocument")
public class AccountDocumentController {

    @Resource
    private AccountDocumentService accountDocumentService;

    @PostMapping
    @ApiOperation(value = "财务抛账", notes = "财务抛账")
    public void postAccountDocuments(@RequestBody AccountDocument accountDocument){
        accountDocumentService.save(accountDocument);
    }
}
