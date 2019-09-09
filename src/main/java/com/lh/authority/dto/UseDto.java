package com.lh.authority.dto;
/**
 * @author ：梁昊，后端工程师：录像昊，前端工程师：当当然
 * @create 2019-09-09 14:41
 * @function
 * @editLog
 */
public final class UseDto {
    /**
     *
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 英文名
     */
    private String eName;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEName(){
        return eName;
    }

    public void setEName(String eName){
        this.eName = eName;
    }
    /**
     * 角色ID
     */
    private String roleId;

    public String getRoleId(){
        return roleId;
    }

    public void setRoleId(String roleId){
        this.roleId = roleId;
    }
}
