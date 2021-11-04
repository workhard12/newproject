package com.study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.model.mapper.UserMapper;
import com.study.pojo.Chongzhi;
import com.study.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author JRJ
 * @Date 2021/10/26 10:07
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<Users> selectAllUser(){
        return userMapper.selectAllUser();
    }
    /**更新用户的金额
 * @param name
     * @return
     * @date  2021年10月28日  10:10:20
     **/
    public Integer updateUserMoney(Integer balance,String name){
        return userMapper.updateUserMoney(balance,name);
    }

    public Users selectUserByName(String name){
       return userMapper.selectUserByName(name);
    }

    public Integer insertChongzhi(Integer uId,Timestamp fillTime, Integer sendMoney){
        return userMapper.insertChongzhi(uId, fillTime, sendMoney);
    }

    public List<Chongzhi> selectChongzhiMoney(Timestamp fillTime,Integer sendMoney){
        return userMapper.selectChongzhiMoney(fillTime, sendMoney);
    }

    public List<Chongzhi> selectAllChongzhi(Integer no,Integer size){
        PageHelper.startPage(no,size);
        return userMapper.selectAllChongzhi(no, size);
    }
}
