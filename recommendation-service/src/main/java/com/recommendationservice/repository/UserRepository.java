package com.recommendationservice.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.recommendationservice.model.User;

public interface UserRepository extends Neo4jRepository<User,String>{

	@Query("MATCH (n:User) RETURN (n)")
	List<User> getAllUsers();

	@Query("MATCH (n:User{userEmailId:$email}) RETURN (n)")
	User findByEmailId(String email);

	@Query("MATCH (u:User)-[rel:ADDRESS]->(a:Address{city:$city}) RETURN(u)")
	List<User> suggestByCity(String city);


}
