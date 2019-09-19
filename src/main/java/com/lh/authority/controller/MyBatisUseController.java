package com.lh.authority.controller;

import com.lh.authority.model.MyBatisUseModel;
import com.lh.authority.service.MyBatisUseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-19 12:40
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/myBatisUseController")
@Api(value = "用户", description = "用户")
public class MyBatisUseController {
    @Autowired
    MyBatisUseService myBatisUseService;

    /**
     * 用户登录，方法ID：SE20190919123026354
     *
     * @param mobile 表sys_myBatisUser,字段名mobile:登录手机号
     * @return 结构体
     */
    @ApiOperation(value = "用户登录", notes = "结构体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "登录手机号", dataType = "String", required = true),
            @ApiImplicitParam(name = "passWord", value = "登录密码", dataType = "String", required = true)
    })
    @PostMapping("/useLogByNameAndPassWord")
    public ResultVO useLogByNameAndPassWord(@RequestParam(value = "mobile") String mobile
            , @RequestParam(value = "passWord") String passWord) {
        mobile = mobile == null ? mobile : mobile.trim();
        MyBatisUseModel myBatisUseModel = myBatisUseService.useLogByNameAndPassWord(mobile);
        if (myBatisUseModel == null) {
            return ResultStruct.error("无此用户！", ResultVO.class);
        }
        if (myBatisUseModel.getStopSign()) {
            return ResultStruct.error("您的帐户已被停用！", ResultVO.class);
        }
        Date myDate = new Date();
        if (!(myBatisUseModel.getUseBegin().compareTo(myDate) > 0 && myBatisUseModel.getUseEnd().compareTo(myDate) < 0)) {
            return ResultStruct.error("您的帐户已过期！", ResultVO.class);
        }
        if (!passWord.equals(myBatisUseModel.getPassWord())) {
            return ResultStruct.error("密码错误！", ResultVO.class);
        }
        return ResultStruct.success(myBatisUseModel);
    }
}
