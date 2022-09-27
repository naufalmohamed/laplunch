package com.recommendationservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.recommendationservice.model.RelationshipModel;

public interface RelationshipRepository extends Neo4jRepository<RelationshipModel, Long>{
	
	
	@Query("MATCH(u:User{id:$userId}) MATCH (m:Menu{itemId:$itemId}) MERGE (u)-[:ORDERED{time:$now}]->(m)")
	void createRelationhip(Long userId , Long itemId, LocalDateTime now);
	
	@Query("MATCH (u:User)-[rel:ADDRESS]->(a:Address{city:$city}) MATCH (o:RelationshipModel)-[r:USER]->(u) MATCH (o)-[rel2:MENU]->(m:Menu) RETURN (o)")
	List<RelationshipModel> suggestByCity(String city);
	
	@Query("MATCH(o:RelationshipModel)-[rel:ADDRESS]->(a:Address{city:$city}) RETURN (o) LIMIT 7")
	List<RelationshipModel> getOrdersByCity(String city);

//	
}
