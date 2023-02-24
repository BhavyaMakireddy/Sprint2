package com.cg.mts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.dto.UserDTO;
import com.cg.mts.entities.User;
import com.cg.mts.entities.Address;
import com.cg.mts.exception.InvalidUserException;
import com.cg.mts.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository userRepository;

	
	@Override
	public User registerUser(User user)throws InvalidUserException {
	
		if(user.getFirstName().equals("") || user.getLastName().equals("")) {
			throw new InvalidUserException("User name","First Name or Last Name is null");
		}
		
		if(user.getEmailId().equals("")) {
			throw new InvalidUserException("Email Id","Email Id cannot be null");
		}
		if(user.getPassword().equals("")) {
			throw new InvalidUserException("Password","Password cannot be null");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	
	@Override
	public List<User> getUserByCity(String searchCity) {
		//get all users 
		List<User> allUsers = userRepository.findAll();
		//Filter user through for loop based on city
		List<User> allUserByCity = new ArrayList<>();
		for(User user : allUsers) {
			String userCity =user.getAddress().getCity();
		if(userCity.equals(searchCity)) {
			allUserByCity.add(user);
		}
		}
		
		return allUserByCity;
	}
	
	

	@Override
	public List<User> getUserByState(String searchstate) {
		
		List<User> allUsers = userRepository.findAll();
		List<User> allUserByState = new ArrayList<>();
		for (User user: allUsers) {
			String userState = user.getAddress().getState();
			if(userState.equals(searchstate)) {
				allUserByState.add(user);
			}
		}
		return allUserByState;
	}

	@Override
	public User getUserById(int userId) {
		
		User userFromDB = userRepository.getReferenceById(userId);
		userRepository.getReferenceById(userId);
	
		return userFromDB;
	}

	@Override
	public User updateUser(int userId) {
	
		User updatedUser = userRepository.getReferenceById(userId);
		userRepository.save(updatedUser);
		return updatedUser;
	}

	

}
