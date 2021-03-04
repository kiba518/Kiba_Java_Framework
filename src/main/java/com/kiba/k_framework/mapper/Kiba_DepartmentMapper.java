package com.kiba.k_framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kiba.k_framework.entity.Kiba_Department;
import com.kiba.k_framework.entity.Kiba_User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface Kiba_DepartmentMapper extends BaseMapper<Kiba_Department> {

    List<Kiba_Department> test(Integer id);
}
