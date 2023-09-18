package com.vtxlab.demo.demoresttemplate.services;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demo.demoresttemplate.infra.exception.BizCode;
import com.vtxlab.demo.demoresttemplate.infra.exception.BusinessException;
import com.vtxlab.demo.demoresttemplate.infra.exception.JPHException;
import com.vtxlab.demo.demoresttemplate.infra.util.UriScheme;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.services.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {

  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String userDomaine;

  @Value(value = "${api.jsonplaceholder.endpoint.user}")
  private String userEndpoint;

  @Override
  public List<User> findAllUsers() throws BusinessException {
    String url = UriComponentsBuilder.newInstance()//
        .scheme(UriScheme.HTTPS.name())//
        .host(userDomaine)//
        .path(userEndpoint)//
        .toUriString();
    // System.out.println("url : " + url);

    // try {
    User[] users = restTemplate.getForObject(url, User[].class);
    //return Arrays.asList(users);
    // } catch (BusinessException e) {
    throw new JPHException(BizCode.RESOURCE_NOT_FOUND);
    // }
  }

  // restTemplate 用getter only,唔洗深究

  @Override
  public User findUser(int id) throws BusinessException {
    return this.findAllUsers().stream()//
        .filter(e -> e.getId() == id) //
        .findFirst()//
        .orElse(null);
  }
}
