package com.study.model.mapper;

import com.study.pojo.Route;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author JRJ
 * @Date 2021/10/28 21:12
 */
@Component
@Mapper
public interface routeMapper {
    //查询所有的站
    List<Route> selectAllRoute();
    //新增一条售票记录
    Integer InsertSaleDetail(@Param("salTime") Timestamp salTime,
                             @Param("startStations") String startStations,
                             @Param("endStations") String endStations,
                             @Param("salPrice") Integer salPrice,
                             @Param("payWay") String payWay);
}
