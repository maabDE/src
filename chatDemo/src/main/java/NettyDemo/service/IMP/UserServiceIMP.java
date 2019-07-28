package NettyDemo.service.IMP;

import NettyDemo.entity.User;
import NettyDemo.server.NettyServer;
import NettyDemo.server.handler.NettyServerHandler;
import NettyDemo.service.UserService;
import NettyDemo.dao.user;
import io.netty.channel.ChannelHandlerContext;

import java.nio.channels.Channel;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * 描述:用户服务，主要管理用户的登录，名字和密码管理，离线消息管理，用户上下线管理等
 */
public class UserServiceIMP implements UserService {
    public PreparedStatement pst;
    public UserServiceIMP() {
    }
    public UserServiceIMP(PreparedStatement pst) {
        this.pst = pst;
    }

    public  boolean registerUser(User user) {
        boolean result =false;
//        System.out.println("用户注册:请输入用户名和密码: ");
//        Scanner sc=new Scanner(System.in);
//        String name=sc.nextLine();
//        String password=sc.nextLine();
        String name=user.getName();
        String password=user.getPswd();
        user user1=new user();
        System.out.println("sql 注册用户");
        if (user1!=null){
//            System.out.println("用户注册成功");
            user1.insert(name,password);
            result=true;
        }
        else {
            System.out.println("用户名已存在1");
        }
        /*1. 判断是否重复
        2.插入注册User MySQL的访问
        * */
        return result;
    }

    public boolean loginUser(User user) {
        /*1.是否登陆成功 select * from user where name=? and pswd =?
        2.聊天
        * */
        boolean flag=false;
        String name=user.getName();
        String password=user.getPswd();
        user user1=new user();
        System.out.println("sql登陆");
        if (user1!=null) {
            try {
                user1.select(name, password);
                //向服务器发送 用户A登陆
//                NettyServerHandler s=new NettyServerHandler();
//                s.channelActive(user1);
                MSGIMP msg = new MSGIMP();
                msg.selectMsg(user.getName());
                flag = true;
            }catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return flag;
    }
}
