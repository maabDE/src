package com.tulun.tuluntest.entity;

/**
 * Created by DSB on 2019/7/19
 */
public class User {
    private String Name;
    private int age;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        Name = name;
        this.age = age;

    }
}
