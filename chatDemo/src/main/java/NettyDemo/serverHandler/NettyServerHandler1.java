package NettyDemo.serverHandler;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.util.HashMap;

public class NettyServerHandler1 extends ChannelInboundHandlerAdapter {}//输入输出
//
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {//到达
//        System.out.println("监听到客户端连接"+ctx.channel());
//        //监听到链接事件
//        //super.channelActive(ctx);
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {//处理读事件
//       try {
//           ByteBuf byteBuf=(ByteBuf) msg;
//           String inputDate=byteBuf.toString(CharsetUtil.UTF_8);
//           System.out.println("收到客户端消息"+inputDate);
//           String echo="[echo]"+inputDate;
//           byte[] bytes=echo.getBytes();
//           ByteBuf sendBuf=Unpooled.buffer(echo.getBytes().length);
//           sendBuf.writeBytes(bytes);
//           ctx.writeAndFlush(sendBuf);
//       }finally {
//           ReferenceCountUtil.release(msg);//每次运行完清空msg内容
//       }
//        //super.channelRead(ctx, msg);  msg默认ByteBuffer类型
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {//类似于field
//        cause.printStackTrace();
//        ctx.close();
//    }
//}
