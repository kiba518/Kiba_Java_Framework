package com.kiba.k_framework.controller;

import com.kiba.k_framework.domain.department.base.IHandler;
import com.kiba.k_framework.domain.department.command.AddDepartmentCommandHandler;
import com.kiba.k_framework.dto.base.BaseResult;
import com.kiba.k_framework.entity.Kiba_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController
{
    @Autowired
    private ConcurrentMapCacheManager cacheManager;
    //http://localhost:8088/TestPathVariable/test/518
    @PostMapping(value = "/hello/TestPathVariable/{id}")
    public String TestPathVariable(@PathVariable(value = "id")Integer id){
        return "我的ID："+id;
    }
    //http://localhost:8088/hello/TestRequestParam?id=518
    //或http://localhost:8088/hello/TestRequestParam 然后post发送参数id等于518 @RequestParam都接受，post优先
    @PostMapping(value = "/hello/TestRequestParam")
    public String TestRequestParam(@RequestParam("id")Integer id){
        return "我的ID："+id;
    }
    //http://localhost:8088/hello/TestRequestBody
    //post发送{"id":518,"name":"kiba"} ——json格式发送
    @PostMapping(value = "/hello/TestRequestBody")
    public String TestRequestBody(@RequestBody Kiba_User user){
        System.out.println(user);
        return "GetUser";
    }
    //http://localhost:8088/hello/GetName
    @RequestMapping(value = "/hello/GetName", method = RequestMethod.GET)
    public String GetName(HttpServletRequest request, HttpServletResponse resp)
    {
        return "I am Kiba518";
    }
    //设置该注解后，第二次请求会从缓存取数据，默认Cacheable不支持过期时间
    //可以在数据变化时双更或双删缓存数据（使用cache.evict），或更改bean里的ConcurrentMapCacheManager对象，让他支持过期时间
    @Cacheable(cacheNames = "helloCache", key = "#id")
    @RequestMapping(value = "/hello/SetCache", method = RequestMethod.GET)
    public String SetCache(@RequestParam(value = "id",defaultValue = "") int id, HttpServletRequest request, HttpServletResponse resp)
    {
        return "我的ID："+id;
    }

    @GetMapping("/hello/GetCache")
    public String GetCache(){
        Cache demoCache = cacheManager.getCache("helloCache");
        System.out.println(demoCache.getName());
        System.out.println(demoCache.get(518, String.class));
        return demoCache.getName();
    }



}
