package NettyDemo.service.IMP;

import NettyDemo.dao.Message;
import NettyDemo.service.MessageService;
import NettyDemo.client.handler.NettyClientHandler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static NettyDemo.client.handler.NettyClientHandler.PriChat;
import static NettyDemo.client.handler.NettyClientHandler.groupChat;

/*
* 单聊  群聊
* 聊天  发送文件*/
public class MSGIMP implements MessageService {
    String LoginName=null;
    byte[] send=new byte[1024];
    public List<Message> selectMsg(String name) {
        LoginName=name;
        System.out.println("请选择: 1.私聊 2.群聊");
        Scanner scanner=new Scanner(System.in);
        int type=scanner.nextInt();
        switch (type){
            case 1:
                //单聊
                PriChat(LoginName);
            case 2:
                //群聊
                groupChat();
            default:
            System.out.println("输入错误");
            break;
        }
        return null;
    }

    public boolean insertMsg(Message msg) {
        return false;
    }

}
