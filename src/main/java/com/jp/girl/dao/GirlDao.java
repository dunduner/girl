package com.jp.girl.dao;

import com.jp.girl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlDao extends JpaRepository <Girl,Integer>{

    //通过年龄查询
    public List<Girl> findByCupSize(String cupSize);
}
