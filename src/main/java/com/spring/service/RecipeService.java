package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Recipe;
import com.spring.repository.IRecipeRepository;

@Service
@Transactional
public class RecipeService implements IRecipeService {
	
	@Autowired
	private IRecipeRepository recipeRepository;

	@Override
	public List<Recipe> list() {
		return recipeRepository.findAll();
	}

	@Override
	public Optional<Recipe> findById(Integer id) {
		return recipeRepository.findById(id);
	}

	@Override
	public void save(List<Recipe> list) {
		
		for(Recipe recipe:list) {
			recipeRepository.save(recipe);
		}

	}

}
