package com.authenticationservice.Datamodel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Setter
@Getter
@Table(name= "user_login")
public class UserDao{
	
	@Id
	private String email;
	private String password;

}
