package com.kiba.k_framework.domain.user.command;

import com.kiba.k_framework.domain.department.base.IHandler;
import com.kiba.k_framework.dto.base.BaseResult;
import com.kiba.k_framework.mapper.Kiba_UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class AddUserCommandHandler implements IHandler
{
    @Autowired
    private Kiba_UserMapper mapper;
    @Override
    public BaseResult Excute(String commandJson, SqlSession sqlSession) {
        BaseResult br=new BaseResult();
        return br;
    }
}
