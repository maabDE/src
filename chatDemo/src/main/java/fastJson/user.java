package fastJson;

import lombok.Data;

@Data//默认自带 get/set
public class user {
    String name;
    String pswd;
    int age;

    public user(String name, String pswd, int age) {
        this.name = name;
        this.pswd = pswd;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", pswd='" + pswd + '\'' +
                ", age=" + age +
                '}';
    }
}
