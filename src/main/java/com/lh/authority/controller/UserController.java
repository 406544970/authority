package com.lh.authority.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.authority.dto.UserDto;
import com.lh.authority.model.InPutParam.UserInPutPara;
import com.lh.authority.model.User;
import com.lh.authority.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVOPageTotal;
import lh.units.ResultStruct;
import model.TotalValueClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：梁昊，后端工程师：杨凯，前端工程师：陈盼
 * @create 2019-08-10 22:02
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/user")
@Api(value = "得到User列表", description = "根据密码123右Like，得到User列表")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 得到UserList
     *
     * @param id 表user,字段名id:主键
     * @return 返回UserList，根据useName
     */
    @ApiOperation(value = "得到UserList", notes = "返回UserList，根据useName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String"),
            @ApiImplicitParam(name = "pageNo", value = "当前页数", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int")
    })
//    @CrossOrigin(origins = "*")
    @PostMapping("/getUserList")
    public ResultVOPageTotal getUserList(@RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "pageNo", defaultValue = "1") int pageNo
            , @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> userList = userService.getUserList(id);
        PageInfo pageInfo = new PageInfo<>(userList, pageSize);

        LinkedHashMap userListTotal = userService.getUserListTotal(id);
        LinkedHashMap<String, TotalValueClass> linkedHashMap = new LinkedHashMap<>();
        if (userListTotal != null) {
            Iterator iterator = userListTotal.entrySet().iterator();
            byte i = 1;
            while (iterator.hasNext()) {
                Map.Entry next = (Map.Entry) iterator.next();
                TotalValueClass totalValueClass = new TotalValueClass();
                totalValueClass.setValue(next.getValue() == null ? 0 : next.getValue().toString().replace(",", ""));
                totalValueClass.setSite(i++);
                linkedHashMap.put(next.getKey().toString(), totalValueClass);
            }
        }
        return ResultStruct.successPageTotal(userList, pageInfo.getPageNum()
                , pageInfo.getPageSize(), pageInfo.getTotal(), linkedHashMap);
    }

    @ApiOperation(value = "得到UserListTotal", notes = "返回LinkHashMap，根据useName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String")
    })
    @CrossOrigin
    @PostMapping("/getUserListTotal")
    public LinkedHashMap<String, TotalValueClass> getUserListTotal(@RequestParam(value = "id", required = false) String id) {
        return null;
    }

    /**
     * 得到UserList2
     *
     * @param mainId 表user,原字段名id,现字段名mainId:主键
     * @return 返回UserList，根据useName
     */
    @ApiOperation(value = "得到UserList2", notes = "返回UserList，根据useName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mainId", value = "主键", required = true, dataType = "String")
    })
    @PostMapping("/getUserList2")
    public List<UserDto> getUserList2(@RequestParam(value = "mainId") String mainId) {

//      请在这里写逻辑代码

        return userService.getUserList2(mainId);
    }

    /**
     * 得到UserList3
     *
     * @param mainId   表user,原字段名id,现字段名mainId:主键
     * @param sub2Id   表user,原字段名id,现字段名sub2Id:主键
     * @param pageNo   当前页数
     * @param pageSize 当前条数
     * @return 返回UserList，根据useName
     */
    @ApiOperation(value = "得到UserList3", notes = "返回UserList，根据useName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mainId", value = "主键", dataType = "String"),
            @ApiImplicitParam(name = "sub2Id", value = "主键", dataType = "String", required = true),
            @ApiImplicitParam(name = "pageNo", value = "当前页数", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int")
    })
    @PostMapping("/getUserList3")
    public List<UserDto> getUserList3(@RequestParam(value = "mainId", required = false) String mainId
            , @RequestParam(value = "sub2Id") String sub2Id
            , @RequestParam(value = "pageNo", defaultValue = "1") int pageNo
            , @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        UserInPutPara userInPutPara = new UserInPutPara();
        userInPutPara.setMainId(mainId);
        userInPutPara.setSub2Id(sub2Id);

        System.out.println(pageNo);
        System.out.println(pageSize);

        PageHelper.startPage(pageNo, pageSize);
        return userService.getUserList3(userInPutPara);
    }
}