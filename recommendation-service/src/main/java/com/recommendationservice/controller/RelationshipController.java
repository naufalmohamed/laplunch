package com.recommendationservice.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendationservice.model.RelationshipModel;
import com.recommendationservice.service.RelationshipService;
@Slf4j
@RestController
@RequestMapping("/api/v3")
public class RelationshipController {
	
	@Autowired
	RelationshipService relationshipService;
	
	@PostMapping
	public void createRelationship(@RequestBody RelationshipModel relationship) {
		relationshipService.createRelationship(relationship);
	}
	@GetMapping
	public List<RelationshipModel> getAll(){
		return relationshipService.getall();
	}
//	@GetMapping("/orders/{id}")
//	public List<RelationshipModel> getOrderByUserId(@PathVariable Long id ){
//		return relationshipService.getallOrdersByUserId(id);
//	}

}
