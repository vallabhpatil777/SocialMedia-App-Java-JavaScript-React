package com.vallabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vallabh.models.Reels;
import com.vallabh.models.User;
import com.vallabh.repository.ReelsRepository;

@Service
public class ReelsServiceImplementation implements ReelsService{

	
	
	@Autowired
	private ReelsRepository reelsRepository;
	
	@Autowired
	private UserService userService;
	@Override
	public Reels createReel(Reels reel, User user) {

		Reels createReel = new Reels();
		createReel.setTitle(reel.getTitle());
		createReel.setUser(user);
		createReel.setVideo(reel.getVideo());
		
		
		
		
		return reelsRepository.save(createReel);
	}

	@Override
	public List<Reels> findAllReels() {
		return reelsRepository.findAll();
	}

	@Override
	public List<Reels> findUserReel(Integer userId) throws Exception {
		User user = userService.findUserById(userId);
		
		return reelsRepository.findByUserId(userId);
	}

}
