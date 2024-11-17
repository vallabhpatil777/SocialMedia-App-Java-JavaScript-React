package com.vallabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vallabh.models.Story;
import com.vallabh.models.User;
import com.vallabh.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService{

	
	
	@Autowired
	private StoryRepository storyRepository;
	
	
	@Autowired
	private UserService userService;
	@Override
	public Story createStory(Story story, User user) {
		Story createdStory = new Story();
		
		createdStory.setCaptions(story.getCaptions());
		createdStory.setImage(story.getImage());
		
		createdStory.setCaptions(story.getCaptions());
		createdStory.setUser(story.getUser());
		createdStory.setTimeStamp(story.getTimeStamp());
		
		return storyRepository.save(createdStory);
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws Exception {
        User user = userService.findUserById(userId);
		
		
		return storyRepository.findByUserId(userId);
	}

	
	
	
}
