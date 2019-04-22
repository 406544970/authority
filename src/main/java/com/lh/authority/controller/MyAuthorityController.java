package com.lh.authority.controller;

import com.lh.authority.dto.MyPage;
import com.lh.authority.model.MySystem;
import com.lh.authority.model.MySystemPara;
import com.lh.authority.model.MySystemParaAll;
import com.lh.authority.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function
 * @editLog
 */
@EnableEurekaClient
@RestController
@RequestMapping(value = "/authority")
@Api(value = "权限控制层", description = "权限控制粘子层")
public class MyAuthorityController {
    @Autowired
    SystemService systemService;

    /**
     * 得到指定用户子系统权限列表
     *
     * @param id 用户ID
     * @return 子系统权限列表
     */
    @ApiOperation(value = "得到指定用户子系统权限列表", notes = "子系统权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = " 用户ID", required = true, dataType = "String")
    })
    @PostMapping("/selectMySystemNameList")
    public List<MySystem> selectMySystemNameList(@RequestParam(value = "id") String id) {
        MySystemPara mySystemPara = new MySystemPara();
        mySystemPara.setId(id);
        return systemService.selectMySystemNameList(mySystemPara);
    }

    /**
     * 得到指定用户有没有子系统权限
     *
     * @param id 用户ID
     * @return false:无权限，否则，有；
     */
    @ApiOperation(value = "得到指定用户子系统权限列表", notes = "子系统权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = " 用户ID", required = true, dataType = "String")
    })
    @PostMapping("/selectMySystemHave")
    public boolean selectMySystemHave(@RequestParam(value = "id") String id) {
        MySystemPara mySystemPara = new MySystemPara();
        mySystemPara.setId(id);
        List<MySystem> mySystems = systemService.selectMySystemNameList(mySystemPara);
        if (mySystems != null) {
            return mySystems.isEmpty() ? false : true;
        } else
            return false;
    }

    /**
     * 得到指定用户指定子系统页面权限列表
     *
     * @param id         用户ID
     * @param systemName 子系统名称
     * @return 指定子系统页面权限列表
     */
    @ApiOperation(value = "得到指定用户指定子系统页面权限列表", notes = "指定子系统页面权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = " 用户ID", required = true, dataType = "String")
            , @ApiImplicitParam(name = "systemName", value = " 子系统名称", required = true, dataType = "String")
    })
    @PostMapping("/selectMyPageAuthorityList")
    public MyPage selectMyPageAuthorityList(@RequestParam(value = "id") String id
            , @RequestParam(value = "systemName") String systemName) {
        MySystemParaAll mySystemParaAll = new MySystemParaAll();
        mySystemParaAll.setId(id);
        mySystemParaAll.setSystemName(systemName);
        return systemService.selectMyPageAuthorityList(mySystemParaAll);
    }
}
