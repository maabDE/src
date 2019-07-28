package NettyDemo.json;

import NettyDemo.entity.chatRoomType;
import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class JsonDecoder extends MessageToMessageDecoder<ByteBuf> {
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> list) throws Exception {
        int len=msg.readableBytes();
        byte[] bytes=new byte[len];
        msg.getBytes(msg.readerIndex(),bytes,0,len);
        list.add(JSON.parseObject(new String(bytes),chatRoomType.class));
//        String jsonS=new String(bytes);
//        JSON.parseObject(jsonS,fastJson.user.class);
//        list.add(fastJson.user.class);
    }
}
