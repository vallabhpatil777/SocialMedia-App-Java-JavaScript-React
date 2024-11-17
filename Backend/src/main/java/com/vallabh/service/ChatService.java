package com.vallabh.service;

import java.util.List;

import com.vallabh.models.Chat;
import com.vallabh.models.User;

public interface ChatService {
	
	
	public Chat createChat(User reqUser, User user);
	public Chat findChatById(Integer chatId) throws Exception;
	
    public List<Chat> findUserChat(Integer userId);
}