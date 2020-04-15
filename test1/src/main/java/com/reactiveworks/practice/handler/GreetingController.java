package com.reactiveworks.practice.handler;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.reactiveworks.practice.model.Greeting;
import com.reactiveworks.practice.model.HelloMessage;

@Controller
public class GreetingController {
	 @MessageMapping("/hello")
	  @SendTo("/topic/greetings")
	  public Greeting greeting(HelloMessage message) {
	  
	    return new Greeting("Hello user, " +message.getName() );
	  }
}
