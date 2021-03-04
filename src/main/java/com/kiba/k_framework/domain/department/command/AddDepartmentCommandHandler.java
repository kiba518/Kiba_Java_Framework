package com.kiba.k_framework.domain.department.command;

import com.kiba.k_framework.domain.department.base.IHandler;
import com.kiba.k_framework.dto.base.BaseResult;
import org.apache.ibatis.session.SqlSession;

public class AddDepartmentCommandHandler implements IHandler {
    @Override
    public BaseResult Excute(String commandJson, SqlSession sqlSession) {
        BaseResult br= new BaseResult();
        br.setMessage("abc123");
        return br;
    }
}
