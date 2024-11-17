package com.vallabh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vallabh.models.Chat;
import com.vallabh.models.User;

public interface ChatRepository extends JpaRepository<Chat, Integer>{

	public List<Chat> findByUserId(Integer userId);
	
	
	@Query("select c from Chat c where :user Member of c.user And :reqUser Member of c.user")
	public Chat findChatByUsersId(@Param("user") User user, @Param("reqUser") User reqUser);
}
