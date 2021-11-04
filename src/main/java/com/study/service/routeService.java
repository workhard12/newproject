package com.study.service;

import com.study.model.dao.routeDao;
import com.study.model.mapper.routeMapper;
import com.study.pojo.Route;
import com.study.pojo.Saledetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author JRJ
 * @Date 2021/10/28 21:19
 */
@Service
public class routeService {
    @Autowired
    private routeMapper routeMapper;
    @Autowired
    private routeDao routeDao;
    public List<Route> selectAllRoute(){
        return routeMapper.selectAllRoute();
    }

    public Integer InsertSaleDetail(String startStations,
                                    String endStations,
                                    Integer salPrice,String payWay
                                    ){
        return routeMapper.InsertSaleDetail(new Timestamp(System.currentTimeMillis()),startStations
                                            ,endStations,salPrice,payWay);
    }

    public Integer InsertSale(Saledetail saledetail){
        Saledetail saledetail1 = new Saledetail();
        saledetail1.setStartStations(saledetail.getStartStations());
        saledetail1.setEndStations(saledetail.getEndStations());
        saledetail1.setPayWay(saledetail.getPayWay());
        saledetail1.setSalPrice(saledetail.getSalPrice());
        saledetail1.setSalTime(new Timestamp(System.currentTimeMillis()));
        routeDao.save(saledetail1);
        return 1;
    }
}
