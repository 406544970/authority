package com.lh.authority.service.impl;

import com.lh.authority.dao.UserMapper;
import com.lh.authority.dto.UserDto;
import com.lh.authority.model.InPutParam.UserInPutPara;
import com.lh.authority.model.User;
import com.lh.authority.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unit.MybatisSqlHelper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：梁昊，后端工程师：杨凯，前端工程师：陈盼
 * @create 2019-08-10 22:01
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    private MybatisSqlHelper mybatisSqlHelper;
    /**
     * 得到UserList
     *
     * @param id 主键
     * @return 返回UserList，根据useName
     */
    @Override
    public List<User> getUserList(String id) {
        return userMapper.getUserList(id);
    }
    /**
     * 得到UserList2
     *
     * @param mainId 主键
     * @return 返回UserList，根据useName
     */
    @Override
    public List<UserDto> getUserList2(String mainId) {
        return userMapper.getUserList2(mainId);
    }
    /**
     * 得到UserList3
     *
     * @param userInPutPara 得到UserList3
     * @return 返回UserList，根据useName
     */
    @Override
    public List<UserDto> getUserList3(UserInPutPara userInPutPara) {
        return userMapper.getUserList3(userInPutPara);
    }

    /**
     * @param value 参数
     * @return
     */
    @Override
    public LinkedHashMap getUserListTotal(String value) {
        mybatisSqlHelper = new MybatisSqlHelper(this.sqlSessionFactory);
        String mapperSql;
        if (value != null && value.length() > 0) {
            Map map = new HashMap();
            map.put("id",value);
            mapperSql = mybatisSqlHelper.getNamespaceSql("com.lh.authority.dao.UserMapper.getUserList", map);
        }
        else
            mapperSql = mybatisSqlHelper.getNamespaceSql("com.lh.authority.dao.UserMapper.getUserList", null);
        return userMapper.getUserListTotal(mapperSql);
    }
}
