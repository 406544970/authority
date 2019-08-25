package com.lh.authority.dao;

import com.lh.authority.dto.UserDto;
import com.lh.authority.model.InPutParam.UserInPutPara;
import com.lh.authority.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author ：
 * @create 2019-08-10 21:56
 * @function
 * @editLog
 */
@Mapper
public interface UserMapper {
    /**
     * 得到UserList
     *
     * @param id 主键
     * @return 返回UserList，根据useName
     */
    List<User> getUserList(@Param("id") String id);
    LinkedHashMap getUserListTotal(@Param("value") String value);
    /**
     * 得到UserList2
     *
     * @param mainId 主键
     * @return 返回UserList，根据useName
     */
    List<UserDto> getUserList2(@Param("mainId") String mainId);

    /**
     * 得到UserList3
     *
     * @param userInPutPara 得到UserList3
     * @return 返回UserList，根据useName
     */
    List<UserDto> getUserList3(UserInPutPara userInPutPara);
}
