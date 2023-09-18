package com.vtxlab.demo.demoresttemplate.services.impl;

import java.util.List;
import com.vtxlab.demo.demoresttemplate.infra.exception.BusinessException;
import com.vtxlab.demo.demoresttemplate.model.User;

public interface UserServiceImpl {
  public List<User> findAllUsers() throws BusinessException;

    public User findUser(int id)throws BusinessException ;

}
