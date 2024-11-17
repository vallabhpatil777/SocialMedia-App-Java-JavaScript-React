package com.vallabh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.vallabh.models.Chat;
import com.vallabh.models.User;
import com.vallabh.request.CreateChatRequest;
import com.vallabh.service.ChatService;
import com.vallabh.service.UserService;

@RestController
public class ChatController {
	
	
	@Autowired
	private ChatService chatService;
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/chats")
	public Chat createChat(@RequestHeader("Authorization") String jwt,@RequestBody CreateChatRequest req) throws Exception {
		User reqUser = userService.findUserByJwt(jwt);
		User user = userService.findUserById(req.getUserId());
		Chat chat = chatService.createChat(reqUser, user);
		return chat;
	}
	
	
	@GetMapping("/api/chats")
	public List<Chat> findUserChat(@RequestHeader("Authorization") String jwt) {
		User user = userService.findUserByJwt(jwt);

		
		List<Chat> chat = chatService.findUserChat(user.getId());
		return chat;
	}
	

}
