package in.spring.ath.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import in.spring.ath.Repositories.UserRepo;
import in.spring.ath.entity.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= userRepo.findByUserName(username);
		if(user == null)
			throw new UsernameNotFoundException("User Not Exist☢") ;
		else
			return new CustomeUserDetails(user);
	}

}
