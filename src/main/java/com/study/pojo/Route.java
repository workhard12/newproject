package com.study.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @Author JRJ
 * @Date 2021/10/28 21:11
 */
@Entity
public class Route {
    private Integer rId;
    private String startStation;
    private Integer startno;
    private String endStation;
    private Integer endno;

    @Id
    @Column(name = "r_id", nullable = false)
    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    @Basic
    @Column(name = "start_station", nullable = true, length = 255)
    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(rId, route.rId) &&
                Objects.equals(startStation, route.startStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rId, startStation);
    }

    @Basic
    @Column(name = "startno", nullable = true)
    public Integer getStartno() {
        return startno;
    }

    public void setStartno(Integer startno) {
        this.startno = startno;
    }

    @Basic
    @Column(name = "end_station", nullable = true, length = 255)
    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    @Basic
    @Column(name = "endno", nullable = true)
    public Integer getEndno() {
        return endno;
    }

    public void setEndno(Integer endno) {
        this.endno = endno;
    }
}
