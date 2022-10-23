package com.sporty.shoe.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sporty.shoe.exceptionHandler.BusinessException;
import com.sporty.shoe.model.PurchaseReport;
import com.sporty.shoe.model.Shoe;
import com.sporty.shoe.repository.PurchaseReportRepository;
import com.sporty.shoe.repository.ShoesRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class SportyShoesService {
	
	@Autowired
	private ShoesRepository shoesRepo;
	
	@Autowired
	private PurchaseReportRepository prRepo;
	public Shoe createShoe(Shoe shoe) throws BusinessException {
		int id = shoe.getId();
		Shoe oldShoe = null;
		try {
			oldShoe = shoesRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldShoe!=null) throw new BusinessException("Shoe already exists with id: "+id);
		return shoesRepo.save(shoe);
	}
	public Shoe getShoeById(int id) throws BusinessException {
		Shoe shoe = null;
		try {
			if(id<=0) throw new BusinessException("Shoe Id can not be negative or zero");
			shoe = shoesRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("Shoe not found with Id: "+id);
		}
		return shoe;
	}
	
	public Shoe updateShoe(Shoe shoe) {
		return shoesRepo.save(shoe);
	}

	public void deleteShoeById(int id) throws BusinessException {
		try {
			shoesRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new BusinessException("SHoe does not exist with id: "+id);
		}
	}

	public List<Shoe> getAllShoes() {
		return shoesRepo.findAll();
	}
	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws BusinessException {
		int id = pr.getId();
		PurchaseReport oldPr = null;
		try {
			oldPr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldPr!=null) throw new BusinessException("Purchase report already exists with id: "+id);
		return prRepo.save(pr);	
	}

	public PurchaseReport getPurchaseReportById(int id) throws BusinessException {
		PurchaseReport pr = null;
		try {
			if(id<=0) throw new BusinessException("Purchase Report Id can not be negative or zero");
			pr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("Purchase Report not found with Id: "+id);
		}
		return pr;
	}
	
	public PurchaseReport updatePurchaseReport(PurchaseReport pr) {
		return prRepo.save(pr);
	}
	
	public void deletePurchaseReportById(int id) throws BusinessException {
		try {
			prRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new BusinessException("Puchase Report does not exist with Id: "+id);
		}
	}


	public List<PurchaseReport> getAllPurchaseReports() {
		return prRepo.findAll();
	}

	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) {
		return prRepo.findByCategory(category);
	}
	

	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date dop) {
		return prRepo.findByDop(dop);
	}


}
