package com.example.clothesproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothesproject.model.Clothes;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long>{

}
