package com.greatLearning.studentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatLearning.studentManagement.entity.User;
import com.greatLearning.studentManagement.repository.UserRepository;
import com.greatLearning.studentManagement.security.MyUserDetails;


public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =userRepository.findByUsername(username);
		
		if(user==null)
			throw new UsernameNotFoundException("Could not fine user");
		
		return new MyUserDetails(user);
	}

}
