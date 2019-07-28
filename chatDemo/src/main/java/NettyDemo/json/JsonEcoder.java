package NettyDemo.json;

import NettyDemo.dao.Message;
import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class JsonEcoder extends MessageToByteEncoder<Object> {
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        byte[] bytes=JSON.toJSONBytes(o);
        byteBuf.writeBytes(bytes);
    }
}
