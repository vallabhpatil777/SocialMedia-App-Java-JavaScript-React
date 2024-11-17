package com.vallabh.service;

import java.util.List;

import com.vallabh.models.Chat;
import com.vallabh.models.Message;
import com.vallabh.models.User;

public interface MessageService {
	
	
	public Message createMessage(User user, Integer chatId, Message req) throws Exception;
	public List<Message> findChatsMessages(Integer chatId) throws Exception;
}
