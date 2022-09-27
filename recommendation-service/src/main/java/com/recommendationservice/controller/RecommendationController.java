package com.recommendationservice.controller;

//import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.recommendationservice.exceptions.MenuNotFoundException;
import com.recommendationservice.model.Menu;
import com.recommendationservice.model.OrderMenu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import com.recommendationservice.exceptions.UserNotFoundException;
import com.recommendationservice.model.RelationshipModel;
		import com.recommendationservice.service.MenuService;
import com.recommendationservice.service.RelationshipService;
import com.recommendationservice.service.UserService;
@Slf4j
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v4")
public class RecommendationController {
	
	@Autowired
	RelationshipService relationshipService;
	@Autowired
	UserService userService;
	@Autowired
	MenuService menuService;
	@Autowired
	com.recommendationservice.repository.OrderMenuRepository orderRep;
//	@GetMapping("/city/{city}")
//	public HashSet<Menu> suggestByCity(@PathVariable String city){
//		List<Long> usersIdList = new  ArrayList<Long>();
//		List<Long> ordersIdList = new  ArrayList<Long>();
//		Set<Menu> menuList = new HashSet<Menu>();
//
//		List<User> usersList = userService.suggestByCity(city);
//		for(int i = 0; i<usersList.size();i++) {
//			usersIdList.add(usersList.get(i).getId());
//
//		}
////		List<Long> orderIdList  = new ArrayList<Long>();
//		for (int i = 0;i<usersIdList.size();i++) {
//			List<RelationshipModel> orderList = relationshipService.getallOrdersByUserId(usersIdList.get(i));
//			for(int j = 0; j<orderList.size();j++) {
//				ordersIdList.add(orderList.get(j).getOrderId());
//			}
//		}
//		for (int i=0; i<ordersIdList.size();i++) {
//			menuList.add(menuService.getByOrder(ordersIdList.get(i)));
//
//		}
//		return (HashSet<Menu>) menuList;
//
//	}
	@GetMapping("/city/{city}")
	public HashSet<Menu> recommend(@PathVariable String city) throws MenuNotFoundException {
		List<Long> orderIdList = new ArrayList<Long>();
		List<Integer> menuIdList = new ArrayList<Integer>();
		Set<Menu> menuList = new HashSet<Menu>();
		List<RelationshipModel> orderList = relationshipService.recommend(city);
		for(int i=0;i<orderList.size();i++){
			orderIdList.add(orderList.get(i).getOrderId());
		}
		for(int i=0;i<orderIdList.size();i++){
			List<OrderMenu> orderMenuList =  orderRep.getByOrder(orderIdList.get(i));
			for(int j=0;j<orderMenuList.size();j++){
				menuIdList.add(orderMenuList.get(j).getItemId());
			}
		}
		for(int i = 0 ;i<menuIdList.size();i++){
			menuList.add(menuService.findByItemId(menuIdList.get(i)));
		}
		return (HashSet<Menu>) menuList;
	}
	@GetMapping("/order/{id}")
	public List<OrderMenu> get(@PathVariable Long id){
		return orderRep.getByOrder(id);
	}
}
