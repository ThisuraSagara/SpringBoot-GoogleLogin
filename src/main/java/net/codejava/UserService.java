package net.codejava;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public void processOAuthPostLogin(String username) {
		log.info("--- processOAuthPostLogin ---");
		User existUser = repo.getUserByUsername(username);
		
		if (existUser == null) {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setProvider(Provider.GOOGLE);
			newUser.setEnabled(true);			
			
			repo.save(newUser);
			
			System.out.println("Created new user: " + username);
		}
		
	}
	
}
