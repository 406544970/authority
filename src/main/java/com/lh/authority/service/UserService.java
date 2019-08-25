package com.lh.authority.service;

import com.lh.authority.dto.UserDto;
import com.lh.authority.model.InPutParam.UserInPutPara;
import com.lh.authority.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author ：
 * @create 2019-08-10 21:56
 * @function
 * @editLog
 */
public interface UserService {
    /**
     * 得到UserList
     *
     * @param id 主键
     * @return 返回UserList，根据useName
     */
    List<User> getUserList(String id);
    /**
     * 得到UserList2
     *
     * @param mainId 主键
     * @return 返回UserList，根据useName
     */
    List<UserDto> getUserList2(String mainId);

    /**
     * 得到UserList3
     *
     * @param userInPutPara 得到UserList3
     * @return 返回UserList，根据useName
     */
    List<UserDto> getUserList3(UserInPutPara userInPutPara);

    LinkedHashMap getUserListTotal(String value);
}
