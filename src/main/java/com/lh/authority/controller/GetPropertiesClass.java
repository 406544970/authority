package com.lh.authority.controller;

import org.springframework.beans.factory.annotation.Value;

/**
 * 得到参数
 * @author 梁昊
 * @date 2019/9/24
 * @function
 * @editLog
 */
public abstract class GetPropertiesClass {
    @Value("${server.port}")
    private String port;
    @Value("${eureka.instance.metadata-map.version}")
    private String version;
    @Value("${spring.application.name}")
    private String springApplicationName;
    @Value("${liangHaoSign}")
    private String liangHaoSign;

    /**
     * 得到端口号
     * @return
     */
    protected String getPort(){
        return this.port;
    }

    /**
     * 得到版本
     * @return
     */
    protected String getVersion(){
        return this.version;
    }

    /**
     * 得到微服务名称
     * @return
     */
    protected String getApplicationName(){
        return this.springApplicationName;
    }

    /**
     * 自定义测试标识
     * @return
     */
    protected String getLiangHaoSign(){
        return this.liangHaoSign;
    }
}
