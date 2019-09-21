package com.lh.authority.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.lh.authority.model.InPutParam.ZoneListInPutParam;
import com.lh.authority.model.*;
import com.lh.authority.service.ZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.toolclass.LhGetPinyYinClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


/**
 * @author ：梁昊，后端工程师：梁昊，前端工程师：梁昊
 * @create 2019-09-07 17:30
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/user")
@Api(value = "地区", description = "地区")
public class ZoneController {
    @Autowired
    ZoneService zoneService;
    @Autowired
    Gson gson;


    /**
     * 生成地区下拉框查询：省，方法ID：SE20190908141000883
     *
     * @return 下拉框数据
     */
    @ApiOperation(value = "生成地区下拉框查询：省", notes = "下拉框数据")
    @PostMapping("/getZoneListProvince")
    public List<ZoneListModel> getZoneListProvince() {
        return getZoneList(1, "root");
    }

    /**
     * 生成地区下拉框查询：市，方法ID：SE20190908141000883
     *
     * @return 下拉框数据
     */
    @ApiOperation(value = "生成地区下拉框查询：市", notes = "下拉框数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paraId", value = "父ID", dataType = "String", required = true)
    })
    @PostMapping("/getZoneListCity")
    public List<ZoneListModel> getZoneListCity(@RequestParam(value = "paraId") String paraId) {
        return getZoneList(2, paraId);
    }

    /**
     * 生成地区下拉框查询：区，方法ID：SE20190908141000883
     *
     * @return 下拉框数据
     */
    @ApiOperation(value = "生成地区下拉框查询：区", notes = "下拉框数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paraId", value = "父ID", dataType = "String", required = true)
    })
    @PostMapping("/getZoneListArea")
    public List<ZoneListModel> getZoneListArea(@RequestParam(value = "paraId") String paraId) {
        return getZoneList(3, paraId);
    }

    /**
     * 生成地区下拉框查询：街道，方法ID：SE20190908141000883
     *
     * @return 下拉框数据
     */
    @ApiOperation(value = "生成地区下拉框查询：街道", notes = "下拉框数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paraId", value = "父ID", dataType = "String", required = true)
    })
    @PostMapping("/getZoneListStreet")
    public List<ZoneListModel> getZoneListStreet(@RequestParam(value = "paraId") String paraId) {
        return getZoneList(4, paraId);
    }

    /**
     * @param classIndex 地区级别
     * @param paraId     父ID
     * @return 下拉框数据
     */
    private List<ZoneListModel> getZoneList(int classIndex, String paraId) {
        if (classIndex < 1 || classIndex > 4)
            return null;
        if (paraId == null || paraId.length() == 0)
            return null;

        paraId = paraId == null ? paraId : paraId.trim();

        ZoneListInPutParam zoneListInPutParam = new ZoneListInPutParam();
        zoneListInPutParam.setClassIndex(classIndex);
        zoneListInPutParam.setParaId(paraId);

        return zoneService.getZoneList(zoneListInPutParam);
    }

    /**
     * 加入单条地区信息，方法ID：SE20190907172421783
     *
     * @return 影响条数
     */
    @ApiOperation(value = "加入单条地区信息", notes = "影响条数")
    @PostMapping("/insertZoneAlone")
    public int insertZoneAlone() throws FileNotFoundException {
        int i = 0;

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
                ZoneInsertModel zoneInsertModel = makeObject(zoneModel.getValue(), zoneModel.getLabel(), getPinyYinMy(zoneModel.getLabel()), classIndex, "root");
                i += addZone(zoneInsertModel);

                String cityChildren = gson.toJson(zoneModel.getChildren());
                if (!cityChildren.equals("null")) {
                    JsonArray jsonArrayCity = parser.parse(cityChildren).getAsJsonArray();
                    for (JsonElement city :
                            jsonArrayCity) {
                        classIndex = 2;
                        ZoneModelCity zoneModelCity = gson.fromJson(city, ZoneModelCity.class);
                        ZoneInsertModel zoneInsertModel1 = makeObject(zoneModelCity.getValue(), zoneModelCity.getLabel(), getPinyYinMy(zoneModelCity.getLabel()), classIndex, zoneModel.getValue());
                        i += addZone(zoneInsertModel1);

                        String areaChildren = gson.toJson(zoneModelCity.getChildren());
                        if (!areaChildren.equals("null")) {
                            JsonArray jsonArrayArea = parser.parse(areaChildren).getAsJsonArray();
                            for (JsonElement area :
                                    jsonArrayArea) {
                                classIndex = 3;
                                ZoneModelArea zoneModelArea = gson.fromJson(area, ZoneModelArea.class);
                                ZoneInsertModel zoneInsertModel2 = makeObject(zoneModelArea.getValue(), zoneModelArea.getLabel(), getPinyYinMy(zoneModelArea.getLabel()), classIndex, zoneModelCity.getValue());
                                i += addZone(zoneInsertModel2);

                                String streetChildren = gson.toJson(zoneModelArea.getChildren());
                                if (!streetChildren.equals("null")) {
                                    JsonArray jsonArrayStreet = parser.parse(streetChildren).getAsJsonArray();
                                    for (JsonElement street :
                                            jsonArrayStreet) {
                                        classIndex = 4;
                                        ZoneModelStreet zoneModelStreet = gson.fromJson(street, ZoneModelStreet.class);
                                        ZoneInsertModel zoneInsertModel3 = makeObject(zoneModelStreet.getValue(), zoneModelStreet.getLabel(), getPinyYinMy(zoneModelStreet.getLabel()), classIndex, zoneModelArea.getValue());
                                        i += addZone(zoneInsertModel3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    private String getPinyYinMy(String text) {
        if (text != null) {
            text = text.replace("省", "")
                    .replace("市", "")
                    .replace("区", "")
                    .replace("县", "")
                    .replace("街道", "")
                    .replace("（", "")
                    .replace("）", "")
                    .replace(")", "")
                    .replace("(", "");
            return LhGetPinyYinClass.getPingYin(text);
        } else
            return null;
    }

    private ZoneInsertModel makeObject(String id, String label, String pinyYin, int classIndex, String paraId) {
        id = id == null ? id : id.trim();
        label = label == null ? label : label.trim();
        pinyYin = pinyYin == null ? pinyYin : pinyYin.trim();
        paraId = paraId == null ? paraId : paraId.trim();

        ZoneInsertModel zoneInsertModel = new ZoneInsertModel();
        zoneInsertModel.setId(id);
        zoneInsertModel.setLabel(label);
        zoneInsertModel.setPinyYin(pinyYin);
        zoneInsertModel.setClassIndex(classIndex);
        zoneInsertModel.setParaId(paraId);
        return zoneInsertModel;
    }

    private int addZone(ZoneInsertModel zoneInsertModel) {
        return zoneService.insertZoneAlone(zoneInsertModel);
    }

}
