package NettyDemo.clientHandlerUsessless;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.util.Scanner;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg); 客户端给服务器发消息
//        scanner
        try {
        ByteBuf readBuf=(ByteBuf) msg;
        String readData=readBuf.toString(CharsetUtil.UTF_8).trim();
//        if ("exit".equalsIgnoreCase(readData)){
               if (readData.equalsIgnoreCase("exit")){
            System.out.println("再见！");
            ctx.close();
        }
            System.out.println("服务器响应内容"+readData);
            String inputData="输入";
            byte[] bytes=inputData.getBytes();
            ByteBuf sendBuf=Unpooled.buffer(bytes.length);
            sendBuf.writeBytes(bytes);
            ctx.writeAndFlush(sendBuf);
        }
        finally {
            ReferenceCountUtil.release(msg);//释放msg缓存
        }
    }
    public String send(){
        System.out.println("请输入要发送到客户端的消息：");
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s=scanner.nextLine();
            return s;
        }
        return null;
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
        // super.exceptionCaught(ctx, cause);
    }
}
