package com.lh.authority.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.authority.dto.UseDto;
import com.lh.authority.model.InPutParam.UseInsertInParam;
import com.lh.authority.model.UseModel;
import com.lh.authority.service.UseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import lh.toolclass.LhClass;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * @author ：梁昊，后端工程师：录像昊，前端工程师：当当然
 * @create 2019-09-09 14:43
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/useController")
@Api(value = "测试代码生成器", description = "代码生成器描述")
public class UseController {
    @Autowired
    UseService useService;

    @Value("${server.port}")
    private String port;

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
    @PostMapping("/AddNewUse")
    public int AddNewUse(@RequestParam(value = "deptId") String deptId
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
        String mainKey = LhClass.getOrderMainLenKey(Short.valueOf(port));//这里引用架包中的生成主键方法
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
//            , @RequestParam(value = "request") HttpServletRequest request
//            , @RequestParam(value = "response") HttpServletResponse response
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
            final int seconds= 3600 * 2;
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
    private String getDoMain(String myOrigin){
        String newOrigin = myOrigin.replace("https://","")
                .replace("http://","");
        int i = newOrigin.indexOf(":");
        if (i > -1) {
            newOrigin = newOrigin.substring(0,i);
        }
        int index = newOrigin.indexOf(".");
        if (index > -1) {
            newOrigin = newOrigin.substring(index + 1);
        }
        return newOrigin;
    }
}
