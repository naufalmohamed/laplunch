package com.recommendationservice.service;

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recommendationservice.model.RelationshipModel;
import com.recommendationservice.repository.RelationshipRepository;

@Service
public class RelationshipService {
	@Autowired
	RelationshipRepository relationshipRepositrory;

	public void createRelationship(RelationshipModel relationship) {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		relationshipRepositrory.createRelationhip(relationship.getUser().getId(),
//				relationship.getMenu().getItemId(), now);
		relationshipRepositrory.save(relationship);
	}
	
//	public List<RelationshipModel> suggestByCity(RelationshipModel relationship){
//		String city = relationship.getUser().getAddress().getCity();
//		return relationshipRepositrory.suggestByCity(city);
//	}
	public List<RelationshipModel> getall(){
		return relationshipRepositrory.findAll();
	}
	
//	public List<RelationshipModel> getallOrdersByUserId(Long id){
////		return relationshipRepositrory.getOrdersByUserId(id);
////	}
	public List<RelationshipModel> recommend(String city){
		return relationshipRepositrory.getOrdersByCity(city);
	}
}
