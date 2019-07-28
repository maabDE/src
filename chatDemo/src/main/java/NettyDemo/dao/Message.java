package NettyDemo.dao;

import java.util.List;

public class Message {
    int sendType;// 默认0：无意义 1：私聊 2： 群聊
    int msgType;// 默认0：无意义 1：普通消息 2：文件消息类型
    String msg;// 普通消息类型
    byte[] file;//存放文件
    int len; //保存文件大小
    String RCVname; //接收方
    String SEDname; //发送方
      //消息插入sql  select msgType,msg,file,len,SEDname from Message where RCVname=user;
     //离线消息 添加字段 判断是否为离线消息
    int offLine;
    public List<Message> selectMSGRecord(){//聊天记录
        return null;
    }
    //select msgType,sendName,msg,file,fileLength from msg where receiveName =username  and offLine =1;
    public Message selectOnLineMsg(){
        //1.查询是否有离线消息
        return  null;
    }
}
