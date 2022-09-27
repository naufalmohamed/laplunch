package com.authenticationservice.config;


import com.authenticationservice.Datamodel.UserDao;
import com.authenticationservice.Exceptions.UserAlreadyExistsException;
import com.authenticationservice.Userlogin.Service.UserService;
import com.authenticationservice.rabbitmq.domain.UserCredentials;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private UserService userService;

    @RabbitListener(queues = "user_credentials")
    public void getUserCredentialsFromRabbitMq(UserCredentials userCredentials) throws UserAlreadyExistsException {
        System.out.print(userCredentials.toString());
        UserDao userDao = new UserDao();
        userDao.setEmail(userCredentials.getEmail());
        userDao.setPassword(userCredentials.getPassword());
        userService.saveUser(userDao, userCredentials.getEmail());
    }
}
