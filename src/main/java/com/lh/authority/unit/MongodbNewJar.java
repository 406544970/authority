package com.lh.authority.unit;

import lh.model.ResultVOTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
//@Component
public class MongodbNewJar {
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    private String collectName;
//    private SelectAction selectAction;
//    private ChangeAction changeAction;
//
//    public void setCollectName(String collectName) {
//        this.collectName = collectName;
//    }
//
//    public MongodbNewJar() {
//        super();
//        setCollectName("test_Collect");
//        selectAction = new SelectAction(this.collectName);
//        changeAction = new ChangeAction(this.collectName);
////        changeAction = new ChangeAction(hostAndPortModel,this.databaseName,null,null,this.collectName,null);
//    }
//    public int UpdateMongodb(Object WhereValue,Object SetValue) throws ParseException {
//        changeAction.setMongoTemplate(this.mongoTemplate);
//        CriterialFilter criterialFilter = new CriterialFilter();
//        criterialFilter.setCriteriaOperate(CriteriaOperate.IS);
//        criterialFilter.setFieldName("_id");
//        criterialFilter.setFieldValue(WhereValue);
//        List<CriterialFilter> criteriaFilters = new ArrayList<>();
//        criteriaFilters.add(criterialFilter);
//
//        List<CriterialFilter> keyAndValueList = new ArrayList<>();
//        CriterialFilter criterialFilterKeyAndValue = new CriterialFilter();
//        criterialFilterKeyAndValue.setCriteriaOperate(CriteriaOperate.IS);
//        criterialFilterKeyAndValue.setFieldName("aDouble");
//        criterialFilterKeyAndValue.setFieldValue(SetValue);
//        keyAndValueList.add(criterialFilterKeyAndValue);
//
//        int i = changeAction.updateFirst(criteriaFilters, keyAndValueList, this.collectName);
//        return i;
//    }
//    public ResultVOTotal getLogModelListNew() throws ClassNotFoundException, ParseException {
//        //        selectAction.setMongoTemplate(this.mongoTemplate);
//        //        MongodbSelect mongodbSelect = new MongodbSelect(MongodbTestModel.class);
//        //
//        //        List<SortModel> sortModels = new ArrayList<>();
//        //        SortModel sortModel = new SortModel();
//        //        sortModel.setFieldName("createData");
//        //        sortModel.setAscSign(false);
//        //        sortModels.add(sortModel);
//        //        mongodbSelect.setSortModels(sortModels);
//        //
//        //        mongodbSelect.setCollectName(this.collectName);
//        //        mongodbSelect.setDefaultPageParam(true);
//        //
//        //        CriterialFilter criterialFilter = new CriterialFilter();
//        //        criterialFilter.setCriteriaOperate(CriteriaOperate.IS);
//        //        criterialFilter.setFieldName("stopSign");
//        //        criterialFilter.setFieldValue(true);
//        //
//        //        CriterialFilter criterialFilter2 = new CriterialFilter();
//        //        criterialFilter2.setCriteriaOperate(CriteriaOperate.GTE);
//        //        criterialFilter2.setFieldName("createData");
//        //        String startDate = "2019-07-08 01:54:10";
//        //        criterialFilter2.setFieldValue(startDate);
//        //
//        //        CriterialFilter criterialFilter3 = new CriterialFilter();
//        //        criterialFilter3.setCriteriaOperate(CriteriaOperate.LLIKE);
//        //        criterialFilter3.setFieldName("testContent");
//        //        criterialFilter3.setFieldValue("testContent");
//        //
//        //        CriterialFilter criterialFilter4 = new CriterialFilter();
//        //        criterialFilter4.setCriteriaOperate(CriteriaOperate.MOD);
//        //        criterialFilter4.setFieldName("sortNo");//除以3，余数为1
//        //        criterialFilter4.setFieldValue(3);
//        //        criterialFilter4.setFieldValueEnd(1);
//        //
//        //        List<CriterialFilter> criteriaFilters = new ArrayList<>();
//        //        criteriaFilters.add(criterialFilter);
//        ////        criteriaFilters.add(criterialFilter2);
//        ////        criteriaFilters.add(criterialFilter3);
//        //        criteriaFilters.add(criterialFilter4);
//        //
//        //        mongodbSelect.setCriterialFilterList(criteriaFilters);
//        //        List<MongodbTestModel> mongodbListNew = selectAction.getMongodbList(MongodbTestModel.class, mongodbSelect);
//        //
//        //        ResultVO returnPage = new ResultVO();
//        //        returnPage.setData(mongodbListNew);
//        //
//        //        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
//        //        linkedHashMap.put("some",mongodbSelect.getDataTotal());
//        //
//        //        return ResultStruct.successTotal(mongodbListNew,linkedHashMap);
//            return  null;
//    }

}
