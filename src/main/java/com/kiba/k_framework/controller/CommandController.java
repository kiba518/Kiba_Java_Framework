package com.kiba.k_framework.controller;

import com.kiba.k_framework.dto.base.BaseCommand;

import com.kiba.k_framework.dto.base.BaseResult;
import com.kiba.k_framework.entity.Kiba_User;

import com.kiba.k_framework.mapper.Kiba_UserMapper;
import com.kiba.k_framework.utility.ReflexHelper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import  com.kiba.k_framework.dto.*;
import java.lang.ClassNotFoundException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;



@RestController
@RequestMapping("/Command")
public class CommandController
{
   /* @Autowired
    private Kiba_UserMapper mapper;*/
   /* @Autowired
    private SqlSessionTemplate sqlSessionTemplate;*/
    @Autowired
    private SqlSession sqlSession;

    @RequestMapping(value = "/Get", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult Get(String commandName,String commandJson) throws Exception {
        //List<Kiba_User> users = mapper.test();
        System.out.println(commandName);
        Set<Class<?>> classes = ReflexHelper.getClasses("com.kiba.k_framework.dto");
        String newName ="";
        for(Class c:classes){
            String fullName = c.getName();
            System.out.println(fullName);
            String className = fullName.substring(fullName.lastIndexOf(".")+1,fullName.length());
            System.out.println(className);
            if(className.equals(commandName)) {
                newName = fullName.replace(".dto.", ".domain.") + "Handler";
                System.out.println(newName);
                break;
            }
        }

        Class<?> clazz = Class.forName(newName);
        Method method = clazz.getMethod("Excute", String.class,SqlSession.class);
        BaseResult ret = (BaseResult)method.invoke(clazz.newInstance(), commandJson,sqlSession);
        return ret;
    }
    @PostMapping(value = "/Post")
    @ResponseBody
    public BaseResult Post(String commandName,String commandJson) throws Exception {
        System.out.println(commandName);
        Set<Class<?>> classes = ReflexHelper.getClasses("com.kiba.k_framework.dto");
        String newName ="";
        for(Class c:classes){
            String fullName = c.getName();
            System.out.println(fullName);
            String className = fullName.substring(fullName.lastIndexOf(".")+1,fullName.length());
            System.out.println(className);
            if(className.equals(commandName)) {
                newName = fullName.replace(".dto.", ".domain.") + "Handler";
                System.out.println(newName);
                break;
            }
        }

        Class<?> clazz = Class.forName(newName);
        Method method = clazz.getMethod("Excute", String.class,SqlSession.class);
        BaseResult ret = (BaseResult) method.invoke(clazz.newInstance(), commandJson,sqlSession);
        return ret;
    }




}
