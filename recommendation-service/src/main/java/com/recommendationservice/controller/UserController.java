package com.recommendationservice.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendationservice.exceptions.UserNotFoundException;
import com.recommendationservice.model.User;
import com.recommendationservice.service.UserService;

import com.recommendationservice.exceptions.UserAlreadyExistsException;
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<Object> getAll() {
		try {
			log.info("All Users were retrieved");
			return ResponseEntity.ok(userService.getAll());
		} catch (UserNotFoundException e) {
			log.error("No Users Found");
			return new ResponseEntity<Object>("No User found was found in the database!", HttpStatus.CONFLICT);
		}
	}

	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			userService.addUser(user);

			return new ResponseEntity<>("User Added Successfully!",HttpStatus.CREATED);
		} catch (UserAlreadyExistsException e) {

			return new ResponseEntity<>("User details already exist!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Oops. Something Went Wrong!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{email}")
	public ResponseEntity<Object> getByEmail(@PathVariable String email) {
		try {
			log.info("The requested user was fetched");
			return new ResponseEntity<Object>(userService.findByEmailId(email), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			log.error("The requested user could not be fetched");
			return new ResponseEntity<Object>("The requested User could not be found.", HttpStatus.CONFLICT);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>("Oops!Something went wrong !!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{Id}")
	public void deleteUser(@PathVariable String Id) {
		userService.deleteUser(Id);
	}

	@GetMapping("/city/{city}")
	public List<User> suggestByCity(@PathVariable String city) {
		return userService.suggestByCity(city);

	}

	@PutMapping()
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		try {
			userService.updateUser(user);
			log.info("User details updates successfully");
			return new ResponseEntity<Object>("Updated Successfully", HttpStatus.OK);
		} catch (UserNotFoundException e) {
			log.error("User not found");
			return new ResponseEntity<Object>("The requested User could not be found.", HttpStatus.CONFLICT);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>("Oops!Something went wrong !!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
