package com.ibranco.mybatis.mapper;

import com.ibranco.mybatis.domain.User;
import com.ibranco.mybatis.vo.QueryVo;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    List<User> findByContent(User user);
    List<User> findByContent1(User user);
    List<User> findByContent2(QueryVo vo);
    List<User> findByAnyId(QueryVo vo);
}
