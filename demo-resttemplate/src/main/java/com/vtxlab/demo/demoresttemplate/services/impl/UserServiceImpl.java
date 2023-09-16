package com.vtxlab.demo.demoresttemplate.services.impl;

import java.util.List;
import com.vtxlab.demo.demoresttemplate.model.User;

public interface UserServiceImpl {
  public List<User> findAllUsers();

    public User findUser(int id);

}
