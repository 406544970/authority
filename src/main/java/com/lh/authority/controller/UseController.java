package com.lh.authority.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.authority.dto.UseDto;
import com.lh.authority.service.UseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVOPage;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：梁昊，后端工程师：录像昊，前端工程师：当当然
 * @create 2019-09-09 14:43
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/useController")
@Api(value = "测试代码生成器", description = "代码生成器描述")
public class UseController {
    @Autowired
    UseService useService;

    /**
     * 描述，方法ID：SE20190909144116865
     *
     * @param id 表sys_operator,字段名id:
     * @param page 当前页数
     * @param limit 每页条数
     * @return 返回值说明
     */
    @ApiOperation(value = "描述", notes = "返回值说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "", dataType = "String", required = true),
            @ApiImplicitParam(name = "page", value = "当前页数", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int")
    })
    @PostMapping("/getNewUseListPage")
    public ResultVOPage getNewUseListPage(@RequestParam(value = "id") String id
            , @RequestParam(value = "page", defaultValue = "1") int page
            , @RequestParam(value = "limit", defaultValue = "10") int limit) {
        id = id == null ? id : id.trim();

        PageHelper.startPage(page, limit);
        List<UseDto> useDtos = useService.getNewUseListPage(id);
        PageInfo pageInfo = new PageInfo<>(useDtos,limit);
        return ResultStruct.successPage(useDtos, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }


}
