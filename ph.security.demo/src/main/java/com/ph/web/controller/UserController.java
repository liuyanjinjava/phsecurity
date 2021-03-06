package com.ph.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ph.dto.User;
import com.ph.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition, @PageableDefault(page=2,size=17,sort = "username,asc") Pageable pageable){
       //通过commons.lang的工具类来进行相应的处理
        System.out.println(ReflectionToStringBuilder
                .toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());

     List<User> users=new ArrayList<>();
     users.add(new User());
     users.add(new User());
     users.add(new User());
     return users;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
      User user=new User();
      user.setUsername("tom");
      return user;
    }


}
