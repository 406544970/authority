package com.lh.authority;

import com.google.gson.Gson;
import com.lh.authority.controller.MyAuthorityController;
import com.lh.authority.model.MySystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author 梁昊
 * @date 2019/4/22
 * @function
 * @editLog
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyAuthorityControllerTest {
    @Autowired
    Gson gson;
    @Autowired
    MyAuthorityController myAuthorityController;

    @Test
    public void selectMySystemNameList(){
        System.out.println(gson.toJson(myAuthorityController.selectMySystemNameList("001")));
    }
}