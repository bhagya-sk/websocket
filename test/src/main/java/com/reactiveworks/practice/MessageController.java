package com.reactiveworks.practice;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.reactiveworks.practice.model.Greeting;
import com.reactiveworks.practice.model.HelloMessage;

@Controller
public class MessageController {
	
	 @MessageMapping("/hello")
	   @SendTo("/topic/greetings")
	   public Greeting greeting(HelloMessage message) throws Exception {
	      Thread.sleep(1000); // simulated delay
	      return new Greeting("Hello, " + message.getName() + "!");
	   }

}
