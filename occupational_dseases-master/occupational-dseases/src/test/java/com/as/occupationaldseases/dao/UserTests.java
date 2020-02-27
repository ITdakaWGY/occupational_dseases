package com.as.occupationaldseases.dao;

import com.as.occupationaldseases.domain.user.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
    @Resource
    private UserMapper userMapper;


    @Test
    public void testInsert() {
        User user = new User();
        user.setName("测试01");
        user.setAge(18);
        user.setEmail("测试01@xxx.com");
        user.setAddr("山东省");
        user.setRemark("喝酱油的");

        int insert = userMapper.insert(user);
        Assert.assertEquals(insert, 1);

    }

    @Test
    public void testSelect() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        Assert.assertEquals(2, users.size());
    }

    @Test
    public void queryUserForPage() {
        IPage<User> userPage = new Page<>(0, 2);//参数一是当前页，参数二是每页个数
        userPage = userMapper.selectPage(userPage, null);
        List<User> list = userPage.getRecords();
        for (User user : list) {
            System.out.println(user);
        }
    }

}
