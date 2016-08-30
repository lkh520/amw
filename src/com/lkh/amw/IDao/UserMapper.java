package com.lkh.amw.IDao;

import org.springframework.aop.SpringProxy;
import org.springframework.dao.DataIntegrityViolationException;

import com.lkh.amw.pojo.User;

public interface UserMapper extends SpringProxy {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record) throws DataIntegrityViolationException;

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectId(int id);

	User selectLogin(String username);

}