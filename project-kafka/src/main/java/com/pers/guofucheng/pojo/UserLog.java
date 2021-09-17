package com.pers.guofucheng.pojo;
 
import lombok.Data;
import lombok.experimental.Accessors;
 
/**
 * @Author 18011618
 * @Description 定义用户发送的日志数据
 * @Date 14:42 2018/7/20
 * @Modify By
 */
@Data
@Accessors(chain = true)
public class UserLog {
    private String userName;
    private String userId;
    private String state;
}