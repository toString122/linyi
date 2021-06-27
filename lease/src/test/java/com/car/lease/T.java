package com.car.lease;

import com.car.lease.mapper.UserMapper;
import com.car.lease.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class T {
    
    @Autowired
    UserMapper userMapper;

    @Test
    void y(){
        List<User> userA = userMapper.getUserA();
        System.out.println("userA = " + userA);
    }
}
