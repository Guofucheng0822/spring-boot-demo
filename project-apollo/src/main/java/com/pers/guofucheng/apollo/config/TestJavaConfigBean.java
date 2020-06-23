package com.pers.guofucheng.apollo.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * 测试Java Bean配置
 *
 * @author guofucheng
 * @date 2020/06/18
 */
public class TestJavaConfigBean {
  @Value("${qrCode.img.path:aaaaaaa}")
  private String timeout;
  private int batch;
 
  @Value("${batch:200}")
  public void setBatch(int batch) {
    this.batch = batch;
  }
 
  public String getTimeout() {
    return timeout;
  }
 
  public int getBatch() {
    return batch;
  }
}