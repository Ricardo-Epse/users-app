package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Address;
import com.example.demo.entities.Profile;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.ProfileRepository;
//import com.example.demo.repositories.UserRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;

	public List<Address> findAddressesByProfileAndUserId(Integer userId, Integer profileId) {
		
		return addressRepository.findByProfileId(userId , profileId );
	}

	public Address createAddress(Integer userId, Integer profileId, Address address) {
		Optional<Profile> result = profileRepository.findByUserAndProfileId(userId, profileId);
		
		if(result.isPresent()) {
			
			address.setProfile(result.get());
			
			return addressRepository.save(address);
			
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , String.format("Profile %d not found and user %d not found " , profileId , userId));
		}
	}
	
	
	
	
}
