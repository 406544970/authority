package com.lh.authority.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.lh.authority.model.InPutParam.ZoneDeleteInParam;
import com.lh.authority.model.InPutParam.ZoneInsertInParam;
import com.lh.authority.model.InPutParam.ZoneListInPutParam;
import com.lh.authority.model.InPutParam.ZoneUpdateInParam;
import com.lh.authority.model.*;
import com.lh.authority.service.ZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import lh.toolclass.LhClass;
import lh.toolclass.LhGetPinyYinClass;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
@EnableEurekaClient
@RestController
@RequestMapping("/user")
@Api(value = "地区", description = "地区")
public class ZoneController {
    @Value("${server.port}")
    private String port;
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

    /**
     * 增加地区，方法ID：IN20190922145606679
     *
     * @param label      地区名称
     * @param classIndex 级别
     * @param paraId     父ID
     * @param auditSign  审核状态
     * @return 影响条数
     */
    @ApiOperation(value = "增加地区", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "label", value = "地区名称", dataType = "String", required = true)
            , @ApiImplicitParam(name = "classIndex", value = "级别", dataType = "int", required = true)
            , @ApiImplicitParam(name = "paraId", value = "父ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "auditSign", value = "审核状态", dataType = "int", required = true)
    })
    @PostMapping("/insertZone")
    public ResultVO insertZone(@RequestParam(value = "label") String label
            , @RequestParam(value = "classIndex") int classIndex
            , @RequestParam(value = "paraId") String paraId
            , @RequestParam(value = "auditSign", defaultValue = "1") int auditSign) {
        label = label == null ? label : label.trim();
        paraId = paraId == null ? paraId : paraId.trim();

        ZoneInsertInParam zoneInsertInParam = new ZoneInsertInParam();
        String mainKey = LhClass.getMainDataLineKey(Short.valueOf(port));
        zoneInsertInParam.setId(mainKey);
        zoneInsertInParam.setLabel(label);
        zoneInsertInParam.setPinyYin(getPinyYinMy(label));
        zoneInsertInParam.setClassIndex(classIndex);
        zoneInsertInParam.setParaId(paraId);
        zoneInsertInParam.setAuditSign(auditSign);
        int repetitionCount = zoneService.insertZoneBeforeCheck(zoneInsertInParam);
        if (repetitionCount > 0)
            return ResultStruct.error("增加失败，有" + repetitionCount + "条数据已重复！", ResultVO.class);
        int resultCount = zoneService.insertZone(zoneInsertInParam);
        if (resultCount > 0)
            return ResultStruct.success(resultCount);
        else
            return ResultStruct.error("增加失败", ResultVO.class);
    }

    /**
     * 删除，方法ID：DE20190922150724184
     *
     * @param id 主键
     * @return 影响条数
     */
    @ApiOperation(value = "删除", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String", required = true)
    })
    @PostMapping("/deleteZoneById")
    public ResultVO deleteZoneById(@RequestParam(value = "id") String id) {
        id = id == null ? id : id.trim();

        ZoneDeleteInParam zoneDeleteInParam = new ZoneDeleteInParam();
        zoneDeleteInParam.setId(id);
        int repetitionCount = zoneService.deleteZoneBeforeCheck(zoneDeleteInParam);
        if (repetitionCount > 0)
            return ResultStruct.error("删除失败，有" + repetitionCount + "条子地区数据！", ResultVO.class);
        int updateCount = deleteZoneByIdPrivate(zoneDeleteInParam);
        if (updateCount > 0)
            return ResultStruct.success(updateCount);
        else
            return ResultStruct.error("删除失败", ResultVO.class);
    }

    /**
     * 删除自己和所有子节点，方法ID：DE20190922150724184
     *
     * @param id 主键
     * @return 影响条数
     */
    @ApiOperation(value = "删除", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String", required = true)
    })
    @PostMapping("/deleteZoneAndSub")
    public ResultVO deleteZoneAndSub(@RequestParam(value = "id") String id) {
        return ResultStruct.success(deleteZoneAndSubCount(id));
    }

    /**
     * 循环递归删除
     *
     * @param id 该节点ID
     * @return 删除总数量，包括：该节点与子节点
     */
    private int deleteZoneAndSubCount(String id) {
        if (id == null)
            return 0;
        id = id.trim();
        int deleteCount = 0;
        List<String> list = zoneService.selectZoneByParaId(id);
        if (list != null) {
            for (String item :
                    list) {
                deleteCount += deleteZoneAndSubCount(item);
            }
        }
        ZoneDeleteInParam zoneDeleteInParam = new ZoneDeleteInParam();
        zoneDeleteInParam.setId(id);
        deleteCount += deleteZoneByIdPrivate(zoneDeleteInParam);
        return deleteCount;
    }

    private int deleteZoneByIdPrivate(ZoneDeleteInParam zoneDeleteInParam) {
        int updateCount = zoneService.deleteZoneById(zoneDeleteInParam);
        return updateCount;
    }

    /**
     * 修改地区，方法ID：UP20190922152331967
     *
     * @param idWhere    主键, Where字段
     * @param label      地区名称
     * @param classIndex 级别
     * @param paraId     父ID
     * @param auditSign  审核状态
     * @return 影响条数
     */
    @ApiOperation(value = "修改地区", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idWhere", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "label", value = "地区名称", dataType = "String", required = true)
            , @ApiImplicitParam(name = "classIndex", value = "级别", dataType = "int", required = true)
            , @ApiImplicitParam(name = "paraId", value = "父ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "auditSign", value = "审核状态", dataType = "int", required = true)
    })
    @PostMapping("/updateZone")
    public ResultVO updateZone(@RequestParam(value = "idWhere") String idWhere
            , @RequestParam(value = "label") String label
            , @RequestParam(value = "classIndex") int classIndex
            , @RequestParam(value = "paraId") String paraId
            , @RequestParam(value = "auditSign", defaultValue = "1") int auditSign) {
        idWhere = idWhere == null ? idWhere : idWhere.trim();
        label = label == null ? label : label.trim();
        paraId = paraId == null ? paraId : paraId.trim();

        ZoneUpdateInParam zoneUpdateInParam = new ZoneUpdateInParam();
        zoneUpdateInParam.setIdWhere(idWhere);
        zoneUpdateInParam.setLabel(label);
        zoneUpdateInParam.setPinyYin(getPinyYinMy(label));
        zoneUpdateInParam.setClassIndex(classIndex);
        zoneUpdateInParam.setParaId(paraId);
        zoneUpdateInParam.setAuditSign(auditSign);
        int updateCount = zoneService.updateZone(zoneUpdateInParam);
        if (updateCount > 0)
            return ResultStruct.success(updateCount);
        else
            return ResultStruct.error("修改失败", ResultVO.class);
    }

    /**
     * 修改父ID，方法ID：UP20190922152331967
     *
     * @param idWhere 主键, Where字段
     * @param paraId  父ID
     * @return 影响条数
     */
    @ApiOperation(value = "修改父ID", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idWhere", value = "主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "paraId", value = "父ID", dataType = "String", required = true)
    })
    @PostMapping("/changeZoneParaId")
    public ResultVO changeZoneParaId(@RequestParam(value = "idWhere") String idWhere
            , @RequestParam(value = "paraId") String paraId) {
        idWhere = idWhere == null ? idWhere : idWhere.trim();
        paraId = paraId == null ? paraId : paraId.trim();

        ZoneUpdateInParam zoneUpdateInParam = new ZoneUpdateInParam();
        zoneUpdateInParam.setIdWhere(idWhere);
        zoneUpdateInParam.setParaId(paraId);
        int updateCount = zoneService.updateZone(zoneUpdateInParam);
        if (updateCount > 0)
            return ResultStruct.success(updateCount);
        else
            return ResultStruct.error("修改失败", ResultVO.class);
    }

}
