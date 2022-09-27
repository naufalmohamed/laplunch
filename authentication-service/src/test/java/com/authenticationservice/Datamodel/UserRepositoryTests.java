//package com.authenticationservice.Datamodel;
//
//
//import static org.hamcrest.MatcherAssert.assertThat;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.annotation.Rollback;
//
////import org.springframework.security.core.userdetails.User;
//import com.authenticationservice.Userlogin.Repository.UserRepository;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace= Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTests {
//	@Autowired
//	public  UserRepository repo;
//	
//	@Test
//	public void testCreateUser() {
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String rawPassword ="1234";
//		String encodePassword = passwordEncoder.encode(rawPassword);
////		UserModel newUser = new UserModel(0, "spandana@gmail.com", encodePassword);
////		UserModel savedUser = repo.save(newUser);
//	
//		User newUser = new User("spandana@gmail.com", encodePassword, null);
//		User savedUser = repo.save(newUser);
//	
////		assertThat(savedUser).isNotNull();
//		assertThat(savedUser).isGreaterThan(0);
//	}
//
//}
