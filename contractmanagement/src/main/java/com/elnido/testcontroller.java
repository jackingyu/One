package com.elnido;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dlx")
@Api(tags="elnido接口")
public class testcontroller {


    @ApiOperation(value = "获取Demo数据列表", notes = "获取所有Demo数据列表")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<JSONObject> login(){
     return null;
    }
}
