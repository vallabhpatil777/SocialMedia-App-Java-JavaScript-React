package com.vallabh.service;

import java.util.List;

import com.vallabh.exceptions.UserException;
import com.vallabh.models.User;

public interface UserService {
	
	
	public User registerUser(User user);
	public User findUserById(Integer UserId) throws UserException;
	public User findUserByEmail(String Email);
	public User followUser(Integer userId1, Integer userId2) throws UserException;
	
	public List<User> searchUser(String query);
	public User updateUser(User user, Integer Id) throws UserException;
	public User findUserByJwt(String jwt);
}
