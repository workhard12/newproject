package com.study.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author JRJ
 * @Date 2021/10/28 21:11
 */
@Entity
public class Saledetail {
    private Integer salId;
    private Timestamp salTime;
    private String startStations;
    private String endStations;
    private Integer salPrice;
    private String payWay;

    @Id
    @Column(name = "sal_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
    }

    @Basic
    @Column(name = "sal_time", nullable = true)
    public Timestamp getSalTime() {
        return salTime;
    }

    public void setSalTime(Timestamp salTime) {
        this.salTime = salTime;
    }

    @Basic
    @Column(name = "start_stations", nullable = true, length = 255)
    public String getStartStations() {
        return startStations;
    }

    public void setStartStations(String startStations) {
        this.startStations = startStations;
    }

    @Basic
    @Column(name = "end_stations", nullable = true, length = 255)
    public String getEndStations() {
        return endStations;
    }

    public void setEndStations(String endStations) {
        this.endStations = endStations;
    }

    @Basic
    @Column(name = "sal_price", nullable = true)
    public Integer getSalPrice() {
        return salPrice;
    }

    public void setSalPrice(Integer salPrice) {
        this.salPrice = salPrice;
    }

    @Basic
    @Column(name = "pay_way", nullable = true, length = 255)
    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Saledetail that = (Saledetail) o;
        return Objects.equals(salId, that.salId) &&
                Objects.equals(salTime, that.salTime) &&
                Objects.equals(startStations, that.startStations) &&
                Objects.equals(endStations, that.endStations) &&
                Objects.equals(salPrice, that.salPrice) &&
                Objects.equals(payWay, that.payWay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salId, salTime, startStations, endStations, salPrice, payWay);
    }
}
