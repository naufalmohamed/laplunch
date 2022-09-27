package com.niit.userservice.resource;

import com.niit.userservice.model.Users;
import com.niit.userservice.Services.UserRepositoryService;
import com.niit.userservice.exceptiions.UserAlreadyExistsException;
import com.niit.userservice.exceptiions.UserNotFoundException;

import com.niit.userservice.model.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
//@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    @Autowired
    private UserRepositoryService repositoryService;
    private Users userDemo;

    @PostMapping //change
    public ResponseEntity<?> addUser(@RequestBody UsersDTO user) {

//        return new ResponseEntity<Users>(repositoryService.addUser(user),HttpStatus.ACCEPTED);
        try {
//            repositoryService.addUser(user);
//            return new ResponseEntity<>(HttpStatus.CREATED);
            return new ResponseEntity<>(repositoryService.addUser(user),HttpStatus.ACCEPTED);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>("User Already exists", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getUsers") //change
    public ResponseEntity<List<Users>> getUsers() {
        try {
            return ResponseEntity.ok(repositoryService.getUsers());
        } catch (UserNotFoundException e) {
            return new ResponseEntity("Empty repository!!", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity("Some unknown error occurred!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getUser/{email}")
    public ResponseEntity<Users> getUserByEmail(@PathVariable String email) {
        try {
            return new ResponseEntity<>(repositoryService.getUserByEmail(email), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity("User not found!!", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity("User not found!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SuppressWarnings("unchecked")
    @DeleteMapping("/deleteUser/{email}")
    public void deleteUserByEmail(@PathVariable String email) {
        try {
            this.repositoryService.deleteUserByEmail(email);

        } catch (UserNotFoundException e) {
            ResponseEntity.status(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/updateUser/{email}")
    public ResponseEntity<Object> updateUser(@RequestBody Users user) {
        try {
            repositoryService.updateUser(user);
            return new ResponseEntity<>("User updated successfully!!!", HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("User not found!!", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>("Update failed, We will get back to you soon",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
