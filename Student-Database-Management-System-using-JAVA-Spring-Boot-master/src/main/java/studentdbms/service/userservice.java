package studentdbms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import studentdbms.entity.User;
import studentdbms.repository.UserRepository;

@Service
public class userservice {
	@Autowired
	private UserRepository usr;
	
	
	  public Optional<User> findByUsername(String username) {
	        return usr.findByUsername(username);
	    }
	  
	@Transactional
	public User save(User student) {
		return usr.save(student);
	}
}
