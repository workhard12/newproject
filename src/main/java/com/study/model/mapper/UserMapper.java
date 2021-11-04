package com.study.model.mapper;

import com.study.pojo.Chongzhi;
import com.study.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author JRJ
 * @Date 2021/10/26 9:55
 */
@Component
@Mapper
public interface UserMapper {
    //查找所有的用户
    List<Users> selectAllUser();

    //更新用户的金额
    Integer updateUserMoney(Integer balance,String uName);
    //根据用户名查询用户
    Users selectUserByName(String name);
    //新增一条充值记录
    Integer insertChongzhi(@Param("uId") Integer uId,
                           @Param("fillTime") Timestamp fillTime,
                           @Param("sendMoney") Integer sendMoney);
    //统计用户每个月的充值总金额
    List<Chongzhi> selectChongzhiMoney(@Param("fillTime") Timestamp fillTime,
                                       @Param("sendMoney") Integer sendMoney);
    //查询所有的充值记录
    List<Chongzhi> selectAllChongzhi(@Param("no") Integer no,
                                     @Param("size") Integer size);
}
