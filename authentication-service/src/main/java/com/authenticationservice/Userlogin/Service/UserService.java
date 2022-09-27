package com.authenticationservice.Userlogin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authenticationservice.Datamodel.UserDao;
import com.authenticationservice.Exceptions.UserAlreadyExistsException;
import com.authenticationservice.Exceptions.UserNotFoundException;
import com.authenticationservice.Userlogin.Repository.UserRepository;

@Service
public class UserService{
	
    @Autowired
	private UserRepository userRepo;
    
    // service layer for authentication

	public UserDao loadByUserEmail(String email) throws UserNotFoundException {

		UserDao user= userRepo.findById(email).get();
		if (user == null) {
			throw new UserNotFoundException();
		}
		return user;

	}
	//service layer for adding the user details
	
	   public UserDao saveUser(UserDao user, String email) throws UserAlreadyExistsException {		
		   if (userRepo.existsById(user.getEmail())) {
				throw new UserAlreadyExistsException();
			}
			return userRepo.save(user);		
		}
	   
	//service layer for updating login details

	public UserDao updateUser(UserDao update) throws UserNotFoundException {

		UserDao savedModel = userRepo.findById(update.getEmail()).get();
		if (userRepo.existsById(update.getEmail())) {

			savedModel.setEmail(update.getEmail());
			savedModel.setPassword(update.getPassword());
			return userRepo.save(update);
		}
		throw new UserNotFoundException();
	}

}
