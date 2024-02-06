package com.example.clothesproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.clothesproject.dto.ClothesDTO;
import com.example.clothesproject.dto.ResponseDTO;
import com.example.clothesproject.model.Clothes;
import com.example.clothesproject.service.ClothesService;

@RestController
public class ClothesController {

	@Autowired
	private ClothesService clothesService;

	@GetMapping("/homepage")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("index"); 
		modelAndView.setViewName("index");
		modelAndView.addObject("clothes", clothesService.getAllDetails());
		return modelAndView;
	}

	@GetMapping("/getCloth")
	public ResponseEntity<List<ClothesDTO>> getClothes() {
		return new ResponseEntity<List<ClothesDTO>>(clothesService.getAllDetails(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addCloth")
	public void addClothes(@RequestBody ClothesDTO clothesDTO) {
		clothesService.addClothes(clothesDTO);
	}
	
	@DeleteMapping("/deleteCloth")
	public void deleteClothes(@RequestParam("clothId") long clothId) {
		clothesService.deleteClothes(clothId);
	}
	
	@PutMapping("/editCloth")
	public ResponseEntity<ClothesDTO> updateCloth(@RequestBody ClothesDTO clothesDTO){
		return new ResponseEntity<ClothesDTO>(clothesService.updateClothes(clothesDTO),HttpStatus.ACCEPTED);
	}
}
