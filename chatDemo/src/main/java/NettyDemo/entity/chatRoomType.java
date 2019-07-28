package NettyDemo.entity;

/* 0 登陆 1 注册  2 聊天  3 error

 * */
public class chatRoomType {
    int chatType; //  0  1   2  3  注册 登陆 聊天  异常
    User user;
    Message msg;
    String error;//异常信息
    int  state;//登陆状态

    public chatRoomType(int chatType, User user) {//注册
        this.user = user;
    }

    public chatRoomType(int chatType, Message msg) {//聊天
        this.msg = msg;
    }

    public chatRoomType(int chatType, String error) {
        this.chatType = chatType;
        this.error = error;
    }

    public chatRoomType(int chatType, User user, Message msg) {
        this.chatType = chatType;
        this.user = user;
        this.msg = msg;
    }
    public void clear(){
        this.chatType=0;
        this.msg=null;
        this.user=null;
        this.error=null;
    }

    public int getChatType() {
        return chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "chatTypeMessage{" +
                "chatType=" + chatType +
                ", user=" + user +
                ", msg=" + msg +
                '}';
    }
}
