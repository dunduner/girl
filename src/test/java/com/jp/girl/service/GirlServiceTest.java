package com.jp.girl.service;

import com.jp.girl.GirlApplicationTest;
import com.jp.girl.dao.GirlDao;
import com.jp.girl.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Zhangning on 2017/4/8.
 */
public class GirlServiceTest extends GirlApplicationTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void insertTwo() throws Exception {

    }

    @Test
    public void getAge() throws Exception {

    }

    @Test
    public void findOneTest() throws Exception {
       Girl girl =  girlService.findOne(27);
        Assert.assertEquals(new Integer(7),girl.getAge());
        System.out.println(girl);
    }

}