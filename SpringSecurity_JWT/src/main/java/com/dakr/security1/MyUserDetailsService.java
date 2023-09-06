package com.dakr.security1;
import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return new User("admin","$2a$12$R0EyrtAKz5aNac2GdfIWluC9Pm1tSr2sAz5B5dzhTwB1AxboLQc.K",new ArrayList<>());
	}

}
