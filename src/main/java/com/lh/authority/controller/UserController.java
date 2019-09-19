package com.lh.authority.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.lh.authority.dto.UserDto;
import com.lh.authority.model.*;
import com.lh.authority.model.InPutParam.UserInPutPara;
import com.lh.authority.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import lh.model.ResultVOPageTotal;
import lh.toolclass.LhGetPinyYinClass;
import lh.units.ResultStruct;
import model.TotalValueClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

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
    @Autowired
    Gson gson;

    @PostMapping("/getZone")
    public boolean getZone() throws FileNotFoundException {
        Gson gson = new Gson();
        String fileName = "D:\\BaiduNetdiskDownload\\cityTown.json";
        File file = new File(fileName);
        if (file.exists()) {
            JsonParser parser = new JsonParser();
            FileReader fileReader = new FileReader(fileName);
            JsonArray jsonArray = parser.parse(fileReader).getAsJsonArray();
            int classIndex;
            int province = 1;
            for (JsonElement item :
                    jsonArray) {
                classIndex = 1;
                ZoneModel zoneModel = gson.fromJson(item, ZoneModel.class);
                System.out.print("省(" + province + ") ");
                System.out.println("classIndex:" + classIndex + "," + "paraId:" + "root" + ":" + zoneModel.getValue() + "," + zoneModel.getLabel()+ "," + LhGetPinyYinClass.getPingYin(zoneModel.getLabel()));

                String cityChildren = gson.toJson(zoneModel.getChildren());
                if (!cityChildren.equals("null")) {
                    JsonArray jsonArrayCity = parser.parse(cityChildren).getAsJsonArray();
                    int cityCounter = 1;
                    for (JsonElement city :
                            jsonArrayCity) {
                        classIndex = 2;
                        ZoneModelCity zoneModelCity = gson.fromJson(city, ZoneModelCity.class);
                        System.out.print("  市(" + cityCounter + ") ");
                        System.out.println("classIndex:" + classIndex + "," + "paraId:" + zoneModel.getValue() + ":" + zoneModelCity.getValue() + "," + zoneModelCity.getLabel() + "," + LhGetPinyYinClass.getPingYin(zoneModelCity.getLabel()));

                        String areaChildren = gson.toJson(zoneModelCity.getChildren());
                        if (!areaChildren.equals("null")) {
                            JsonArray jsonArrayArea = parser.parse(areaChildren).getAsJsonArray();
                            int areaCounter = 1;
                            for (JsonElement area :
                                    jsonArrayArea) {
                                classIndex = 3;
                                ZoneModelArea zoneModelArea = gson.fromJson(area, ZoneModelArea.class);
                                System.out.print("    区(" + areaCounter + ") ");
                                System.out.println("classIndex:" + classIndex + "," + "paraId:" + zoneModelCity.getValue() + ":" + zoneModelArea.getValue() + "," + zoneModelArea.getLabel()+ "," + LhGetPinyYinClass.getPingYin(zoneModelArea.getLabel()));

                                String streetChildren = gson.toJson(zoneModelArea.getChildren());
                                if (!streetChildren.equals("null")) {
                                    JsonArray jsonArrayStreet = parser.parse(streetChildren).getAsJsonArray();
                                    int streetCounter = 1;
                                    for (JsonElement street :
                                            jsonArrayStreet) {
                                        classIndex = 4;
                                        ZoneModelStreet zoneModelStreet = gson.fromJson(street, ZoneModelStreet.class);
                                        System.out.print("      街(" + streetCounter + ") ");
                                        System.out.println("classIndex:" + classIndex + "," + "paraId:" + zoneModelArea.getValue() + ":" + zoneModelStreet.getValue() + "," + zoneModelStreet.getLabel()+ "," + LhGetPinyYinClass.getPingYin(zoneModelStreet.getLabel()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    /**
     * 得到UserList
     *
     * @param id 表user,字段名id:主键
     * @return 返回UserList，根据useName
     */
    @ApiOperation(value = "得到getUserListTotal", notes = "返回UserList，根据useName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "当前页数", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int")
    })
    @PostMapping("/getUserListTotal")
    public ResultVOPageTotal getUserListTotal(@RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "page", defaultValue = "-1") int page
            , @RequestParam(value = "limit", defaultValue = "-1") int limit) {
        PageHelper.startPage(page, limit);
        List<User> userList = userService.getUserList(id);
        PageInfo pageInfo = new PageInfo<>(userList, limit);

        LinkedHashMap userListTotal = userService.getUserListTotal(id);
        List<TotalValueClass> linkedHashMap = new ArrayList<>();
        if (userListTotal != null) {
            Iterator iterator = userListTotal.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry next = (Map.Entry) iterator.next();
                switch (next.getKey().toString()) {
                    case "counter":
                        AddTotal(next, linkedHashMap, (byte) 2);
                        break;
                    case "age1":
                        AddTotal(next, linkedHashMap, (byte) 3);
                        break;
                    case "age2":
                        AddTotal(next, linkedHashMap, (byte) 1);
                        break;
                    default:
                        break;
                }
            }
        }
        return ResultStruct.successPageTotal(userList, pageInfo.getPageNum()
                , pageInfo.getPageSize(), pageInfo.getTotal(), linkedHashMap);
    }

    private void AddTotal(Map.Entry next, List<TotalValueClass> linkedHashMap, byte i) {
        TotalValueClass totalValueClass = new TotalValueClass();
        totalValueClass.setValue(next.getValue() == null ? 0 : next.getValue().toString().replace(",", ""));
        totalValueClass.setSite(i);
        linkedHashMap.add(totalValueClass);
    }

    /**
     * 得到UserList
     *
     * @param id 表user,字段名id:主键
     * @return 返回UserList，根据useName
     */
    @ApiOperation(value = "得到UserList", notes = "返回UserList，根据useName")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "当前页数", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int")
    })
    @PostMapping("/getUserList")
    public List<User> getUserList(@RequestParam(value = "id", required = false) String id
            , @RequestParam(value = "page", defaultValue = "-1") int page
            , @RequestParam(value = "limit", defaultValue = "-1") int limit
            , @RequestParam(value = "useId", required = false) String useId
            , @RequestParam(value = "useType", required = false) String useType
            , @RequestParam(value = "clientType", required = false) String clientType) {
//        PageHelper.startPage(page, limit);
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(String.format("%d", i));
            user.setAge(i + 10);
            user.setSex(i + 100);
            user.setUserName(String.format("Name%d", i));
            userList.add(user);
        }
//        List<User> userList = userService.getUserList(id);
//        PageInfo pageInfo = new PageInfo<>(userList, limit);

//        LinkedHashMap userListTotal = userService.getUserListTotal(id);
//        LinkedHashMap<String, TotalValueClass> linkedHashMap = new LinkedHashMap<>();
//        if (userListTotal != null) {
//            Iterator iterator = userListTotal.entrySet().iterator();
//            byte i = 1;
//            while (iterator.hasNext()) {
//                Map.Entry next = (Map.Entry) iterator.next();
//                TotalValueClass totalValueClass = new TotalValueClass();
//                totalValueClass.setValue(next.getValue() == null ? 0 : next.getValue().toString().replace(",", ""));
//                totalValueClass.setSite(i++);
//                linkedHashMap.put(next.getKey().toString(), totalValueClass);
//            }
//        }

        ResultVO success = ResultStruct.success(userList);
//        ResultVOPage resultVOPage = ResultStruct.successPage(userList, pageInfo.getPageNum()
//                , pageInfo.getPageSize(), pageInfo.getTotal());
//        ResultVOTotal resultVOTotal = ResultStruct.successTotal(userList, linkedHashMap);
//        ResultVOPageTotal resultVOPageTotal = ResultStruct.successPageTotal(userList, pageInfo.getPageNum()
//                , pageInfo.getPageSize(), pageInfo.getTotal(), linkedHashMap);
//        return ResultStruct.success(userList);
        return userList;
//        return ResultStruct.successPageTotal(userList, pageInfo.getPageNum()
//                , pageInfo.getPageSize(), pageInfo.getTotal(), linkedHashMap);
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