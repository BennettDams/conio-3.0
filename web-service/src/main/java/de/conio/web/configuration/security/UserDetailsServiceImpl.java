package de.conio.web.configuration.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.conio.core.structure.Role;
import de.conio.core.structure.User;
import de.conio.web.connector.consumer.UserConsumer;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserConsumer userConsumer;
	
	@Autowired
	public UserDetailsServiceImpl(UserConsumer userConsumer) {
		this.userConsumer = userConsumer;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userConsumer.findOneByUsername(username);
		
		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {	
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), toGrantedAuthorities(user));
		}
	}
	
	private static Collection<GrantedAuthority> toGrantedAuthorities(final User user) {
	    final Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	    for (final Role role : user.getRoles()) {
	        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	    }
	    return grantedAuthorities;
	}
}