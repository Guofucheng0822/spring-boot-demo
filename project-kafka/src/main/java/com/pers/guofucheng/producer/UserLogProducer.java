package com.pers.guofucheng.producer;
 
import com.alibaba.fastjson.JSON;
import com.pers.guofucheng.pojo.UserLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
 
/**
 * @Author 18011618
 * @Description
 * @Date 14:43 2018/7/20
 * @Modify By
 */
@Component
public class UserLogProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
 
    /**
     * 发送数据
     * @param userid
     */
    public void sendLog(String userid){
        UserLog userLog = new UserLog();
        userLog.setUserName("jhp").setUserId(userid).setState("0");
        System.out.println("发送用户日志数据:"+userLog);
        kafkaTemplate.send("user-log", JSON.toJSONString(userLog));
    }
}