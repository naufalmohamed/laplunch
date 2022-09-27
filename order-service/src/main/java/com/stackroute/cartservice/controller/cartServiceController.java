package com.stackroute.cartservice.controller;

import com.stackroute.cartservice.exceptions.CartAlreadyExistsException;
import com.stackroute.cartservice.exceptions.CartNotFoundException;
import com.stackroute.cartservice.model.Cart;
import com.stackroute.cartservice.service.cartServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j

@RestController

//@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/v1/cart")
public class cartServiceController {
	private final cartServices services;


	public cartServiceController(cartServices services) {

		this.services = services;
	}

	//To get add new items  to cart by post mapping
//Postmapping api used to post data to the mongo database.
	@PostMapping(value = "/create")
	public ResponseEntity<Object> addItemsToCart(@RequestBody Cart cart) {
		try {
			services.addItemsToCart(cart);
			log.info("Inside addItemsToCart try block ");
			return new ResponseEntity<>("Added items successfully in cart", HttpStatus.CREATED);
		} finally {
			services.addItemsToCart(cart);
			return new ResponseEntity<>("Added items successfully in cart", HttpStatus.CREATED);

		}
	}
//		catch (CartAlreadyExistsException e) {
//			log.error("Cart Already exists!!");
//			return new ResponseEntity<>("Cart  already exists!!", HttpStatus.CONFLICT);
//		} catch (Exception e) {
//			log.error("Parent exception got raised");
//			return new ResponseEntity<>("Cart details already exists!!!", HttpStatus.INTERNAL_SERVER_ERROR);





	//Putmapping api used to update data which already exists in the mongo database.
	//To update or save the cart using email Id
	@PutMapping("/{userEmailId}")
	public ResponseEntity<Object> saveOrUpdat(@RequestBody Cart cart) {
		try {

			services.saveOrUpdate(cart);
			log.info("Inside saveOrUpdate try block ");
			return new ResponseEntity<>("Update success!!", HttpStatus.OK);

		} catch (CartNotFoundException e) {
			log.error("Cart not found!!");
			return new ResponseEntity<>("cart not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			log.error("Parent exception got raised");
			return new ResponseEntity<>("Something went wrong we will be back soon !!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}

	//Getmapping  api with id used to fetch specific data with it's userEmailid, present in the mongo database.
	// To find cart by using user email id 
	@GetMapping("/{userEmailId}")
	public ResponseEntity<Cart> findCartByEmailId(@PathVariable String userEmailId) {

		try {
			log.info("Inside findCartByEmailId try block ");
			return new ResponseEntity(services.findCartByEmailId(userEmailId), HttpStatus.OK);

		} catch (CartNotFoundException e) {
			log.error("Cart not found!!");
			return new ResponseEntity("Cart not found!!", HttpStatus.CONFLICT);
		} catch (Exception e) {
			log.error("Parent exception got raised");
			return new ResponseEntity("Cart not found!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//Getmapping api used to fetch all the data  present in the mongo database.
	//to find all the carts 
	@GetMapping
	public ResponseEntity<List<Cart>> findAllCarts() {
		try {
			log.info("Inside findAllCarts try block ");
			return ResponseEntity.ok(services.findAllCarts());
		} catch (CartNotFoundException e) {
			log.error("Empty repository!!");
			return new ResponseEntity("Empty repository!!", HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/{userEmailId}")
	public ResponseEntity<?> emptycart(@PathVariable String userEmailId) {
		try {

			services.emptyCart(userEmailId);
			return new ResponseEntity<>("Deleted successfully!!", HttpStatus.OK);
		} finally {
			return new ResponseEntity<>("Deleted successfully!!", HttpStatus.OK);
		}}
}
//		} catch (CartNotFoundException e) {
//
//
//			return new ResponseEntity<>("Delete unsuccessfull!!", HttpStatus.CONFLICT);
//		} catch (Exception e) {
//
//			return new ResponseEntity<>("Something went wrong!!", HttpStatus.INTERNAL_SERVER_ERROR);
//
//		}

//	}


    		
