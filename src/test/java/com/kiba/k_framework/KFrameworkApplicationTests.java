package com.kiba.k_framework;


import com.kiba.k_framework.controller.CommandController;
import com.kiba.k_framework.controller.HelloController;
import com.kiba.k_framework.domain.user.query.GetUserQueryHandler;
import com.kiba.k_framework.dto.base.BaseResult;
import com.kiba.k_framework.dto.user.query.GetUserQueryReuslt;
import com.kiba.k_framework.entity.Kiba_Department;
import com.kiba.k_framework.entity.Kiba_User;

import com.kiba.k_framework.mapper.Kiba_DepartmentMapper;
import com.kiba.k_framework.mapper.Kiba_UserMapper;
import com.kiba.k_framework.utility.StringHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KFrameworkApplicationTests {

    @Test
    void contextLoads() {
        boolean ret = StringHelper.isEmpty("");
        System.out.println(ret);
    }


    @Test
    void controllerTest2() throws Exception {
        CommandController c = new CommandController();
        BaseResult ret = c.Get("AddDepartmentCommand", "dsa");
        System.out.println(ret);
    }
    @Autowired
    private Kiba_UserMapper um;
    @Autowired
    private Kiba_DepartmentMapper dm;
    @Test
    void mapperTest1() throws Exception {
        List<Kiba_User> ul =  um.test();
        for(Kiba_User u : ul)
        {
            System.out.println(u);
        }

    }
    @Test
    void mapperTest2() throws Exception {
        List<Kiba_User> ul =  um.test2(2);
        for(Kiba_User u : ul)
        {
            System.out.println(u.getName());
        }
    }
    @Test
    void mapperTest3() throws Exception {
        List<Kiba_User> ul =  um.test3(2);
        for(Kiba_User u : ul)
        {
            System.out.println(u);
        }
    }
    @Test
    void mapperTest4() throws Exception {

        List<Kiba_Department> ul =  dm.test(2);
        for(Kiba_Department u : ul)
        {
            System.out.println(u);
        }
    }
}
