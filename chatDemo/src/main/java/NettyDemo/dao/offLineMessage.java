package NettyDemo.dao;

import java.util.List;

/*离线消息
* */
public class offLineMessage {
    int msgType;// 默认0：无意义 1：普通消息 2：文件消息类型
    String msg;// 普通消息类型
    byte[] file;//存放文件
    int len; //保存文件大小
    String RCVname; //接收方
    String SEDname; //发送方
    int offline;//是否为离线
    //select msgType,msg,file,SEDname where RCVname=userName and offline =1;
    public List<Message> selectMSGOffline(){
        //查询是否有离线消息 整理msg
        return null;
    }
}
