package com.study.model.dao;

import com.study.pojo.Route;
import com.study.pojo.Saledetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author JRJ
 * @Date 2021/10/29 11:25
 */
@Repository
public interface routeDao extends CrudRepository<Saledetail,Integer> {
}
