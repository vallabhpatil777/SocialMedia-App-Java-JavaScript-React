package com.vallabh.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vallabh.models.Chat;
import com.vallabh.models.User;
import com.vallabh.repository.ChatRepository;

@Service
public class ChatServiceImplementation implements ChatService{
	
	
	@Autowired
	private ChatRepository chatRepository;

	@Override
	public Chat createChat(User reqUser, User user) {
		Chat isExist = chatRepository.findChatByUsersId(user,reqUser);
		
		
		if(isExist!=null) {
			return isExist;
		}
		Chat chat = new Chat();
		chat.getUser().add(user);
		chat.getUser().add(reqUser);
		chat.setTimestamp(LocalDateTime.now());
		
		
		
		return chatRepository.save(chat);
	}

	@Override
	public Chat findChatById(Integer chatId) throws Exception {
		Optional<Chat> opt = chatRepository.findById(chatId);
		
		if(opt.isEmpty()) {
			throw new Exception("Chat not found  ");
			
		}
		
		
		return opt.get();
	}

	@Override
	public List<Chat> findUserChat(Integer userId) {
		// TODO Auto-generated method stub
		return chatRepository.findByUserId(userId);
	}

}
