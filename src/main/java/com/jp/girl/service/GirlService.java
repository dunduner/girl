package com.jp.girl.service;


import com.jp.girl.dao.GirlDao;
import com.jp.girl.entity.Girl;
import com.jp.girl.enums.ResultEnum;
import com.jp.girl.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 同时添加2个girl   运用事务  commit或者rollback
 */
@Service
public class GirlService {

    @Autowired
    private GirlDao girlDao;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(22);
        girlDao.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BB");
        girlB.setAge(33);
        girlDao.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlDao.getOne(id);
        Integer age = girl.getAge();
        if (age<10){
            //返回你还在上小学吧  code=100
            throw new GirlException(ResultEnum.XIAOXUE);
        }else if(age>10  && age<18){
            //你可能在上初中吧 code =101
            throw new GirlException(ResultEnum.CHUZHONG);
        }else if(age>18){
            //上大学了/*TODO*/

        }
    }

    /**
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
       return girlDao.findOne(id);
    }

}

