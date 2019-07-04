package com.lh.authority.unit;

import com.lh.VO.ResultVO;
import com.lh.authority.model.*;
import com.lh.authority.myenum.CriteriaOperate;
import com.lh.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import sun.awt.im.CompositionArea;

import java.util.*;
import java.util.regex.Pattern;

@Component
public class MongodbOperator {
    @Autowired
    MongoTemplate mongoTemplate;

    private String collectName;

    public String getCollectName() {
        return collectName;
    }

    public void setCollectName(String collectName) {
        this.collectName = collectName;
    }

    public MongodbOperator() {
        super();
        this.collectName = "test_Collect";
    }

    public boolean insertMongodb() {
//        final int recordCount = 10 * 10000;
        final int recordCount = 100;
        for (int i = 0; i < recordCount; i++) {
            MongodbTestModel mongodbTestModel = new MongodbTestModel();
            mongodbTestModel.set_id(String.format("id%s", i + 1));
            mongodbTestModel.setSortNo(i + 1);
            mongodbTestModel.setaByte((byte) (i > 127 ? i - 127 : i));
            mongodbTestModel.setaDouble((double) i + 1);
            mongodbTestModel.setFloatNumber((float) i);
            mongodbTestModel.setStopSign((i % 2) == 0 ? true : false);
            mongodbTestModel.setTestContent(String.format("TestContent%s", i));
            mongodbTestModel.setTestOrContent(String.format("TestOrContent%s", i));
            mongoTemplate.insert(mongodbTestModel, this.collectName);
        }
        return true;
    }

