package net.codejava;

import java.util.Collection;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Slf4j
public class CustomOAuth2User implements OAuth2User {

	private OAuth2User oauth2User;
	
	public CustomOAuth2User(OAuth2User oauth2User) {
		log.info("--- CustomOAuth2User ---");
		this.oauth2User = oauth2User;
	}

	@Override
	public Map<String, Object> getAttributes() {
		log.info("--- getAttributes Map ---");
		return oauth2User.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.info("--- getAuthorities Collection ---");
		return oauth2User.getAuthorities();
	}

	@Override
	public String getName() {
		log.info("--- getName ---");
		return oauth2User.getAttribute("name");
	}

	public String getEmail() {
		log.info("--- getEmail ---");
		return oauth2User.<String>getAttribute("email");		
	}
}
