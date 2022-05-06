package com.zensar.stockapplication.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId; 
	private String stockName;
	private String marketName;
	private int price;
}
