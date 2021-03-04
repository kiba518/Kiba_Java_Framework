package com.kiba.k_framework.domain.user.query;

import com.kiba.k_framework.domain.department.base.IHandler;

import com.kiba.k_framework.dto.user.query.GetUserQueryReuslt;
import com.kiba.k_framework.entity.Kiba_User;
import com.kiba.k_framework.mapper.Kiba_UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class GetUserQueryHandler implements IHandler
{

    @Override
    public GetUserQueryReuslt Excute(String commandJson, SqlSession sqlSession) {
        Kiba_UserMapper mapper = sqlSession.getMapper(Kiba_UserMapper.class);
        List<Kiba_User> users = mapper.test();
        GetUserQueryReuslt ret=new GetUserQueryReuslt();
        ret.setUsers(users);
        ret.setSuccess(true);
        return ret;
    }
}
