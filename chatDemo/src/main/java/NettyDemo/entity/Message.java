package NettyDemo.entity;

import java.util.Arrays;

/*消息 是私聊/群聊  文件/聊天*/
public class Message {
    int sendType;// 默认0：无意义 1：私聊 2： 群聊
    int msgType;// 默认0：无意义 1：普通消息 2：文件消息类型
    String msg;// 普通消息类型
    byte[] bytesfile;//存放文件
    int len; //保存文件大小
    String receiveName;
    String sendName;
//JSon 的缺点
    //普通消息 无文件
    public Message(int sendType, int msgType, String msg,String receiveName, String sendName) {
        this.sendType = sendType;
        this.msgType = msgType;
        this.msg = msg;
        this.receiveName = receiveName;
        this.sendName = sendName;
    }
    //文件消息
    public Message(int sendType, int msgType, byte[] bytesfile, int len, String receiveName, String sendName) {
        this.sendType = sendType;
        this.msgType = msgType;
        this.bytesfile = bytesfile;
        this.len = len;
        this.receiveName = receiveName;
        this.sendName = sendName;
    }

    public int getSendType() {
        return sendType;
    }

    public void setSendType(int sendType) {
        this.sendType = sendType;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public byte[] getBytesfile() {
        return bytesfile;
    }

    public void setBytesfile(byte[] bytesfile) {
        this.bytesfile = bytesfile;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sendType=" + sendType +
                ", msgType=" + msgType +
                ", msg='" + msg + '\'' +
                ", bytesfile=" + Arrays.toString(bytesfile) +
                ", len=" + len +
                ", receiveName='" + receiveName + '\'' +
                ", sendName='" + sendName + '\'' +
                '}';
    }
}
