package com.study.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @Author JRJ
 * @Date 2021/10/28 9:36
 */
@Entity
public class Users {
    private Integer uId;
    private String uName;
    private String uPass;
    private Timestamp regTime;
    private Integer balance;
    private List<Chongzhi> chongzhi;

    public Users(Integer uId, String uName, String uPass, Timestamp regTime, Integer balance) {
        this.uId = uId;
        this.uName = uName;
        this.uPass = uPass;
        this.regTime = regTime;
        this.balance = balance;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPass='" + uPass + '\'' +
                ", regTime=" + regTime +
                ", balance=" + balance +
                '}';
    }

    @Id
    @Column(name = "u_id", nullable = false)
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_name", nullable = true, length = 255)
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "u_pass", nullable = true, length = 255)
    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    @Basic
    @Column(name = "reg_time", nullable = true)
    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Basic
    @Column(name = "balance", nullable = true)
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(uId, users.uId) &&
                Objects.equals(uName, users.uName) &&
                Objects.equals(uPass, users.uPass) &&
                Objects.equals(regTime, users.regTime) &&
                Objects.equals(balance, users.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uName, uPass, regTime, balance);
    }

    @OneToMany(mappedBy = "user")
    public List<Chongzhi> getChongzhi() {
        return chongzhi;
    }

    public void setChongzhi(List<Chongzhi> chongzhi) {
        this.chongzhi = chongzhi;
    }
}
