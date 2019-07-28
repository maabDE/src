package NettyDemo.client;

import NettyDemo.client.handler.NettyClientHandler;
import NettyDemo.json.JsonDecoder;
import NettyDemo.json.JsonEcoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.util.Locale;

import static NettyDemo.info.HostInfo.MyHost;
import static NettyDemo.info.HostInfo.MyPort;

public class NettyClient {
    public void run() throws Exception {
        EventLoopGroup group=new NioEventLoopGroup();//创建NIO线程池
        Bootstrap client =new Bootstrap();//创建Netty 客户端
        client.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY,true)//允许接受大块的返回数据
        .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
               socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(65536,0,4,0,4));
               socketChannel.pipeline().addLast(new JsonDecoder());
               socketChannel.pipeline().addLast(new LengthFieldPrepender(4));
               socketChannel.pipeline().addLast((ChannelHandler) new JsonEcoder());
                   socketChannel.pipeline().addLast(new NettyClientHandler());//追加了处理器
            }
        });
        ChannelFuture channelFuture=client.connect(MyHost,MyPort).sync();
        System.out.println("与服务器连接成功");
        channelFuture.channel().closeFuture().sync();//关闭通道
        group.shutdownGracefully();
    }

}
//    private final int PORT=9999;
//    private final String Host="127.0.0.1";
//    private EventLoopGroup clientLoopGroup;
//    private Bootstrap clientBootstrap;
//
//    public NettyClient() {
//        this.clientLoopGroup =new NioEventLoopGroup();//创建一个线程池
//        this.clientBootstrap =new Bootstrap();//创建客户端
//    }
//    public void start() throws InterruptedException {
//        start(Host,PORT);
//    }
//    private void start(String host,int port) throws InterruptedException {
//       try {
//           clientBootstrap.group(clientLoopGroup)
//                   .channel(NioSocketChannel.class)
//                   .option(ChannelOption.TCP_NODELAY,true)
//                   .handler(new ChannelInitializer<SocketChannel>() {
//                       protected void initChannel(SocketChannel socketChannel) throws Exception {
//                           socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(65536,4,0,4,0));
//                           socketChannel.pipeline().addLast(new LengthFieldPrepender(4));
//                           socketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
//                           socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
//                           socketChannel.pipeline().addLast(new NettyClientHandler());
//                       }
//                   });
//           ChannelFuture channelFuture=clientBootstrap.connect(Host,port).sync();
//           channelFuture.channel().closeFuture().sync();
//       }finally {
//           clientLoopGroup.shutdownGracefully();
//       }
//    }
//}
