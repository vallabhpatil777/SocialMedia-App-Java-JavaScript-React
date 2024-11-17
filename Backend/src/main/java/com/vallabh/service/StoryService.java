package com.vallabh.service;

import java.util.List;

import com.vallabh.models.Story;
import com.vallabh.models.User;

public interface StoryService {

	
	public Story createStory (Story story, User user);
	
	public List<Story> findStoryByUserId(Integer userId) throws Exception;
	
}
