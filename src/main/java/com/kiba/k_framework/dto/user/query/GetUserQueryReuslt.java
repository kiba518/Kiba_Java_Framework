package com.kiba.k_framework.dto.user.query;


import com.kiba.k_framework.dto.base.BaseResult;
import com.kiba.k_framework.entity.Kiba_User;
import lombok.Data;

import java.util.List;
@Data
public class GetUserQueryReuslt extends BaseResult
{
   private List<Kiba_User> users;
}
