package com.vallabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vallabh.models.Chat;
import com.vallabh.models.Message;
import com.vallabh.models.User;
import com.vallabh.repository.ChatRepository;
import com.vallabh.repository.MessageRepository;

@Service
public class MessageServiceImplementation implements MessageService{
	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	
	@Autowired
	private ChatService chatService;
	
	@Override
	public Message createMessage(User user, Integer chatId, Message req) throws Exception {
		Message message = new Message();
		
		Chat chat = chatService.findChatById(chatId);
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setImage(req.getImage());
		message.setUser(user);
		
		Message savedMessage = messageRepository.save(message);
		chat.getMessages().add(savedMessage);
		chatRepository.save(chat);
		return savedMessage;
	}

	@Override
	public List<Message> findChatsMessages(Integer chatId) throws Exception {

		Chat chat = chatService.findChatById(chatId);
		
		return messageRepository.findByChatId(chatId);
	}

}
