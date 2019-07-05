package com.lh.authority.controller;

import com.lh.VO.ResultVO;
import com.lh.authority.dto.MyPage;
import com.lh.authority.model.*;
import com.lh.authority.service.SystemService;
import com.lh.authority.unit.RedisOperator;
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

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    RedisOperator redisOperator;

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
    public ResultVO selectMySystemNameList(@RequestParam(value = "id") String id) {
        MySystemPara mySystemPara = new MySystemPara();
        mySystemPara.setId(id);
//        List<MySystem> mySystems = ;
        return ResultUtils.success(systemService.selectMySystemNameList(mySystemPara));
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
    @PostMapping("/insertMongodb")
    public boolean insertMongodb(){
        return systemService.insertMongodb();
    }

    @PostMapping("/insertPatchToMongodb")
    public int insertPatchToMongodb(){
        return systemService.insertPatchData();
    }

    @PostMapping("/deleteMongodb")
    public int deleteMongodb(){
        return systemService.deleteMongodb();
    }
    @PostMapping("/updateByPrimaryKeyForJobName")
    public int updateByPrimaryKeyForJobName(@RequestParam(value = "id") String id
            , @RequestParam(value = "jobName") String jobName) {
        OperatorAll operatorAll = new OperatorAll();
        operatorAll.setId(id);
        operatorAll.setJobName(jobName);
        return systemService.updateByPrimaryKeyForJobName(operatorAll);
    }
    @PostMapping("/getLogModelList")
    public ResultVO getLogModelList() throws ClassNotFoundException {
        return systemService.getLogModelList();
    }

    @PostMapping("/getLogModelListNew")
    public ResultVO getLogModelListNew() throws ClassNotFoundException, ParseException {
        return systemService.getLogModelListNew();
    }

    /**
     * 登录方法
     *
     * @param num 工号(用工号作为登录用户名)
     * @return 返回状态
     */
    @ApiOperation(value = "登录方法,管理员、BS", notes = "返回状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "工号(用工号作为登录用户名)", required = true, dataType = "String"),
            @ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String")
    })
    @PostMapping("/useLogOfManagerInBS")
    public ResultVO useLogOfManagerInBS(@RequestParam(value = "num") String num
            , @RequestParam(value = "passWord") String passWord) {
        return useLog(num, passWord, "manager", "BS");
    }

    private ResultVO useLog(String num, String passWord, String useType, String clientType) {
//      请在这里写逻辑代码
        OperatorAll operatorAll = systemService.useLog(num);
        if (operatorAll == null) {
            return ResultUtils.error("无此用户!");
        }
        if (operatorAll.getStopSign()) {
            return ResultUtils.error("此用户已被停用！");
        }
        if (!operatorAll.getPwd().equals(MD5Utils.getMd5(passWord))) {
            return ResultUtils.error("密码错误！");
        }
        LogModel logModel = new LogModel();
        logModel.setUseId(operatorAll.getId());
        logModel.setAccessToken(UUID.randomUUID().toString());
        logModel.setUseType(useType);
        logModel.setClientType(clientType);
        logModel.setTimeOut(redisOperator.getTimeUnit());
        if (redisOperator.writeIntoToken(
                logModel.getClientType()
                , logModel.getUseId()
                , logModel.getUseType()
                , logModel.getAccessToken()))
            return ResultUtils.success(logModel);
        else
            return ResultUtils.error();
    }
}
