package com.kiba.k_framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kiba.k_framework.entity.Kiba_User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Kiba_UserMapper extends BaseMapper<Kiba_User> {
    @Select("select * from Kiba_User")
    List<Kiba_User> test();
    @Select("select * from Kiba_User where id=#{value}")
    List<Kiba_User> test2(Integer id);

    List<Kiba_User> test3(Integer id);
}
