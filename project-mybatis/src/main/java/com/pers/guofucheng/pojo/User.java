package com.pers.guofucheng.pojo;

import java.util.List;

/**
 * 用户
 *
 * @author guofucheng
 * @date 2020/08/25
 */
public class User {
    /**
     * 主键id
     */
    private int uid;
    /**
     * 名称
     */
    private String uname;
    /**
     * 年龄
     */
    private int uage;
    /**
     * 公共外键id
     */
    private int foreignId;

    /**
     * 1:1 用户卡片
     */
    private UserCard userCard;

    /**
     * 1:n 课程列表
     */
    private List<Course> courseList;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public int getForeignId() {
        return foreignId;
    }

    public void setForeignId(int foreignId) {
        this.foreignId = foreignId;
    }

    public UserCard getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uage=" + uage +
                ", foreignId=" + foreignId +
                ", userCard=" + userCard +
                ", courseList=" + courseList +
                '}';
    }
}