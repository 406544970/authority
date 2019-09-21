package com.lh.authority.controller;

import com.lh.authority.model.InPutParam.PerInPutParam;
import com.lh.authority.model.InPutParam.PerUpdateInPutParam;
import com.lh.authority.service.PerService;
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
 * @author ：hj，后端工程师：hj，前端工程师：hj
 * @create 2019-09-12 21:49
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/perController")
@Api(value = "测试增加功能", description = "第一次测试")
public class PerController {
    @Autowired
    PerService perService;

    /**
     * 测试增加员工，方法ID：SE20190910212446127
     *
     * @param name    姓名
     * @param sex     性别（0：男、1：女）
     * @param age     年龄
     * @param classNo 班级序号
     * @return 员工主键
     */
    @ApiOperation(value = "测试增加员工", notes = "员工主键")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String")
            , @ApiImplicitParam(name = "sex", value = "性别（0：男、1：女）", dataType = "int")
            , @ApiImplicitParam(name = "age", value = "年龄", dataType = "int", required = true)
            , @ApiImplicitParam(name = "classNo", value = "班级序号", dataType = "int", required = true)
    })
    @PostMapping("/insertIntoPerson")
    public String insertIntoPerson(@RequestParam(value = "name", required = false) String name
            , @RequestParam(value = "sex", required = false, defaultValue = "10") int sex
            , @RequestParam(value = "age", defaultValue = "100") int age
            , @RequestParam(value = "classNo", defaultValue = "1") int classNo) {
        name = name == null ? name : name.trim();

        PerInPutParam perInPutParam = new PerInPutParam();
        String mainKey = String.format("some%d", new Date().getTime());//这里引用架包中的生成主键方法
        perInPutParam.setId(mainKey);
        perInPutParam.setName(name);
        perInPutParam.setSex(sex);
        perInPutParam.setAge(age);
        perInPutParam.setClassNo(classNo);
        int repetitionCount = perService.insertIntoPersonBeforeCheck(perInPutParam);
        System.out.println("repetitionCount:" + repetitionCount);
        if (repetitionCount > 0)
            return null;
        int resultCount = perService.insertIntoPerson(perInPutParam);
        System.out.println("resultCount:" + resultCount);
        if (resultCount > 0)
            return perInPutParam.getId();
        else
            return null;
    }
    /**
     * 更新方法，方法ID：SE20190915004050679
     *
     * @param perIdWhere 外键, Where字段
     * @param subjectName 科目名称
     * @param subjectNameWhere 科目名称, Where字段
     * @param achievement 成绩
     * @return 影响条件
     */
    @ApiOperation(value = "更新方法", notes = "影响条件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "perIdWhere", value = "外键", dataType = "String")
            , @ApiImplicitParam(name = "subjectName", value = "科目名称", dataType = "String", required = true)
            , @ApiImplicitParam(name = "subjectNameWhere", value = "科目名称", dataType = "String")
            , @ApiImplicitParam(name = "achievement", value = "成绩", dataType = "int", required = true)
    })
    @PostMapping("/updatePerson")
    public ResultVO updatePerson(@RequestParam(value = "perIdWhere", required = false) String perIdWhere
            , @RequestParam(value = "subjectName") String subjectName
            , @RequestParam(value = "subjectNameWhere", required = false) String subjectNameWhere
            , @RequestParam(value = "achievement") int achievement) {
        perIdWhere = perIdWhere == null ? perIdWhere : perIdWhere.trim();
        subjectName = subjectName == null ? subjectName : subjectName.trim();
        subjectNameWhere = subjectNameWhere == null ? subjectNameWhere : subjectNameWhere.trim();

        PerUpdateInPutParam perUpdateInPutParam = new PerUpdateInPutParam();
        perUpdateInPutParam.setPerIdWhere(perIdWhere);
        perUpdateInPutParam.setSubjectName(subjectName);
        perUpdateInPutParam.setSubjectNameWhere(subjectNameWhere);
        perUpdateInPutParam.setAchievement(achievement);
        int updateCount = perService.updatePerson(perUpdateInPutParam);
        if (updateCount > 0)
            return ResultStruct.success(updateCount);
        else
            return ResultStruct.error("修改失败", ResultVO.class);
    }

}
