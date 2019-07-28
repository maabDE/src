package NettyDemo.client.handler;

import NettyDemo.dao.user;
import NettyDemo.entity.Message;
import NettyDemo.entity.User;
import NettyDemo.entity.chatRoomType;
import NettyDemo.entity.chatRoomType;
import NettyDemo.server.handler.NettyServerHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import NettyDemo.service.IMP.*;

import java.util.Scanner;

/*处理数据的读取
 * */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("*----Netty聊天室----");
        while (true) {
            System.out.println("*请选择功能： 1.注册 2.登陆 ");
            Scanner scanner = new Scanner(System.in);
            int type = scanner.nextInt();
            if (type == 1) {
                System.out.println("*注册 请输入用户名和密码：");
                Scanner sc = new Scanner(System.in);
                String uName = sc.nextLine();
                String uPswd = sc.nextLine();
                User user1 = new User(uName, uPswd);
                UserServiceIMP U = new UserServiceIMP();
                if (!U.registerUser(user1)) {//注册
                    System.out.println("*注册失败");
                    break;
                }
                chatRoomType chatmsg=new chatRoomType(1,user1);
                System.out.println("*注册成功");
                ctx.writeAndFlush(chatmsg);
                continue;
                //UserServiceIMP uimp=new UserServiceIMP()
//            user user=new user();
//            UserServiceIMP.register();//注册
//            //user.insert(uName,uPswd);
//            User user1=new User(uName,uPswd);
//            //chatRoomType chatmsg = new chatRoomType(1,user1);
//            user.select(uName,uPswd);
//            ctx.writeAndFlush(chatmsg);
            }
            if (type == 2) {
                System.out.println("*登陆 请输入用户名和密码");
                Scanner sc=new Scanner(System.in);
                String name=sc.nextLine();
                String password=sc.nextLine();
                User user1=new User(name,password);
                UserServiceIMP U = new UserServiceIMP();
                U.loginUser(user1);
//              chatRoomType chatmsg=new chatRoomType(2,)
            }
        }
    }
    public static Message PriChat(String loginName){//单聊
        String sendName=loginName;
        System.out.println("选择你要发送消息 或 文件 1.消息 2.文件");
        Scanner scanner=new Scanner(System.in);
        int sendtype=scanner.nextInt();
        System.out.println("你的消息要发给谁： ");
        String recName=null;
        Scanner scanner1=new Scanner(System.in);
        recName=scanner1.nextLine();
        if (sendtype==1){//发消息
            System.out.println("请输入你要发送消息内容：");
            Scanner scanner2=new Scanner(System.in);
            String msg=scanner2.nextLine();
            NettyDemo.entity.Message message=
                    new NettyDemo.entity.Message(1,1,msg,recName,sendName);
            System.out.println("消息已发送！");
            return message;
        }
        if (sendtype==2){//发文件

        }
        return null;
    }
    public static void groupChat(){//群聊

    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            chatRoomType chatmsg = (chatRoomType) msg;
            int state = chatmsg.getState();
            if (state == 0) {
                String err = chatmsg.getError();
                System.out.println(err);
                //重新输入 用户名 密码
            } else if (state == 1) {//发送聊天消息   发给谁 / 发什么 / 发送内容

            }
        } finally {
            ReferenceCountUtil.release(msg);//释放缓存
        }

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
