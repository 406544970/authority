package com.lh.authority.unit;

import com.lh.VO.ResultVO;
import com.lh.authority.model.MongodbTestModel;
import com.lh.mongodb.model.CriterialFilter;
import com.lh.mongodb.model.MongodbSelect;
import com.lh.mongodb.model.SortModel;
import com.lh.mongodb.myenum.CriteriaOperate;
import com.lh.mongodb.tool.ChangeAction;
import com.lh.mongodb.tool.SelectAction;
import com.lh.utils.ResultUtils;
import javafx.scene.control.TextFormatter;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MongodbJar {
    @Autowired
    MongoTemplate mongoTemplate;

    private String collectName;
    private SelectAction selectAction;
    private ChangeAction changeAction;

    public void setCollectName(String collectName) {
        this.collectName = collectName;
    }

    public MongodbJar() {
        super();
        setCollectName("test_Collect");
        selectAction = new SelectAction(this.collectName);
        changeAction = new ChangeAction(this.collectName);
//        selectAction.setMongoTemplate(this.mongoTemplate);
    }
    public void deleteCollect(){
        changeAction.setMongoTemplate(this.mongoTemplate);
        changeAction.clearCollection(this.collectName);
    }
    public ResultVO getLogModelListNew() throws ClassNotFoundException, ParseException {
        selectAction.setMongoTemplate(this.mongoTemplate);
        MongodbSelect mongodbSelect = new MongodbSelect(MongodbTestModel.class);

        List<SortModel> sortModels = new ArrayList<>();
        SortModel sortModel = new SortModel();
        sortModel.setFieldName("createData");
        sortModel.setAscSign(false);
        sortModels.add(sortModel);
        mongodbSelect.setSortModels(sortModels);

        mongodbSelect.setCollectName(this.collectName);
        mongodbSelect.setDefaultPageParam(true);

        CriterialFilter criterialFilter = new CriterialFilter();
        criterialFilter.setCriteriaOperate(CriteriaOperate.IS);
        criterialFilter.setFieldName("stopSign");
        criterialFilter.setFieldValue(true);

        CriterialFilter criterialFilter2 = new CriterialFilter();
        criterialFilter2.setCriteriaOperate(CriteriaOperate.GTE);
        criterialFilter2.setFieldName("createData");
        String startDate = "2019-08-04 13:44:15";
        criterialFilter2.setFieldValue(startDate);

        CriterialFilter criterialFilter3 = new CriterialFilter();
        criterialFilter3.setCriteriaOperate(CriteriaOperate.LLIKE);
        criterialFilter3.setFieldName("testContent");
        criterialFilter3.setFieldValue("testContent");

        List<CriterialFilter> criteriaFilters = new ArrayList<>();
        criteriaFilters.add(criterialFilter);
//        criteriaFilters.add(criterialFilter2);
//        criteriaFilters.add(criterialFilter3);

        mongodbSelect.setCriterialFilterList(criteriaFilters);
        List<MongodbTestModel> mongodbListNew = selectAction.getMongodbList(MongodbTestModel.class, mongodbSelect);

        ResultVO resultVO = new ResultVO();
        resultVO.setData(mongodbListNew);
        resultVO.setMessage(String.format("%s", mongodbSelect.getDataTotal()));

        return ResultUtils.success(resultVO);

    }

}
