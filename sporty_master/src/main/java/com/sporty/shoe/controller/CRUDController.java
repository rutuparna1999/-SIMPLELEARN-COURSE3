package com.sporty.shoe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.sporty.shoe.exceptionHandler.BusinessException;
import com.sporty.shoe.model.PurchaseReport;
import com.sporty.shoe.model.Shoe;
import com.sporty.shoe.service.SportyShoesService;
@RestController
public class CRUDController {

	@Autowired
	private SportyShoesService service;

	private MultiValueMap<String, String> errorMap;
	@PostMapping("/admin/shoe")
	public ResponseEntity<Shoe> createShoe(@RequestBody Shoe shoe) {
		try {
			return new ResponseEntity<>(service.createShoe(shoe), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/admin/shoe/{id}")
	public ResponseEntity<Shoe> getShoeById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getShoeById(id), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/admin/shoe")
	public ResponseEntity<Shoe> updateShoe(@RequestBody Shoe shoe) {
		return new ResponseEntity<>(service.updateShoe(shoe), HttpStatus.OK);
	}
	@GetMapping("/admin/shoe")
    public List<Shoe> getAllshoescall() {
        return  service.getAllShoes();
    }
	@DeleteMapping("/admin/shoe/{id}")
	public ResponseEntity<String> deleteShoeById(@PathVariable int id) {
		try {
			service.deleteShoeById(id);
			return new ResponseEntity<>("Succesfully deleted shoe with id: " + id, HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport pr) {
		try {
			return new ResponseEntity<>(service.createPurchaseReport(pr), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/admin/purchaseReport/id/{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getPurchaseReportById(id), HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport pr) {
		return new ResponseEntity<>(service.updatePurchaseReport(pr), HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/purchaseReport/{id}")
	public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id) {
		try {
			service.deletePurchaseReportById(id);
			return new ResponseEntity<>("Succesfully deleted Purchase Report with id: " + id, HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	
}
