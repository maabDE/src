package NettyDemo.service.IMP;

import NettyDemo.dao.Message;
import NettyDemo.service.offlineMsg;

import java.util.List;

public class offlineMsgServiceIMP implements offlineMsg {


    public boolean insertOfflineMsg(Message msg) {
        return false;
    }

    public List<Message> selectOfflineMsg(String name) {
        return null;
    }
}
