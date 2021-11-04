package com.study.controller;

import com.study.pojo.Route;
import com.study.pojo.Saledetail;
import com.study.service.routeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JRJ
 * @Date 2021/10/28 21:21
 */
@RestController
@RequestMapping("/route")
@CrossOrigin
public class routeController {
    @Autowired
    private routeService routeService;

    @GetMapping("/selectAllRoute")
    public List<Route> selectAllRoute(){
        return routeService.selectAllRoute();
    }
    @GetMapping("/InsertSaleDetail")
    public Integer InsertSaleDetail(@RequestParam("startStations") String startStations,
                                    @RequestParam("endStations") String endStations,
                                    @RequestParam("salPrice") Integer salPrice,
                                    @RequestParam("payWay") String payWay){
        return routeService.InsertSaleDetail(startStations, endStations,salPrice, payWay);
    }
    @PostMapping("InsertSale")
    public Integer InsertSale(@RequestBody Saledetail saledetail){
        return routeService.InsertSale(saledetail);
    }
}
