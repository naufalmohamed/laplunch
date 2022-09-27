package com.niit.userservice.Services;

//<<<<<<< HEAD:user-service/src/main/java/com/userservice/Services/UserRepositoryService.java
import com.niit.userservice.model.UsersDTO;
import com.niit.userservice.config.Producer;
import com.niit.userservice.exceptiions.UserAlreadyExistsException;
import com.niit.userservice.exceptiions.UserNotFoundException;
import com.niit.userservice.model.Users;
import com.niit.userservice.model.UsersDTO;
import com.niit.userservice.rabbitmq.model.UserCredentials;
import com.niit.userservice.repository.UserRepository;
//=======
import com.niit.userservice.exceptiions.UserAlreadyExistsException;
import com.niit.userservice.exceptiions.UserNotFoundException;
import com.niit.userservice.model.Users;
import com.niit.userservice.repository.UserRepository;
//>>>>>>> 63edf689972ce1eb50bf84b490f62882ed9e74ae:user-service/src/main/java/com/niit/userservice/Services/UserRepositoryService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryService {
    @Autowired
    private UserRepository repository;
    @Autowired
    Producer producer;
    private Users userDemo;
    private UserCredentials userCredentials;
    // this method is used to add new users to the database
    public Users addUser(UsersDTO user) throws UserAlreadyExistsException {
        if (repository.existsById(user.getUserEmailId())) {
            throw new UserAlreadyExistsException();
        }
        else {
            userDemo=new Users(user.getUserEmailId(),user.getMobileNum(),user.getFirstName(),user.getLastName(),user.getAddress());
            userCredentials = new UserCredentials(user.getUserEmailId(), user.getPassword());
            repository.save(userDemo);
            producer.sendMessageToRabbitMq(userCredentials);
        }
        return userDemo;

    }

    // this method returns all the users from the database
    public List<Users> getUsers() throws UserNotFoundException {
        if (repository.count() == 0) {
            throw new UserNotFoundException();
        }
        return repository.findAll();
    }

    // this returns a specific user by users email id
    public Users getUserByEmail(String email) throws UserNotFoundException {
        if(repository.existsById(email)) {
            return repository.findById(email).get();
        }
        throw new UserNotFoundException();
    }

    // this method is used to delete an user by his email id
    public void deleteUserByEmail(String email) throws UserNotFoundException {
        if(repository.existsById(email)) {
           repository.deleteById(email);
        }
        throw new UserNotFoundException();
    }

    // this method is used to update user details
    public Users updateUser(Users user) throws UserNotFoundException {


        if (repository.existsById(user.getUserEmailId())) {
            Users users = repository.findById(user.getUserEmailId()).get();
//            users.setUserEmailId(user.getUserEmailId());
//
//            users.setFirstName(user.getFirstName());
//            users.setLastName(user.getLastName());
//
//            users.setAddress(user.getAddress());

            return repository.save(user);
        }
        throw new UserNotFoundException();


    }
 }

