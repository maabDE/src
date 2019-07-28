package fastJson;

import java.util.List;

public class userGroup {
    int id;
    List<user> userList;

    public userGroup(int id, List<user> userList) {
        this.id = id;
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<user> getUserList() {
        return userList;
    }

    public void setUserList(List<user> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "userGroup{" +
                "id=" + id +
                ", userList=" + userList +
                '}';
    }
}
