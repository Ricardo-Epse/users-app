package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Profile;
import com.example.demo.entities.User;
import com.example.demo.repositories.ProfileRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Profile create( Integer userId , Profile profile) {
		Optional<User> result = userRepository.findById(userId);
		
		if(result.isPresent()) {
			profile.setUser(result.get());
			return profileRepository.save(profile);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", userId));
		}
	}

	public Profile getByUserAndProfileId(Integer userId, Integer profileId) {
		return profileRepository.findByUserAndProfileId(userId , profileId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("Profile not found for user %d and profile %d ", userId, profileId)));
	}
	
}
