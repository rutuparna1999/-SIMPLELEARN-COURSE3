package com.sporty.shoe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Shoe")
public class Shoe {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String category;
	private double price;

}
