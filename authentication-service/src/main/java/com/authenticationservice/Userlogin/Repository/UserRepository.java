package com.authenticationservice.Userlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.authenticationservice.Datamodel.UserDao;

public interface UserRepository extends JpaRepository<UserDao , String> {
//	UserDao save(String email);

}
