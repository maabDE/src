package NettyDemo.service;

import NettyDemo.dao.Message;
import NettyDemo.entity.User;

import java.util.List;

/*
1.有离线消息
2.离线消息存放*/
public interface offlineMsg {
    public boolean insertOfflineMsg(Message msg);

    public List<Message> selectOfflineMsg(String name);
}
