package com.example.clothesproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothesproject.dto.ClothesDTO;
import com.example.clothesproject.model.Clothes;
import com.example.clothesproject.repository.ClothesRepository;

@Service
public class ClothesServiceImpl implements ClothesService {

	@Autowired
	private ClothesRepository clothesRepository;

	@Override
	public List<ClothesDTO> getAllDetails() {

		List<ClothesDTO> clothesDTOs = new ArrayList<>();

		List<Clothes> clothes = clothesRepository.findAll();

		for (Clothes c : clothes) {
			ClothesDTO clothesDTO = new ClothesDTO();
			clothesDTO.setClothId(c.getClothId());
			clothesDTO.setClothName(c.getClothName());
			clothesDTO.setClothBrand(c.getClothBrand());
			clothesDTO.setClothPrice(c.getClothPrice());
			clothesDTOs.add(clothesDTO);
		}
		System.out.println(clothesDTOs);
		return clothesDTOs;
	}

	@Override
	public void addClothes(ClothesDTO clothesDTO) {
		if (clothesDTO.getClothId() == 0) {
			Clothes clothes = new Clothes();
			clothes.setClothId(clothesDTO.getClothId());
			clothes.setClothName(clothesDTO.getClothName());
			clothes.setClothBrand(clothesDTO.getClothBrand());
			clothes.setClothPrice(clothesDTO.getClothPrice());
			clothesRepository.save(clothes);
		} else {
			Clothes editclothes = clothesRepository.findById(clothesDTO.getClothId()).get();
			editclothes.setClothName(clothesDTO.getClothName());
			editclothes.setClothBrand(clothesDTO.getClothBrand());
			editclothes.setClothPrice(clothesDTO.getClothPrice());
			clothesRepository.save(editclothes);
		}
	}

	@Override
	public void deleteClothes(long clothid) {
		clothesRepository.deleteById(clothid);
	}

	@Override
	public ClothesDTO updateClothes(ClothesDTO clothesDTO) {
		Clothes editclothes = clothesRepository.findById(clothesDTO.getClothId()).get();
		ClothesDTO clothesDTO2 = new ClothesDTO();
		clothesDTO2.setClothName(editclothes.getClothName());
		clothesDTO2.setClothBrand(editclothes.getClothBrand());
		clothesDTO2.setClothPrice(editclothes.getClothPrice());
		return clothesDTO2;
	}

}
