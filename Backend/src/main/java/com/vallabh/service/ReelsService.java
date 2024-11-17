package com.vallabh.service;

import java.util.List;

import com.vallabh.models.Reels;
import com.vallabh.models.User;

public interface ReelsService {

	
	public Reels createReel (Reels reel, User user);
	public List<Reels> findAllReels();
	public List<Reels> findUserReel(Integer userId) throws Exception;
	

}
