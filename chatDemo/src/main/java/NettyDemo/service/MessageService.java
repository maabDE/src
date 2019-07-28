package NettyDemo.service;

import NettyDemo.dao.Message;

import java.util.List;

public interface MessageService {
    public List<Message> selectMsg(String name);
//Mysql
    public boolean insertMsg(Message msg);
}