    public int insertPatchData() {
        int counter = 10;
        List<LogModel> logModels = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            LogModel logModel = new LogModel();
            logModel.setUseId("logModeId" + i);
            logModel.setAccessToken("AccessToken");
            logModel.setClientType("TestType");
            logModel.setTimeOut(i + 1);
            logModel.setUseType("useType");
            logModels.add(logModel);
        }
        Set logModelSet = new HashSet(logModels);
        mongoTemplate.insert(logModelSet, this.collectName);
        return counter;
    }

    public int deleteMongodb() {
//        mongoTemplate.dropCollection(LogModel.class);
//        mongoTemplate.dropCollection(this.collectName);
        Query query = new Query();
        query.addCriteria(Criteria.where("useType").is("useType"));
        return mongoTemplate.remove(query, this.collectName).getN();
    }

    public int updateMongodb() {
//        Query query = new Query();
//        org.springframework.data.mongodb.core.query.Update update = new BasicUpdate();
//        return mongoTemplate.upsert(query,this.collectName,LogModel.class,this.collectName).getN();
        return 0;
    }

    private <T> List<T> getMongodbListNew(Class<T> resultClassName, MongodbSelect mongodbSelect
            , MongoTemplate mongoTemplate) {
        boolean fieldHave = true;
        List<CriterialFilter> criterialFilterList = mongodbSelect.getCriterialFilterList();
        if (criterialFilterList != null) {
            for (CriterialFilter criterialFilter : criterialFilterList
                    ) {
                fieldHave = fieldHave && mongodbSelect.fieldNameIsHave(criterialFilter.getFieldName());
            }
        }
        if (fieldHave) {
            List<CriterialFilter> orCriterialFilterList = mongodbSelect.getOrCriterialFilterList();
            if (orCriterialFilterList != null) {
                for (CriterialFilter criterialFilter : orCriterialFilterList
                        ) {
                    fieldHave = fieldHave && mongodbSelect.fieldNameIsHave(criterialFilter.getFieldName());
                }
            }
        }
        if (fieldHave) {
            List<SortModel> sortModels = mongodbSelect.getSortModels();
            if (sortModels != null) {
                for (SortModel sortModel : mongodbSelect.getSortModels()
                        ) {
                    fieldHave = fieldHave && mongodbSelect.fieldNameIsHave(sortModel.getFieldName());
                }
            }
        }
        if (!fieldHave) {
            return null;
        }
        Query query = new Query();
        PageModel pageModel = null;
        if (mongodbSelect.getSortModels() != null) {
            List<Sort.Order> orders = new ArrayList<>();  //排序
            for (SortModel row : mongodbSelect.getSortModels()
                    ) {
                orders.add(new Sort.Order(row.getAscSign() ? Sort.Direction.ASC : Sort.Direction.DESC
                        , row.getFieldName()));
            }
            if (orders != null && !orders.isEmpty()) {
                pageModel = new PageModel();
                Sort sort = new Sort(orders);
                pageModel.setSort(sort);
            }
        }
        if (mongodbSelect.getPageNumber() > 0 && mongodbSelect.getPageSize() > 0) {
            pageModel.setPageSize(mongodbSelect.getPageSize());
            pageModel.setPageNumber(mongodbSelect.getPageNumber());
        }
        MyPageable myPageable = null;
        if (pageModel != null) {
            myPageable = new MyPageable();
            myPageable.setPage(pageModel);
        }
        Criteria criteria = getCriteria(mongodbSelect.getCriterialFilterList());
        if (criteria != null) {
//            Criteria orCriteria = getCriteria(mongodbSelect.getOrCriterialFilterList());
//            if (orCriteria != null) {
//                criteria = criteria.orOperator(orCriteria);
//            }
            query.addCriteria(criteria);
        }
        if (mongodbSelect.getPageNumber() > 0 && mongodbSelect.getPageSize() > 0) {
            mongodbSelect.setDataTotal((int) mongoTemplate.count(query, resultClassName, collectName));
        }
        if (myPageable == null) {
            return mongoTemplate.find(query, resultClassName, collectName);
        } else {
            return mongoTemplate.find(query.with(myPageable), resultClassName, collectName);
        }
    }

    private Criteria getCriteria(List<CriterialFilter> criterialFilterList) {
        Criteria criteria = null;
        if (criterialFilterList != null && criterialFilterList.size() > 0) {
            int indexCount = 0;
            for (CriterialFilter criterialFilter : criterialFilterList
                    ) {
                CriteriaOperate criteriaOperate = criterialFilter.getCriteriaOperate();
                String fieldName = criterialFilter.getFieldName();
                Object fieldValue = criterialFilter.getFieldValue();
                Object fieldValueEnd = criterialFilter.getFieldValueEnd();
                String javaType = criterialFilter.getJavaType();
                boolean firstSign = indexCount > 0 ? false : true;
                if (firstSign) {
                    criteria = criteria.where(fieldName);
                } else
                    criteria = criteria.and(fieldName);
                switch (criteriaOperate) {
                    case IS:
                        criteria = criteria.is(fieldValue);
                        break;
                    case GT:
                        criteria = criteria.gt(fieldValue);
                        break;
                    case LT:
                        criteria = criteria.lt(fieldValue);
                        break;
                    case GTE:
                        criteria = criteria.gte(fieldValue);
                        break;
                    case LTE:
                        criteria = criteria.lte(fieldValue);
                        break;
                    case NE:
                        criteria = criteria.ne(fieldValue);
                        break;
                    case IN:
                        criteria = criteria.in(fieldValue);
                        break;
                    case NIN:
                        criteria = criteria.nin(fieldValue);
                        break;
                    case MOD:
                        criteria = criteria.mod(2, 0);
                        break;
                    case ALL:
                        criteria = criteria.all(fieldValue);
                        break;
                    case LLIKE:
                        criteria = criteria.regex(
                                Pattern.compile(String.format("^%s.*$", fieldValue)
                                        , Pattern.CASE_INSENSITIVE));
                        break;
                    case RLIKE:
                        criteria = criteria.regex(
                                Pattern.compile(String.format("^.*%s$", fieldValue)
                                        , Pattern.CASE_INSENSITIVE));
                        break;
                    case ALLLIKE:
                        criteria = criteria.regex(
                                Pattern.compile(String.format("^%s$", fieldValue)
                                        , Pattern.CASE_INSENSITIVE));
                        break;
                    default:
                        break;
                }
                indexCount++;
            }
        }
        return criteria;
    }

    private <T> List<T> getMongodbList(Class<T> resultClassName
            , List<SortModel> sortModels
            , MongoTemplate mongoTemplate
            , Integer pageNumber
            , Integer pageSize
            , String collectName) {
        long count = -1;
        MyPageable myPageable = new MyPageable();
        PageModel pageModel = new PageModel();
        if (sortModels != null) {
            List<Sort.Order> orders = new ArrayList<>();  //排序
            for (SortModel row : sortModels
                    ) {
                orders.add(new Sort.Order(row.getAscSign() ? Sort.Direction.ASC : Sort.Direction.DESC
                        , row.getFieldName()));
            }
            if (orders != null && !orders.isEmpty()) {
                Sort sort = new Sort(orders);
                pageModel.setSort(sort);
            }
        }
        if (pageNumber > 0 && pageSize > 0) {
            pageModel.setPageSize(pageSize);
            pageModel.setPageNumber(pageNumber);
        }
        myPageable.setPage(pageModel);

        Criteria criteria = Criteria.where("useType").is("useType");
        criteria = criteria.and("timeOut").gt(2);

        Query query = new Query();
        query.addCriteria(criteria);
        if (pageNumber > 0 && pageSize > 0) {
            count = mongoTemplate.count(query, resultClassName, collectName);
        }
        return mongoTemplate.find(query.with(myPageable), resultClassName, collectName);
    }


    public ResultVO getLogModelListNew() throws ClassNotFoundException {
        MongodbSelect mongodbSelect = new MongodbSelect(MongodbTestModel.class);

        List<SortModel> sortModels = new ArrayList<>();
        SortModel sortModel = new SortModel();
        sortModel.setFieldName("createData");
        sortModel.setAscSign(false);
        sortModels.add(sortModel);
        mongodbSelect.setSortModels(sortModels);

        mongodbSelect.setCollectName(this.collectName);
        mongodbSelect.setPageSize(5);
        mongodbSelect.setPageNumber(1);

        CriterialFilter criterialFilter = new CriterialFilter();
        criterialFilter.setCriteriaOperate(CriteriaOperate.IS);
        criterialFilter.setFieldName("stopSign");
        criterialFilter.setFieldValue(true);

        CriterialFilter criterialFilter2 = new CriterialFilter();
        criterialFilter2.setCriteriaOperate(CriteriaOperate.GTE);
        criterialFilter2.setFieldName("createData");
        criterialFilter2.setFieldValue(new Date(2019,7,3,8,27,19));
//        Collection<Integer> collection = new ArrayList<>();
//        collection.add(2);
//        collection.add(4);
//        criterialFilter2.setFieldValue(collection);
        List<CriterialFilter> criteriaFilters = new ArrayList<>();
        criteriaFilters.add(criterialFilter);
        criteriaFilters.add(criterialFilter2);

        mongodbSelect.setCriterialFilterList(criteriaFilters);
        List<MongodbTestModel> mongodbListNew = getMongodbListNew(MongodbTestModel.class, mongodbSelect, mongoTemplate);

        ResultVO resultVO = new ResultVO();
        resultVO.setData(mongodbListNew);
        resultVO.setMessage(String.format("%s", mongodbSelect.getDataTotal()));

        return ResultUtils.success(resultVO);

    }

    public ResultVO getLogModelList() {
        MyPageable myPageable = new MyPageable();
        PageModel pageModel = new PageModel();

        List<Sort.Order> orders = new ArrayList<>();  //排序
        orders.add(new Sort.Order(Sort.Direction.ASC, "timeOut"));
        Sort sort = new Sort(orders);
        pageModel.setSort(sort);
        if (pageModel.getPageNumber() > 0 && pageModel.getPageSize() > 0) {
            pageModel.setPageNumber(1);
            pageModel.setPageSize(5);
        }
        myPageable.setPage(pageModel);
        Criteria criteria = Criteria.where("useType").is("useType");
//        criteria = criteria.and("timeOut").gt(2);
        Collection<Integer> collection = new ArrayList<>();
        collection.add(2);
        collection.add(3);
        criteria = criteria.and("timeOut").in(collection);

//完全匹配
//        Pattern pattern = Pattern.compile("^logModeId1$", Pattern.CASE_INSENSITIVE);
////右匹配
//        Pattern pattern = Pattern.compile("^.*张$", Pattern.CASE_INSENSITIVE);
////左匹配
//        Pattern pattern = Pattern.compile("^张.*$", Pattern.CASE_INSENSITIVE);
////模糊匹配
        String regexString = String.format("^.*%s.*$", "log");
        Pattern pattern = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);
        criteria = criteria.and("useId").regex(Pattern.compile(regexString, Pattern.CASE_INSENSITIVE));
        Query query = new Query();
        query.addCriteria(criteria);
        long count = mongoTemplate.count(query, LogModel.class, this.collectName);

        List<LogModel> logModels = mongoTemplate.find(query.with(myPageable), LogModel.class, this.collectName);
        ResultVO resultVO = new ResultVO();
        resultVO.setData(logModels);
        resultVO.setMessage(String.format("%s", count));

        return ResultUtils.success(resultVO);
    }
}
