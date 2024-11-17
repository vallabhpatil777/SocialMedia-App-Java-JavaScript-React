package com.vallabh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vallabh.config.JwtProvider;
import com.vallabh.exceptions.UserException;
import com.vallabh.models.User;
import com.vallabh.repository.UserRepository;


@Service
public class UserServiceImplementation implements UserService{
    
	

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		User newUser = new User();
		//newUser.setId(user.getId());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		User savedUser = userRepository.save(newUser);

		return savedUser;		
	}

	@Override
	public User findUserById(Integer userId) throws UserException {

        Optional<User> user = userRepository.findById(userId);
        
        if(user.isPresent()) {
        	return user.get();
        }
		
		throw new UserException("User not Found");
	}

	@Override
	public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
		
		return user;
	}

	@Override
	public User followUser(Integer reqUserId, Integer userId2) throws UserException {

		User reqUser = findUserById(reqUserId);
		User user2 = findUserById(userId2);
        
		user2.getFollowers().add(reqUser.getId());
		reqUser.getFollowings().add(user2.getId());
		
		userRepository.save(reqUser);
		userRepository.save(user2);
		
		
		return reqUser;
	}

	@Override
	public User updateUser(User user, Integer Id) throws UserException {
		Optional <User> olduser1 = userRepository.findById(Id);
		if (olduser1.isEmpty()) {
			throw new UserException("User not Found");
		}
		
		
	   User user1 = olduser1.get();
		
		if(user.getFirstName()!=null) {
			user1.setFirstName(user.getFirstName());
			
		}
		
		if(user.getLastName()!=null) {
			user1.setLastName(user.getLastName());
			
		}
		
		if(user.getEmail()!=null) {
			user1.setEmail(user.getEmail());
			
		}
		
		if (user.getGender()!=null) {
			user1.setGender(user.getGender());
		}
		
		User updateduser1 = userRepository.save(user1);
		
		return updateduser1;

		
	}

	@Override
	public List<User> searchUser(String query) {

		
		return userRepository.searchUser(query);
	}

	@Override
	public User findUserByJwt(String jwt) {
		String email = JwtProvider.getEmailFromJwtToken(jwt);
		User user = userRepository.findByEmail(email);
		
		
		return user;
	}

	

}
