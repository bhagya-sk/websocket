package com.reactiveworks.practice.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * WebSocket server
 */
@Controller
public class ChatHandler extends AbstractWebSocketHandler {
	
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws  IOException {
		System.out.println("New Text Message Received");
		session.sendMessage(message);
	}

	public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws  IOException {
		System.out.println("New Binary Message Received");
		session.sendMessage(message);
	}

}
