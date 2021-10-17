package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.entity.Recipe;

public interface IRecipeService {
	
	public List<Recipe> list();
	
	public Optional<Recipe> findById(Integer id);
	
	public void save(List<Recipe> list);
	

}
