package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Recipe;
import com.spring.service.IRecipeService;

@RestController
@RequestMapping(value = "/")
public class RecipeController {

	@Autowired
	private IRecipeService recipeService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Recipe> list() {
		return recipeService.list();
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Recipe> findById(@PathVariable Integer id) {
		
		Optional<Recipe> optional= recipeService.findById(id);
		if(optional.isPresent()) {
			return new ResponseEntity<Recipe>(optional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<Recipe>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
	public  ResponseEntity<String>  show(@PathVariable Integer id) {
		Optional<Recipe> optional= recipeService.findById(id);
		if(optional.isPresent()) {
			return new ResponseEntity<String>(optional.get().getImage(), HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	
}
