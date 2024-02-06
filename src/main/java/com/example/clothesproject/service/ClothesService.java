package com.example.clothesproject.service;

import java.util.List;

import com.example.clothesproject.dto.ClothesDTO;
import com.example.clothesproject.model.Clothes;

public interface ClothesService {

	List<ClothesDTO> getAllDetails(); 

	void addClothes(ClothesDTO clothesDTO);

	void deleteClothes(long clothid);

	ClothesDTO updateClothes(ClothesDTO clothesDTO);

}
