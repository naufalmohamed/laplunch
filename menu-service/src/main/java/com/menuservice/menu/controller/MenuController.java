package com.menuservice.menu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menuservice.menu.model.MenuModel;
import com.menuservice.menu.exceptions.MenuAlreadyExistsException;
import com.menuservice.menu.exceptions.MenuNotFoundException;
import com.menuservice.menu.services.Services;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MenuController {
	
	//Calling services class and creating object to use further.
	private final Services services;
	
	//Calling menumodel class and creating object to use further.
	@SuppressWarnings("unused")
	private MenuModel menuModel;

	public MenuController(Services services) {

		this.services = services;
	}

	//Postmapping api used to post data to the mongo database. 
	@PostMapping
	public ResponseEntity<?> addItems(@RequestBody MenuModel menuModel) {

		try {
			services.addItems(menuModel);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (MenuAlreadyExistsException e) {

			return new ResponseEntity<>("Item details already exists!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<>("Item details already exists!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	//Putmapping api used to update data which already exists in the mongo database. 
	@PutMapping
	public ResponseEntity<Object> updateItem(@RequestBody MenuModel menuModel) {
		try {

			services.updateItem(menuModel);
			return new ResponseEntity<Object>("Update success!!", HttpStatus.OK);

		} catch (MenuNotFoundException e) {

			return new ResponseEntity<Object>("Menu not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Something went wrong we will be back soon !!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	//Getmapping api used to fetch all the data  present in the mongo database. 
	@GetMapping("/getall")
	public ResponseEntity<Object> getItems() {
		try {
			return ResponseEntity.ok(services.getItems());
		} catch (MenuNotFoundException e) {
			return new ResponseEntity<Object>("Empty repository!!", HttpStatus.CONFLICT);
		}
		catch (Exception e){
			return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//Getmapping  api with id used to fetch specific data with it's id, present in the mongo database.
	@GetMapping("/{itemId}")
	public ResponseEntity<Object> getItemsById(@PathVariable int itemId) {

		try {

			return new ResponseEntity<Object>(services.getItemsById(itemId), HttpStatus.OK);

		} catch (MenuNotFoundException e) {

			return new ResponseEntity<Object>("Menu not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {

			return new ResponseEntity<Object>("Something went wrong !!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//Deletemapping api with id used to delete specific data with it's id, present in the mongo database
	@SuppressWarnings("unchecked")
	@DeleteMapping("/{itemId}")
	public ResponseEntity<?> deleteItem(@PathVariable int itemId) {
		try {

			services.deleteById(itemId);
			return new ResponseEntity<>("Deleted successfully!!", HttpStatus.OK);

		} catch (MenuNotFoundException e) { 

			

			return new ResponseEntity<>("Delete unsuccessfull!!", HttpStatus.CONFLICT);
		} catch (Exception e) {

			return new ResponseEntity<>("Something went wrong!!", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@SuppressWarnings("unused")
	private void ResponseEntity(String string, HttpStatus conflict) {
		// TODO Auto-generated method stub

	}


}
