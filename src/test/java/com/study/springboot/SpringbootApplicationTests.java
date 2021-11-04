package com.study.springboot;

import com.github.pagehelper.PageInfo;
import com.study.pojo.Chongzhi;
import com.study.pojo.Users;
import com.study.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class SpringbootApplicationTests {
    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @Test
    public void t1() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的用户名");
            String name = sc.nextLine();
            System.out.println("请输入你的密码");
            String pass = sc.nextLine();
            if ("admin".equals(name) && "admin".equals(pass)) {
                System.out.println("登录成功！");
                this.t2();
            } else {
                System.out.println("请重新输入账号和密码");
            }
        }
    }

    public void t2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的用户名");
        String name = sc.nextLine();
        System.out.println("请输入你要充值的金额");
        int money = sc.nextInt();
        Users users = userService.selectUserByName(name);
        Integer integer = userService.updateUserMoney(money + users.getBalance(), name);
        Users users2 = userService.selectUserByName(name);
        if (integer > 0) {
            System.out.println("充值成功" + "您的卡内余额为" + users2.getBalance() + "元");
        } else {
            System.out.println("充值失败！");
        }
        userService.insertChongzhi(users2.getuId(), new Timestamp(System.currentTimeMillis()), money);
    }

    @Test
    public void t3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的用户名");
        String name = scanner.nextLine();
        Users users = userService.selectUserByName(name);
        System.out.println("用户名\t密码\t\t\t注册时间\t\t\t\t余额");
        System.out.println(users.getuName() + "\t" + users.getuPass() + "\t" + users.getRegTime() + "\t" + users.getBalance());
    }

    @Test
    public void t4() {
        Chongzhi chongzhi = new Chongzhi();
        List<Chongzhi> chongzhis = userService.selectChongzhiMoney(chongzhi.getFillTime(), chongzhi.getSendMoney());
        for (Chongzhi chongzhi1 : chongzhis) {
            System.out.println(chongzhi1);
        }

//        Map <String,Integer>mp= new LinkedHashMap<String,Integer> ();
//        mp.put("1.广州",60);//后面数字出巡广州到赣州的费用，下main依次类推
//        mp.put("2.赣州",30);
//        mp.put("3.南昌",20);
//        mp.put("4.九江",40);
//        mp.put("5.武汉",80);
//        mp.put("6.北京",0);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入起点站:");
//        String startstation = sc.next();
//        System.out.println("请输入终点站:");
//        String endstation = sc.next();
//        Iterator it = mp.entrySet().iterator();
//        int sum = 0;//用来统计费用
////下面用于查找起点站
//        char startnum = 9999;
//        while (it.hasNext())
//        {
//            Map.Entry entry = (Map.Entry) it.next() ;
//            String key = (String) entry.getKey() ;
//            int value = (Integer) entry.getValue() ;
//            if(key.contains(startstation))
//            {
//                sum += value;
//                startnum = key.charAt(0);
//                System.out.println("s:"+startnum);
//            }
//            if((int)key.charAt(0)>(int)startnum)
//            {
//                if(key.contains(endstation))
//                {
//                    break;
//                }
//                sum = sum+value;
//            }
//        }
//        System.out.println("您需要的路费是:"+sum);
    }

    @Test
    public void t5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入页数");
        int no = scanner.nextInt();
        List<Chongzhi> chongzhis = userService.selectAllChongzhi(no, 3);
        for (Chongzhi chongzhi : chongzhis) {
            System.out.println(chongzhi);
        }
    }

    @Test
    public void t6() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format1 = format.format(date);
        System.out.println(format1);
    }
}
