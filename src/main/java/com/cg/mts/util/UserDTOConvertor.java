package com.cg.mts.util;

import org.springframework.stereotype.Component;

import com.cg.mts.dto.UserDTO;
import com.cg.mts.entities.User;
import com.cg.mts.entities.Address;

@Component
public class UserDTOConvertor {
	
	public UserDTO convertTo(User user) {

		return new UserDTO(user.getUserId(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(),user.getEmailId(),
				user.getAddress());
	}
	

}
