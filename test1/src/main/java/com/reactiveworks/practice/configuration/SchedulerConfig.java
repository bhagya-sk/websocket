package com.reactiveworks.practice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.reactiveworks.practice.model.Greeting;
@EnableScheduling
@Configuration
public class SchedulerConfig {
	
	@Autowired
	SimpMessagingTemplate template;
	
	@Scheduled(fixedDelay = 3000)
	public void sendMessage() {
		template.convertAndSend("/topic/greetings", new Greeting("scheduled message"));
	}

}
