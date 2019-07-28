package NettyDemo.server;

import NettyDemo.info.HostInfo;
import NettyDemo.json.JsonDecoder;
import NettyDemo.json.JsonEcoder;
import NettyDemo.server.handler.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

import static NettyDemo.info.HostInfo.MyPort;
import static java.awt.SystemColor.info;


/*.SO_BACKLOG   1024    构造套接字ServerSocekt对象
  .SO_KEEPALIVE true
  .TCP_NODELAY  true
  基础的线程池和网络连接的配置项
* */
public class NettyServer {
    //1.线程池的重要性：
    //2.Netty中的线程池分为两类： 主线程池   接受客户端连接
    //                           工作线程池 处理客户端连接
    public void run() throws InterruptedException {
        EventLoopGroup  bossGroup=new NioEventLoopGroup(10);//定义 主线程池
        EventLoopGroup  workGroup=new NioEventLoopGroup(20);//定义 工作线程池
//        System.out.println("服务器启动成功,监听端口为:"+MyPort);
//        服务器端的 NIO启动
//        使用什么线程池 设置channel
        try {
            ServerBootstrap serverBootstrap=new ServerBootstrap();//服务器端
            serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class);//当前线程池 和 channel
            //设置子处理器
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(65536,0,4,0,4));
                    socketChannel.pipeline().addLast(new JsonDecoder());
                    socketChannel.pipeline().addLast(new LengthFieldPrepender(4));
                    socketChannel.pipeline().addLast(new JsonEcoder());
                    socketChannel.pipeline().addLast(new NettyServerHandler());//追加了处理器？？
                }
            });
            serverBootstrap.option(ChannelOption.SO_BACKLOG,128);
            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture channelFuture=serverBootstrap.bind(9988).sync();//服务器异步创建绑定
            System.out.println(NettyServer.class+"已连接，开始监听："+channelFuture.channel().localAddress());
            channelFuture.channel().closeFuture().sync();
            System.out.println("任务结束");
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }


}
//    private final int PORT=9999;
//    private EventLoopGroup bossGroup;
//    private EventLoopGroup workerGroup;
//    private ServerBootstrap serverBootstrap;
//
//    public NettyServer() {
//        this.bossGroup =new NioEventLoopGroup(10);//默认为1
//        this.workerGroup =new NioEventLoopGroup(20);
//        this.serverBootstrap=new ServerBootstrap();
//    }
//
//    public void start(){
//        try {
//            start(PORT);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    private void start(int port) throws InterruptedException {//
//        //设定线程组 channel
//        try {
//            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class);
//            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
//                protected void initChannel(SocketChannel socketChannel) throws Exception {
//                    socketChannel.pipeline().addLast(new NettyServerHandler());
//                }
//            });
//            serverBootstrap.option(ChannelOption.SO_BACKLOG,1024);//
//            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);
//            ChannelFuture channelFuture=serverBootstrap.bind(port).sync();//绑定端口号
//            channelFuture.channel().closeFuture().sync();
//        }finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//    }
//}
