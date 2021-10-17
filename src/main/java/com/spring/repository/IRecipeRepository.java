package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Recipe;

public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {

}
