package com.shop.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.shop.dto.Msg;
import com.shop.frame.ChatBotUtil;



@Controller
public class ChatBotController {
	
	@Autowired
	SimpMessagingTemplate template;
	
	@MessageMapping("/chatbotme") // 나에게만 전송 ex)Chatbot
	public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) throws IOException {
		String id = msg.getSendid();
		msg.setContent2("TR Message");
		String result = ChatBotUtil.chat(msg.getContent1());
		msg.setContent1(result);
		template.convertAndSend("/send/"+id,msg);
	}
	
}
