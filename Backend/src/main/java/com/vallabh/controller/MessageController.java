package com.vallabh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.vallabh.models.Message;
import com.vallabh.models.User;
import com.vallabh.service.MessageService;
import com.vallabh.service.UserService;

@RestController
public class MessageController {
	
	
	@Autowired
	private MessageService messageService;
	
	
	@Autowired
	private UserService userService;
	

	
	
	@PostMapping("/api/messages/chat/{chatId}")
	public Message createMessage(@RequestBody Message req, @PathVariable Integer chatId, @RequestHeader ("Authorization") String jwt) throws Exception {
		
		
		
		User user = userService.findUserByJwt(jwt);
		Message message = messageService.createMessage(user, chatId, req);
		return message;
	}
	
	
	
	@GetMapping("/api/messages/chat/{chatId}")
	public List<Message> findChatsMessages( @PathVariable Integer chatId, @RequestHeader ("Authorization") String jwt) throws Exception {
		
		
		
		User user = userService.findUserByJwt(jwt);
		List<Message> messages = messageService.findChatsMessages(chatId);
		return messages;
	}
}