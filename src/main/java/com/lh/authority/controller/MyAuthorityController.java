package com.lh.authority.controller;

import com.google.common.base.Supplier;
import com.lh.VO.ResultVO;
import com.lh.authority.dto.MyPage;
import com.lh.authority.model.MySystem;
import com.lh.authority.model.MySystemPara;
import com.lh.authority.model.MySystemParaAll;
import com.lh.authority.model.OperatorAll;
import com.lh.authority.service.SystemService;
import com.lh.enums.ResultCodeEnums;
import com.lh.tool.MD5Utils;
import com.lh.utils.ResultUtils;
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

    @PostMapping("/updateByPrimaryKeyForJobName")
    public int updateByPrimaryKeyForJobName(@RequestParam(value = "id") String id
            , @RequestParam(value = "jobName") String jobName) {
        OperatorAll operatorAll = new OperatorAll();
        operatorAll.setId(id);
        operatorAll.setJobName(jobName);
        return systemService.updateByPrimaryKeyForJobName(operatorAll);
    }

    /**
     * 登录方法
     *
     * @param num 工号(用工号作为登录用户名)
     * @return 返回状态
     */
    @ApiOperation(value = "登录方法", notes = "返回状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "工号(用工号作为登录用户名)", required = true, dataType = "String"),
            @ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String")
    })
    @PostMapping("/useLog")
    public ResultVO useLog(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord) {

//      请在这里写逻辑代码
        OperatorAll operatorAll = systemService.useLog(num);
        if (operatorAll == null) {
            return ResultUtils.error(ResultCodeEnums.ERROR.getCode(),"无此用户!");
        }
        if (operatorAll.getStopSign()) {
            return ResultUtils.error(ResultCodeEnums.ERROR.getCode(),"此用户已被停用！");
        }
        if (!operatorAll.getPwd().equals(MD5Utils.getMd5(passWord))) {
            return ResultUtils.error(ResultCodeEnums.ERROR.getCode(),"密码错误！");
        }
        return ResultUtils.success(operatorAll);
    }
}
