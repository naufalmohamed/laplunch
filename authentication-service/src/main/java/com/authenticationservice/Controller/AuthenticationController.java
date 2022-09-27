package com.authenticationservice.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.authenticationservice.Datamodel.UserDao;
import com.authenticationservice.Exceptions.UserAlreadyExistsException;
import com.authenticationservice.Exceptions.UserNotFoundException;
import com.authenticationservice.Userlogin.Service.UserService;
import com.authenticationservice.jwtToken.JwtTokenGenerator;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {
	
	public JwtTokenGenerator jwtToken;
	
	public UserService userService;
    
	@Autowired
	public AuthenticationController(JwtTokenGenerator jwtToken, UserService userService) {
		super();
		this.jwtToken = jwtToken;
		this.userService = userService;
	}

	// api for authenticating the user 
	
	@PostMapping(value="/auth/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDao request)
	throws Exception{
	Map<String,String> map=null;
	{
		try {
			UserDao user = userService.loadByUserEmail(request.getEmail());
			if(user.getPassword().equals(request.getPassword())) {
				map=jwtToken.generateToken(user);
			   return ResponseEntity.ok(map);
			}
			return new ResponseEntity<>("Incorrect Password",HttpStatus.NOT_FOUND);
		}
		catch(UserNotFoundException e) {
			return new ResponseEntity<>("Incorrect Password",HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>("Something went wrong we will be back soon !!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	}
	
	// Api for posting user details
	@PostMapping("/post")
	public ResponseEntity<?> saveUser(@RequestBody UserDao user) throws Exception {
		try {
			return ResponseEntity.ok(userService.saveUser(user,user.getEmail()));
		}catch (UserAlreadyExistsException e){
			return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<>("Something went wrong we will be back soon !!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	// api for updating the password
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateUser(@RequestBody UserDao update) {
		try {

			userService.updateUser(update);
			return new ResponseEntity<>("Update success!!", HttpStatus.OK);

		} catch (UserNotFoundException e) {

			return new ResponseEntity<>("User not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong we will be back soon !!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
