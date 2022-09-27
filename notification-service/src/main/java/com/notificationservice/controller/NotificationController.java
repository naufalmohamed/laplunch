package com.notificationservice.controller;

import com.notificationservice.model.Order;
import com.notificationservice.service.NotificationService;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class NotificationController {
    @Autowired
    NotificationService service; //Creates instance
    @Autowired
    private Configuration fmConfiguration; //Creates instance
    @PostMapping
    public ResponseEntity<Object> sendEmail(@RequestBody Order order) throws MessagingException, TemplateException, IOException {
        try{
            service.sendEmail(order);//Sends the email
            log.info("email was sent");
            return new ResponseEntity<Object>("Email sent successfully", HttpStatus.OK);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<Object>("Something went wrong", HttpStatus.CONFLICT);
        }

    }
}
