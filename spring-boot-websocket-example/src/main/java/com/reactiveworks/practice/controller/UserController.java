package com.reactiveworks.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;

import com.reactiveworks.practice.model.User;
import com.reactiveworks.practice.model.UserResponse;

@Controller
public class UserController {

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/user")
  //@SendTo("/topic/user")
	public void getUser(@Payload User user) {
		// public UserResponse getUser(User user) {
		System.out.println("image");
		template.convertAndSend("/topic/user", new UserResponse(user.getName()));
		// return new UserResponse(user.getName());

	}
	
	@MessageMapping("/image")
	public void getImage(BinaryMessage message) {
		System.out.println("image");
		template.convertAndSend("/topic/user", message);
	}

}