package com.menuservice.menu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.menuservice.menu.model.MenuModel;

//Inheriting mongorepository
public interface MenuRepository extends MongoRepository<MenuModel, Integer> {


}
