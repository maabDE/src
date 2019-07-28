package fastJson;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSonTest {
    public static void main(String[] args) {
        user user1=new user("zs","123",18);
        user user2=new user("ls","132",15);
        Object o=JSON.toJSON(user1);
        String s=JSON.toJSONString(user1);
        System.out.println("userJSONObject"+o);
        System.out.println("userJSONString"+s);

        user user=JSON.parseObject(s, fastJson.user.class);
        System.out.println("反序列化之后的结果为："+user);


        List<user> userList=new ArrayList<fastJson.user>();
        userList.add(user1);
        userList.add(user2);
        userGroup userGroup=new userGroup(1,userList);
        System.out.println("userGroup"+userGroup);

       // JSON.parseObject(userGroup, fastJson.userGroup.class);
    }
}
