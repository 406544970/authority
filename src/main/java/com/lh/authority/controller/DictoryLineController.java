package com.lh.authority.controller;

import com.lh.authority.model.DictoryLine;
import com.lh.authority.service.DictoryLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：陈盼
 * @create 2019-09-05 15:27
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/dictoryLineController")
@Api(value = "返回数据字典", description = "数据字典")
public class DictoryLineController {
    @Autowired
    DictoryLineService dictoryLineService;

    /**
     * 返回线性数据字典，方法ID：SE20190905152527211
     *
     * @param signName 表inf_dictionary,字段名signName:标识
     * @return 数据字典LIST
     */
    @ApiOperation(value = "返回线性数据字典", notes = "数据字典LIST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "signName", value = "标识", dataType = "String", required = true)
    })
    @PostMapping("/getDictoryList")
    public List<DictoryLine> getDictoryList(@RequestParam(value = "signName") String signName) {
        signName = signName == null ? signName : signName.trim();
        return dictoryLineService.getDictoryList(signName);
    }
}
