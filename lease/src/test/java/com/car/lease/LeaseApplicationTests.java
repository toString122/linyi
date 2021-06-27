package com.car.lease;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.car.lease.mapper.UserMapper;
import com.car.lease.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class LeaseApplicationTests {


    @Autowired
    private UserMapper userMapper;

    /**
     * 无条件查询查询
     */
    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    /**
     * 插入数据
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("123");
        user.setPassword("aaa");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }

    /**
     * 更新数据
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(224);
        user.setUsername("225");
        user.setPassword("aaaaaaa");
        int insert = userMapper.updateById(user);
        System.out.println("insert = " + insert);
    }

    /**
     * 测试乐观锁成功
     */
    @Test
    void lockSuccess(){
        //1.查询用户
        User user = userMapper.selectById(225);
        //2.修改用户信息
        user.setUsername("b");
        //3.更新用户
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);
    }

    /**
     * 条件查询 map
     */
    @Test
    void select0(){
        Map map = new HashMap();
        map.put("username","b");
        List list = userMapper.selectByMap(map);
        System.out.println("list = " + list);
    }

    /**
     * 分页查询
     */
    @Test
    void select1(){
        Page<User> page = new Page<>(1,2); //第一页 两条数据
        Page<User> page1 = userMapper.selectPage(page, null);
        System.out.println("page1 = " + page1);
        long total = page.getTotal();
        System.out.println("总记录数 = " + total);
    }

    /**
     * 物理删除
     */
    @Test
    void delete0(){
        int i = userMapper.deleteById(221);
        System.out.println("i = " + i);
    }

    /**
     * 逻辑删除
     */
    @Test
    void  delete1(){
        int i = userMapper.deleteById(225);
        System.out.println("i = " + i);
    }

    /**
     * 条件构造器  高级查询
     * https://mp.baomidou.com/guide/wrapper.html
     */
    @Test
    void select(){
        //查询ID>=226 并且 username 不为null 并且通过id排序
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("id",226)
                .isNotNull("username")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println("users = " + users);
    }


}
