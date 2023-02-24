package com.cg.mts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.mts.entities.User;
import com.cg.mts.entities.Address;

@Service
public interface IUserService {
	
	public User registerUser(User user)throws Exception;
	public List<User> getAllUsers();
	public User getUserById(int userId);
	public User updateUser(int userId);
	public List<User> getUserByState(String state);
	public List<User> getUserByCity (String city);

}
