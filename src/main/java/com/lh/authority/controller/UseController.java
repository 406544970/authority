package com.lh.authority.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.authority.dto.UseDto;
import com.lh.authority.model.InPutParam.*;
import com.lh.authority.model.UseMobileAndMailModel;
import com.lh.authority.model.UseModel;
import com.lh.authority.service.UseService;
import com.lh.authority.unit.GetPropertiesClass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import lh.toolclass.LhClass;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ：梁昊，后端工程师：录像昊，前端工程师：当当然
 * @create 2019-09-09 14:43
 * @function
 * @editLog
 */
@EnableEurekaClient
@RestController
@RequestMapping("/useController")
@Api(value = "测试代码生成器", description = "代码生成器描述")
public class UseController {
    @Autowired
    GetPropertiesClass getPropertiesClass;

    @Autowired
    UseService useService;

    /**
     * 描述，方法ID：SE20190909144116865
     *
     * @param id    表sys_operator,字段名id:
     * @param page  当前页数
     * @param limit 每页条数
     * @return 返回值说明
     */
    @ApiOperation(value = "描述", notes = "返回值说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "", dataType = "String", required = true),
            @ApiImplicitParam(name = "page", value = "当前页数", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页条数", dataType = "int")
    })
    @PostMapping("/getNewUseListPage")
    public ResultVOPage getNewUseListPage(@RequestParam(value = "id") String id
            , @RequestParam(value = "page", defaultValue = "1") int page
            , @RequestParam(value = "limit", defaultValue = "10") int limit) {
        id = id == null ? id : id.trim();

        PageHelper.startPage(page, limit);
        List<UseDto> useDtos = useService.getNewUseListPage(id);
        PageInfo pageInfo = new PageInfo<>(useDtos, limit);
        return ResultStruct.successPage(useDtos, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * 增加新用户，方法ID：SE20190918135038622
     *
     * @param deptId      部门ID
     * @param username    用户名（登录用户名）
     * @param password    密码
     * @param name        用户姓名
     * @param englishName 英文名字
     * @param portrait    用户头像地址
     * @param mobile      手机号码
     * @param tel         联系电话
     * @param qq          QQ号码
     * @param email       电子邮箱
     * @param address     地址
     * @param postCode    邮政编码
     * @param userType    用户类型
     * @param remark      备注
     * @return 影响条数
     */
    @ApiOperation(value = "增加新用户", notes = "影响条数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptId", value = "部门ID", dataType = "String", required = true)
            , @ApiImplicitParam(name = "username", value = "用户名（登录用户名）", dataType = "String", required = true)
            , @ApiImplicitParam(name = "password", value = "密码", dataType = "String", required = true)
            , @ApiImplicitParam(name = "name", value = "用户姓名", dataType = "String", required = true)
            , @ApiImplicitParam(name = "englishName", value = "英文名字", dataType = "String")
            , @ApiImplicitParam(name = "portrait", value = "用户头像地址", dataType = "String")
            , @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", required = true)
            , @ApiImplicitParam(name = "tel", value = "联系电话", dataType = "String")
            , @ApiImplicitParam(name = "qq", value = "QQ号码", dataType = "String")
            , @ApiImplicitParam(name = "email", value = "电子邮箱", dataType = "String")
            , @ApiImplicitParam(name = "address", value = "地址", dataType = "String")
            , @ApiImplicitParam(name = "postCode", value = "邮政编码", dataType = "String")
            , @ApiImplicitParam(name = "userType", value = "用户类型", dataType = "String")
            , @ApiImplicitParam(name = "remark", value = "备注", dataType = "String")
    })
    @PostMapping("/addNewUse")
    public int addNewUse(@RequestParam(value = "deptId") String deptId
            , @RequestParam(value = "username") String username
            , @RequestParam(value = "password") String password
            , @RequestParam(value = "name") String name
            , @RequestParam(value = "englishName", required = false) String englishName
            , @RequestParam(value = "portrait", required = false) String portrait
            , @RequestParam(value = "mobile") String mobile
            , @RequestParam(value = "tel", required = false) String tel
            , @RequestParam(value = "qq", required = false) String qq
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "address", required = false) String address
            , @RequestParam(value = "postCode", required = false) String postCode
            , @RequestParam(value = "userType", required = false) String userType
            , @RequestParam(value = "remark", required = false) String remark) {
        deptId = deptId == null ? deptId : deptId.trim();
        username = username == null ? username : username.trim();
        password = password == null ? password : password.trim();
        name = name == null ? name : name.trim();
        englishName = englishName == null ? englishName : englishName.trim();
        portrait = portrait == null ? portrait : portrait.trim();
        mobile = mobile == null ? mobile : mobile.trim();
        tel = tel == null ? tel : tel.trim();
        qq = qq == null ? qq : qq.trim();
        email = email == null ? email : email.trim();
        address = address == null ? address : address.trim();
        postCode = postCode == null ? postCode : postCode.trim();
        userType = userType == null ? userType : userType.trim();
        remark = remark == null ? remark : remark.trim();

        UseInsertInParam useInsertInParam = new UseInsertInParam();
        String mainKey = LhClass.getOrderMainLenKey(Short.valueOf(getPropertiesClass.getPort()));//这里引用架包中的生成主键方法
        useInsertInParam.setId(mainKey);
        useInsertInParam.setDeptId(deptId);
        useInsertInParam.setUsername(username);
        useInsertInParam.setPassword(password);
        useInsertInParam.setName(name);
        useInsertInParam.setEnglishName(englishName);
        useInsertInParam.setPortrait(portrait);
        useInsertInParam.setMobile(mobile);
        useInsertInParam.setTel(tel);
        useInsertInParam.setQq(qq);
        useInsertInParam.setEmail(email);
        useInsertInParam.setAddress(address);
        useInsertInParam.setPostCode(postCode);
        useInsertInParam.setUserType(userType);
        useInsertInParam.setRemark(remark);
        int repetitionCount = useService.AddNewUseBeforeCheck(useInsertInParam);
        if (repetitionCount > 0)
            return -1000;
        int resultCount = useService.AddNewUse(useInsertInParam);

        return resultCount;
    }

    /**
     * 用户登录，方法ID：SE20190918154314137
     *
     * @param mobile 表sys_userinfo,字段名mobile:手机号码
     * @return 结构体
     */
    @ApiOperation(value = "用户登录", notes = "结构体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", required = true)
    })
    @PostMapping("/useLogByNameAndPassWord")
    public ResultVO useLogByNameAndPassWord(@RequestParam(value = "mobile") String mobile
            , @RequestParam(value = "passWord") String passWord
    ) {
        return useLogByNameAndPassWordALLPrivate(mobile, passWord, true);
    }

    /**
     * 用户登录，方法ID：SE20190918154314137
     *
     * @param mobile 表sys_userinfo,字段名mobile:手机号码
     * @return 结构体
     */
    @ApiOperation(value = "用户登录", notes = "结构体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String", required = true)
    })
    @PostMapping("/useLogByNameAndPassWordCS")
    public ResultVO useLogByNameAndPassWordCS(@RequestParam(value = "mobile") String mobile
            , @RequestParam(value = "passWord") String passWord) {
        return useLogByNameAndPassWordALLPrivate(mobile, passWord, false);
    }

    private ResultVO useLogByNameAndPassWordALLPrivate(String mobile
            , String passWord
            , boolean bsSign
    ) {
        mobile = mobile == null ? mobile : mobile.trim();
        passWord = passWord == null ? passWord : passWord.trim();
        UseModel useModel = useService.useLogByNameAndPassWord(mobile);
        if (useModel == null) {
            return ResultStruct.error("无此用户！", ResultVO.class);
        }
        if (useModel.getStopSign()) {
            return ResultStruct.error("此用户已停用！", ResultVO.class);
        }
        if (!passWord.equals(useModel.getPassword())) {
            return ResultStruct.error("密码错误！", ResultVO.class);
        }
        if (bsSign) {
            final String TokenName = "accessToken";
            final String UseId = "useId";
            final String UseType = "useType";
            final String ClientType = "clientType";
            final int seconds = 3600 * 2;
            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
            HttpServletResponse response = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getResponse();
            String myOrigin = request.getHeader("origin");
            myOrigin = getDoMain(myOrigin);
//            cookie.setHttpOnly(true);
            Cookie tokenName = new Cookie(TokenName, UUID.randomUUID().toString());
            tokenName.setPath("/");
            tokenName.setDomain(myOrigin);
            tokenName.setMaxAge(seconds);
            response.addCookie(tokenName);

            Cookie useId = new Cookie(UseId, useModel.getId());
            useId.setPath("/");
            useId.setDomain(myOrigin);
            useId.setMaxAge(seconds);
            response.addCookie(useId);

            Cookie useType = new Cookie(UseType, useModel.getUserType());
            useType.setPath("/");
            useType.setDomain(myOrigin);
            useType.setMaxAge(seconds);
            response.addCookie(useType);

            Cookie clientType = new Cookie(ClientType, "BS");
            clientType.setPath("/");
            clientType.setDomain(myOrigin);
            clientType.setMaxAge(seconds);
            response.addCookie(clientType);
        }
        return ResultStruct.success(useModel);
    }

    private String getDoMain(String myOrigin) {
        String newOrigin = myOrigin.replace("https://", "")
                .replace("http://", "");
        int i = newOrigin.indexOf(":");
        if (i > -1) {
            newOrigin = newOrigin.substring(0, i);
        }
        int index = newOrigin.indexOf(".");
        if (index > -1) {
            newOrigin = newOrigin.substring(index + 1);
        }
        return newOrigin;
    }

    /**
     * 根据标识得到内容，方法ID：SE20190924113129544
     *
     * @param username 表sys_userinfo,字段名username:用户名（登录用户名）
     * @param mobile   表sys_userinfo,字段名mobile:手机号码
     * @param email    表sys_userinfo,字段名email:电子邮箱
     * @return 根据登录帐号或手机号或邮件
     */
    @ApiOperation(value = "根据标识得到内容", notes = "根据登录帐号或手机号或邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名（登录用户名）", dataType = "String"),
            @ApiImplicitParam(name = "mobile", value = "手机号码", dataType = "String"),
            @ApiImplicitParam(name = "email", value = "电子邮箱", dataType = "String")
    })
    @PostMapping("/getMobileAndMailBy")
    public ResultVO getMobileAndMailBy(@RequestParam(value = "username", required = false) String username
            , @RequestParam(value = "mobile", required = false) String mobile
            , @RequestParam(value = "email", required = false) String email) {
        username = username == null ? username : username.trim();
        mobile = mobile == null ? mobile : mobile.trim();
        email = email == null ? email : email.trim();
        if (username == null && mobile == null && email == null) {
            return ResultStruct.error("请输入登录帐号、手机或邮件！", ResultVO.class);
        }
        UseSelectMobileAndMailInParam useSelectMobileAndMailInParam = new UseSelectMobileAndMailInParam();
        useSelectMobileAndMailInParam.setUsername(username);
        useSelectMobileAndMailInParam.setMobile(mobile);
        useSelectMobileAndMailInParam.setEmail(email);
        UseMobileAndMailModel mobileAndMailBy = useService.getMobileAndMailBy(useSelectMobileAndMailInParam);
        if (mobileAndMailBy == null) {
            return ResultStruct.error("无此用户！", ResultVO.class);
        }
        if (mobileAndMailBy.getStopSign()) {
            return ResultStruct.error("此用户已停用！", ResultVO.class);
        }

        return ResultStruct.success(mobileAndMailBy);
    }

    /**
     * 修改密码，方法ID：SE20190924121603404
     *
     * @param idWhere  逻辑主键, Where字段
     * @param password 密码
     * @return 结构体
     */
    @ApiOperation(value = "修改密码", notes = "结构体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idWhere", value = "逻辑主键", dataType = "String", required = true)
            , @ApiImplicitParam(name = "password", value = "密码", dataType = "String", required = true)
    })
    @PostMapping("/updatePassWordById")
    public ResultVO updatePassWordById(@RequestParam(value = "idWhere") String idWhere
            , @RequestParam(value = "password") String password) {
        idWhere = idWhere == null ? idWhere : idWhere.trim();
        password = password == null ? password : password.trim();
        if (password.length() > 40) {
            return ResultStruct.error("请输入6位密码！", ResultVO.class);
        }

        UseUpdateInParam useUpdateInParam = new UseUpdateInParam();
        useUpdateInParam.setIdWhere(idWhere);
        useUpdateInParam.setPassword(password);
        int updateCount = useService.updatePassWordById(useUpdateInParam);
        if (updateCount > 0)
            return ResultStruct.success(updateCount);
        else
            return ResultStruct.error("修改失败", ResultVO.class);
    }

    /**
     * 根据GUID，得到用户ID，方法ID：SE20190924122622552
     *
     * @param guid 表sys_forgetPassWordMail,字段名guid:guid
     * @return UseID
     */
    @ApiOperation(value = "根据GUID，得到用户ID", notes = "UseID")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "guid", value = "guid", dataType = "String", required = true)
    })
    @PostMapping("/getUseIdByGuid")
    public ResultVO getUseIdByGuid(@RequestParam(value = "guid") String guid) {
        guid = guid == null ? guid : guid.trim();
        String useIdByGuid = useService.getUseIdByGuid(guid);
        if (useIdByGuid == null) {
            return ResultStruct.error("密码修改申请记录超时，请重复发启“忘记密码”流程！", ResultVO.class);
        }
        return ResultStruct.success(useIdByGuid);
    }

    /**
     * 增加忘记密码申请，方法ID：SE20190924123537355
     *
     * @param useId 用户ID
     * @return 是否已增加
     */
    @ApiOperation(value = "增加忘记密码申请", notes = "是否已增加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "useId", value = "用户ID", dataType = "String", required = true)
    })
    @PostMapping("/insertForGetPassWordRecord")
    public ResultVO insertForGetPassWordRecord(@RequestParam(value = "useId") String useId) {
        useId = useId == null ? useId : useId.trim();
        if (useId == null) {
            return ResultStruct.error("用户ID，不能为空！", ResultVO.class);
        }
        String id = LhClass.getMainDataLineKey(Short.valueOf(getPropertiesClass.getPort()));
        String guid = UUID.randomUUID().toString().replace("-", "");

        Long time = System.currentTimeMillis();
        time += 1000 * 3600 * 24;//在当前系统时间的基础上往后增加24小时
        Date endDate = new Date(time);

        UseInsertForGet useInsertForGet = new UseInsertForGet();
        useInsertForGet.setId(id);
        useInsertForGet.setUseId(useId);
        useInsertForGet.setEndDate(endDate);
        useInsertForGet.setGuid(guid);

        UseDeletePassWordInParam useDeletePassWordInParam = new UseDeletePassWordInParam();
        useDeletePassWordInParam.setUseId(useId);
        int deletePassWordRecordByUseId = useService.deletePassWordRecordByUseId(useDeletePassWordInParam);
        int resultCount = useService.insertForGetPassWordRecord(useInsertForGet);
        if (resultCount > 0)
            return ResultStruct.success(resultCount + deletePassWordRecordByUseId);
        else
            return ResultStruct.error("增加失败", ResultVO.class);
    }
}
