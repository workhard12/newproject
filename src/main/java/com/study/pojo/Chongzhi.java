package com.study.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author JRJ
 * @Date 2021/10/28 9:36
 */
@Entity
public class Chongzhi {
    private Integer hId;
    private Timestamp fillTime;
    private Integer sendMoney;
    private Users user;

    @Override
    public String toString() {
        return "Chongzhi{" +
                "hId=" + hId +
                ", fillTime=" + fillTime +
                ", sendMoney=" + sendMoney +
                '}';
    }

    public Chongzhi(Integer hId, Timestamp fillTime, Integer sendMoney) {
        this.hId = hId;
        this.fillTime = fillTime;
        this.sendMoney = sendMoney;
    }

    public Chongzhi() {
    }

    @Id
    @Column(name = "h_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    @Basic
    @Column(name = "fill_time", nullable = true)
    public Timestamp getFillTime() {
        return fillTime;
    }

    public void setFillTime(Timestamp fillTime) {
        this.fillTime = fillTime;
    }

    @Basic
    @Column(name = "send_money", nullable = true)
    public Integer getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(Integer sendMoney) {
        this.sendMoney = sendMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chongzhi chongzhi = (Chongzhi) o;
        return Objects.equals(hId, chongzhi.hId) &&
                Objects.equals(fillTime, chongzhi.fillTime) &&
                Objects.equals(sendMoney, chongzhi.sendMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hId, fillTime, sendMoney);
    }

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
