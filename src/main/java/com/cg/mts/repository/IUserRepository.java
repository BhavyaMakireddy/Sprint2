package com.cg.mts.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.User;
import com.cg.mts.entities.Address;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

	//User getUserId(int userId);

}
