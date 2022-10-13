package com.example.appointment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.Entity.Appointment;
import com.example.appointment.Entity.User;
import com.example.appointment.Exception.CustomException;
import com.example.appointment.repository.AppointmentRepository;
import com.example.appointment.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public User save(User user)throws CustomException {
		Optional<User> userExist=getUserByEmail(user.getEmail());
		if(userExist.isPresent()) {
			throw new CustomException("User already present");
		}
		return userRepository.save(user);
	}

	public Optional<User> getUserById(int id)throws CustomException{
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) {
			throw new CustomException("user not found");
		}
		return user;
	}
	public User updateUser(User user,int id) throws CustomException{
		Optional<User> userId=getUserById(id);
		if(userId.isPresent())
			user.setId(id);
		return userRepository.save(user);
		
	}
	
	public Optional<User> getUserByEmail(String email){
		return userRepository.getUserByEmail(email);
	}
	
	
}
