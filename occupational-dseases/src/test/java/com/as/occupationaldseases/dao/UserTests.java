package com.as.occupationaldseases.dao;

import com.as.occupationaldseases.domain.user.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
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
    public void testLike(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like(StringUtils.isNotBlank(user.getName()), "NAME", user.getName());
//        queryWrapper.likeLeft(StringUtils.isNotBlank(user.getName()), "NAME", user.getName());
        queryWrapper.likeRight(StringUtils.isNotBlank(user.getName()), "NAME", user.getName());
        List<User> userList = userMapper.selectList(queryWrapper);
        //like查询是使用的默认方式，也就是说在查询条件的左右两边都有%：NAME = ‘%王%’；
        //如果只需要在左边或者右边拼接%，可以使用likeLeft或者likeRight方法。

/*        like方法有三个参数：

        第一个参数：该参数是一个布尔类型，只有该参数是true时，才将like条件拼接到sql中；本例中，如果name字段不为空，则拼接name字段的like查询条件；
        第二个参数：该参数是数据库中的字段名；
        第三个参数：该参数值字段值；*/
    }


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
