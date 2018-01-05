package com.vstaryw.web.service.db.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.vstaryw.web.entity.User;
import com.vstaryw.web.mapper.UserMapper;
import com.vstaryw.web.service.db.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
