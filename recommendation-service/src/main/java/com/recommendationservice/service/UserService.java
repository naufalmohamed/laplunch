package com.recommendationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recommendationservice.exceptions.UserNotFoundException;
//import com.recommendationservice.model.Menu;
import com.recommendationservice.model.User;
import com.recommendationservice.repository.UserRepository;

import com.recommendationservice.exceptions.UserAlreadyExistsException;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> getAll() throws UserNotFoundException {
		if (userRepository.count() == 0) {
			throw new UserNotFoundException();
		}
		return userRepository.getAllUsers();
	}

	public String addUser(User user) throws UserAlreadyExistsException {
		if (userRepository.findByEmailId(user.getUserEmailId()) == null) {
			userRepository.save(user);
			return "User Added Successfully!";
		}
		throw new UserAlreadyExistsException();
	}

	public User findByEmailId(String email) throws UserNotFoundException {
		if (userRepository.findByEmailId(email) != null) {
			return userRepository.findByEmailId(email);
		}
		throw new UserNotFoundException();

	}

	public String updateUser(User user) throws UserNotFoundException {
//		return userRepository.findById(id);
		if (userRepository.findByEmailId(user.getUserEmailId()) != null) {
			userRepository.save(user);
			return "Updated Succesfully";
		}
		throw new UserNotFoundException();

	}

	public void deleteUser(String emailId) {
		userRepository.deleteById(emailId);
	}

	public List<User> suggestByCity(String city) {
		return userRepository.suggestByCity(city);
	}
}
