package com.zensar.stockapplication.service;

import java.util.List;

import com.zensar.stockapplication.dto.StockDto;

public interface StockService {
	List<StockDto> getAllStocks(int pageNumber,int pageSize);

	StockDto createStock1(StockDto stock, String token);

	StockDto getStock(int stockId);

	String deleteStock(int stockId);

	StockDto updateStock(int id, StockDto stock);

	List<StockDto> getStockByName(String name);

	List<StockDto> getStockByNameAndPrice(String stockName, int price);

}
