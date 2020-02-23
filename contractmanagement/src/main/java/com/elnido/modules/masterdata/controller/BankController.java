package com.elnido.modules.masterdata.controller;

import com.elnido.modules.masterdata.service.BankService;
import com.elnido.modules.util.ElnidoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author baogang
 */
@Slf4j
@Api(tags = "银行维护")
@RestController
@RequestMapping("/masterdata/banks")
public class BankController {

    @Resource
    private BankService bankService;

    @GetMapping()
    @ApiOperation(value = "银行表-查询所有总行", notes = "银行-银行总行")
    public Result<List<Map<String, Object>>> findAllBank() {
        Result<List<Map<String, Object>>> result = new Result<>();
        List<Map<String, Object>> allBanks = bankService.findAllBanks();
        result.setResult(allBanks);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/{bankId}")
    @ApiOperation(value = "银行表-根据总行ID查询分行信息", notes = "银行-根据总行查询分行")
    public Result<List<Map<String, Object>>> findSubbranches(@PathVariable String bankId,
                                              @RequestParam(value = "subbranchName") String subbranchName) {
        Result<List<Map<String, Object>>> result = new Result<>();
        List<Map<String, Object>> subbranches = bankService.findSubbranchesByBankIdAndName(bankId, ElnidoUtil.handleJeecgFuzzySearchString(subbranchName));
        result.setResult(subbranches);
        result.setSuccess(true);
        return result;
    }
}
