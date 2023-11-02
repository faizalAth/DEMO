package in.spring.ath.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import in.spring.ath.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

	
	public User findByUserName(String username);

}
