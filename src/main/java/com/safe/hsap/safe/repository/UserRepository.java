package com.safe.hsap.safe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.safe.hsap.safe.model.LoginUserDetailRecord;
import com.safe.hsap.safe.model.User;

@Repository
public interface UserRepository extends JpaRepository < User, Long > {
	
    User findByEmail(String email);
    
    @Query("Select new com.safe.hsap.safe.model.LoginUserDetailRecord("+
            "a.firstName,"+
    		"a.lastName,"+
            "a.email)"+ 
    		"from User a where a.email =:email")
	public LoginUserDetailRecord getLoginUserDetails(@Param("email") String email);
}