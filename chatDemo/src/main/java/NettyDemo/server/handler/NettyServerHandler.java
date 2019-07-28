package NettyDemo.server.handler;

import NettyDemo.dao.user;
import NettyDemo.entity.Message;
import NettyDemo.entity.User;
import NettyDemo.entity.chatRoomType;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Map;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    private Map<String,String> userMap;
    private Map<String,ChannelHandlerContext> channelMap;
    private ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try{
            Channel channel=ctx.channel();
            chatRoomType chatmsg= (chatRoomType) msg;
            int chatType =chatmsg.getChatType();
            if (chatType==0){
                //注册
                User user=chatmsg.getUser();
                String name=user.getName();
                String password=user.getPswd();
                if (userMap.get(user)==null){
                    userMap.put(name,password);
                    //保存 ChannelHandlerContext
                    //
                    System.out.println("测试1 用户："+name+"注册成功");
                    chatmsg.clear();//清理
                    chatmsg.setState(0);
                }
                else {
                    String err0="测试2 用户名重复";
                    chatmsg.clear();
                    chatmsg.setState(3);
                    chatmsg.setError(err0);
                }
            }
            else if (chatType==1){
                //d登陆
                User user=chatmsg.getUser();
                String name=user.getName();
                String password=user.getPswd();
                if ((userMap.containsKey(name)) && (userMap.get(name)==password)){
                    //channelMap.replace();
                    chatmsg.setState(0);
                }else {
                    String err1="测试3 用户名或密码错误";
                    chatmsg.clear();
                    chatmsg.setState(4);
                    chatmsg.setError(err1);
                }
            }
            else if (chatType==2){
                //聊天
                Message message=chatmsg.getMsg();
                String receivename=message.getReceiveName();
                ChannelHandlerContext chc=channelMap.get(receivename);
                ctx=chc;
            }
            ctx.writeAndFlush(chatmsg);
            if (chatType==3){
                //异常
            }
        }finally {
            ReferenceCountUtil.release(msg);//释放缓存
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress()+"已连接");
        channelGroup.add(channel);
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        System.out.println(channel.localAddress()+" 上线了！");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {//客户端断开
        Channel channel=ctx.channel();
        System.out.println(channel.remoteAddress()+" 离线了！");
        boolean flag=false;
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
