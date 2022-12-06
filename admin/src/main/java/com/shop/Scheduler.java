package com.shop;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shop.dto.Msg;

@Component
public class Scheduler {
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@Scheduled(cron = "*/15 * * * * *")
	public void myScheduler2() {
		System.out.println("Start My Scehduler 2.....");
		Random r = new Random();
		int n1 = r.nextInt(100)+1;
		int n2 = r.nextInt(100)+1;
		
    	Msg msg = new Msg();
    	msg.setSendid("Server");
    	msg.setReceiveid("All");
    	msg.setContent1(n1+"");
    	msg.setContent2(n2+"");
    	messagingTemplate.convertAndSend("/broadcast", msg);
		
		System.out.println("End My Scehduler 2.....");
	}
	
}
