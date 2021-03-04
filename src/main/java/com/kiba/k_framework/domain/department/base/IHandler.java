package com.kiba.k_framework.domain.department.base;

import com.kiba.k_framework.dto.base.BaseResult;
import org.apache.ibatis.session.SqlSession;

public interface IHandler {
    public BaseResult Excute(String commandJson, SqlSession sqlSession);
}
