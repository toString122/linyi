package com.car.lease.service.impl;

import com.car.lease.pojo.User;
import com.car.lease.mapper.UserMapper;
import com.car.lease.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liwj
 * @since 2021-06-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
