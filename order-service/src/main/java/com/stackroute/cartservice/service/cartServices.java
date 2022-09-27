package com.stackroute.cartservice.service;

import com.stackroute.OrderService.model.Menu;
import com.stackroute.cartservice.Respository.CartRepository;
import com.stackroute.cartservice.exceptions.CartAlreadyExistsException;
import com.stackroute.cartservice.exceptions.CartNotFoundException;
import com.stackroute.cartservice.model.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class cartServices {
	//Calling cartRepository to use in creating wanted service.
	@Autowired
	private final CartRepository cartRepository;
	//private Cart cart;
	public cartServices(CartRepository cartRepository) {

		this.cartRepository = cartRepository;

	}
	 //addItemsToCart method consists of business logic to add new data to database
	public void addItemsToCart(Cart cart)   {

		List<Menu> listitems =new ArrayList<>();
		if (cartRepository.existsById(cart.getUserEmailId()))  {
			Cart items = cartRepository.findById(cart.getUserEmailId()).get();
//			listitems.addAll(items.getItems());
		}
		cartRepository.save(cart);
		log.info(" inside addItemsToCart");


	}
//		List<Menu> listitems =new ArrayList<>();
//
//		if (cartRepository.existsById(cart.getUserEmailId())) {
//
//
//			Cart items = cartRepository.findById(cart.getUserEmailId()).get();
////			listitems.addAll(items.getItems());
//		items.getItems().add(cart.getItems().get(0));
//			for (int i=0;i< items.getItems().size();i++){
//				Menu menu = new Menu();
//				menu.setItemId(items.getItems().get(i).getItemId());
//				menu.setItemName(items.getItems().get(i).getItemName());
//				menu.setItemDescription(items.getItems().get(i).getItemDescription());
//				menu.setItemName(items.getItems().get(i).getItemImage());
//				menu.setItemCost(items.getItems().get(i).getItemCost());
////				menu.setVeg(items.getItems().get(i).getCategory());
////				menu.setQty(items.getItems().get(i).getQuantity());
//				listitems.add(menu);
//			}
////			listitems.add(cart.getItems().get(0));
//		}
//		cartRepository.save(cart);
//		System.out.println(cart.toString());
//
//		log.info(" inside addItemsToCart");
//
//
//	}
	//findAllCarts method consists of business logic to fetch all the data present in the database

	public List<Cart> findAllCarts() throws CartNotFoundException {

		log.info(" inside findAllCarts ");
		return cartRepository.findAll();

	}



	 
	 
	 // To update or save the cart using email Id
	 //saveOrUpdateItems method consists of business logic to update data already present in  database
	 public Cart saveOrUpdate(Cart cart) throws CartNotFoundException {


			if (cartRepository.existsById(cart.getUserEmailId())) {
				cartRepository.save(cart);
				log.info("inside saveOrUpdate!!");
				return cartRepository.save(cart);

			}

			throw new CartNotFoundException();
		}
	

//To find cart by using user email id method consists of business logic  to fetch specific data present in the database using userEmailId.
	 public Cart findCartByEmailId(String userEmailId) throws CartNotFoundException {

			if (
					cartRepository.existsById(userEmailId)) {

				return cartRepository.findById(userEmailId).get();
			} else{
				Cart newCart=new Cart();
				newCart.setUserEmailId(userEmailId);
				newCart.setItems(new ArrayList<com.stackroute.cartservice.model.Menu>());
				cartRepository.save(newCart);
				return newCart;
			}
//            log.info("inside findCartByEmailId");


		}
	public void emptyCart(String userEmailId)  {
		if (!cartRepository.existsById(userEmailId)) {

//

		}

//
		cartRepository.deleteById(userEmailId);
	}


	 

}
