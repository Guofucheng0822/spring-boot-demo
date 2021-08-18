package com.pers.guofucheng.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 测试异步服务
 *
 * @author guofucheng
 * @date 2020/09/24
 */
@Service
public class TestAsyncService {
	Logger log = LoggerFactory.getLogger(TestAsyncService.class);

	@PostConstruct
	// 发送提醒短信 1
	@Async("taskExecutor")
	public void service1() throws InterruptedException {
		log.info("--------start-service1------------");
		Thread.sleep(5000); // 模拟耗时
	    log.info("--------end-service1------------");
	}

	@PostConstruct
	// 发送提醒短信 2
	@Async("taskExecutor")
	public void service2() throws InterruptedException {
		
		log.info("--------start-service2------------");
		Thread.sleep(2000); // 模拟耗时
	    log.info("--------end-service2------------");
 
	}
}