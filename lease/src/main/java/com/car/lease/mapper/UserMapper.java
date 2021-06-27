package com.car.lease.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.car.lease.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 自定义sql写法 传统mybatis
     * @return
     */
    List<User> getUserA();
}
