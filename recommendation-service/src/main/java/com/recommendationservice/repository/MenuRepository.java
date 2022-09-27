package com.recommendationservice.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.recommendationservice.model.Menu;

public interface MenuRepository extends Neo4jRepository<Menu, Integer>{
	@Query("MATCH (n:Menu) RETURN (n)")
	List<Menu> getAllMenu();
	
	@Query("MATCH(n:Menu{itemId:$itemId}) RETURN n")
	Menu findByItemId(int itemId);
	

	@Query("MATCH (m:Menu) WHERE $category IN m.category RETURN m")
	List<Menu> suggestByCity(String category);
	
	@Query("MATCH(m:Menu)<-[rel:MENU]-(o:RelationshipModel{orderId:$id}) RETURN (m)")
	Menu getByOrder(int id);
	
}
