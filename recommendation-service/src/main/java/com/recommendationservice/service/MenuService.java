package com.recommendationservice.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recommendationservice.exceptions.MenuAlreadyExistsException;
import com.recommendationservice.exceptions.MenuNotFoundException;
import com.recommendationservice.model.Menu;
import com.recommendationservice.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepository;

	public List<Menu> getAllMenu() throws MenuNotFoundException {

		if (menuRepository.count() == 0) {
			throw new MenuNotFoundException();
		}
		return menuRepository.getAllMenu();
	}

	public Menu findByItemId(int itemId) throws MenuNotFoundException {
		if (menuRepository.findByItemId(itemId) != null) {
			return menuRepository.findByItemId(itemId);
		}
		throw new MenuNotFoundException();
	}

	public String addMenu(Menu menu) throws MenuAlreadyExistsException {
		if (menuRepository.findByItemId(menu.getItemId()) == null) {
			menuRepository.save(menu);
			return "Menu Added Succesfully";
		}
		throw new MenuAlreadyExistsException();
	}

	public void deleteMenu(int itemId) {
		menuRepository.deleteById(itemId);
	}

	public List<Menu> suggestByCity(String category) {
		return menuRepository.suggestByCity(category);
	}

	public String updateMenu(Menu menu) throws MenuNotFoundException {
		if (menuRepository.findByItemId(menu.getItemId()) != null) {
			menuRepository.save(menu);
			return "Menu Updated Succesfully";
		}
		throw new MenuNotFoundException();

	}
	public Menu getByOrder(int id){
		return menuRepository.getByOrder(id);
	}
}
