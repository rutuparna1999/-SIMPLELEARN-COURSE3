package com.sporty.shoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sporty.shoe.model.Shoe;

public interface ShoesRepository extends JpaRepository<Shoe, Integer> {

}
