package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.Account;

@Service
public class LoginServiceImpl implements UserDetailsService {
	@Autowired @Lazy
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountService.findAccount(username);
		
		if (account == null) {
			throw new UsernameNotFoundException("Username Not Found");
		}
		
		UserDetails userDetails = (UserDetails) new User(
				account.getTkTen(), account.getTkMatKhau(), new ArrayList<GrantedAuthority>());
		return userDetails;
	}

}
