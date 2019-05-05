package com.lh.authority.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.netflix.discovery.DiscoveryManager.getInstance;

/**
 * @author 梁昊
 * @date 2019/4/22
 * @function 通用功能控制层
 * @editLog
 */
@RestController
@EnableEurekaClient
@RequestMapping(value = "/universal")     // 通过这里配置使下面的映射都在/users下，可去除
@Api(value = "通用控制层", description = "专用于梁昊所要求的通用方法")
public class UniversalController {
    public UniversalController() {
        super();
    }

    @Value("${eureka.instance.metadata-map.version}")
    private String version;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String springApplicationName;

    /**
     * @return 返回当前版本号
     */
    @ApiOperation(value = "得到当前版本号", notes = "返回：当前版本号")
    @PostMapping("/myVersion")
    public String getVersion() {
        return String.format("My port is : %s;My version is : %s", port, version);
    }

    /**
     * @return 返回当前端口号
     */
    @ApiOperation(value = "得到当前端口号", notes = "返回：当前端口号")
    @PostMapping("/myPort")
    public String myPort() {
        return String.format("I am is port:%s", port);
    }

    /**
     * @return 手动下线
     */
    @ApiOperation(value = "手动下线方法", notes = "返回：当前微服务名和端口号")
    @GetMapping("/downLine")
    public String downLine() {
        getInstance().shutdownComponent();
        return String.format("ApplicationName\"%s\"(Port:%s) is downLine.", this.springApplicationName, this.port);
    }

}
