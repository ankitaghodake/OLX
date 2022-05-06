package com.zensar.stockapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zensar.stockapplication.dto.StockDto;
import com.zensar.stockapplication.entity.Stock;
import com.zensar.stockapplication.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	//private ModelMapper modelMapper=new ModelMapper();
	//custom query
	
	
	public List<StockDto> getStockByName(String stockName) {
		List<Stock> findName=stockRepository.findStockByName(stockName);
		List<StockDto> stockResponses = new ArrayList<>();
		for(Stock st:findName) {
			StockDto mapToResponse = mapToResponse(st);
			stockResponses.add(mapToResponse);
		}
		
		return stockResponses;
		
	}
	
	
	public List<StockDto> getStockByNameAndPrice(String stockName,int price) {
		List<Stock> findStockNameAndPrice=stockRepository.findStockByNameAndPrice(stockName,price);
		List<StockDto> stockResponses = new ArrayList<>();
		for(Stock st:findStockNameAndPrice) {
			StockDto mapToResponse = mapToResponse(st);
			stockResponses.add(mapToResponse);
		}
		
		return stockResponses;
	}
	
	@Override
	public List<StockDto> getAllStocks(int pageNumber, int pageSize) {
		Page<Stock> pageStocks = stockRepository.findAll(PageRequest.of(pageNumber, pageSize));
		List<Stock> page = pageStocks.getContent();

		List<StockDto> stockResponses = new ArrayList<>();

		for (Stock stock : page) {
			StockDto mapToResponse = mapToResponse(stock);
			stockResponses.add(mapToResponse);
		}
		return stockResponses;
	}

	@Override
	public StockDto getStock(int stockId) {
		/*
		 * Stock stock= stockRepository.findById(id).get(); StockResponse
		 * mapToResponse=mapToResponse(stock);
		 */
		Stock stock = stockRepository.findById(stockId).get();
		return modelMapper.map(stock, StockDto.class);
//		StockResponse stockResponse = new StockResponse();
//		stockResponse.setStockId(stock.getStockId());
//		stockResponse.setStockName(stock.getStockName());
//		stockResponse.setPrice(stock.getPrice());
//		stockResponse.setMarketName(stock.getMarketName());

		//return stockResponse;

	}
	
	/*
	 * public Stock createStock1(StockRequest stock, String token) { // return
	 * stockRepository.save(stock);
	 * 
	 * Stock availableStock = getStock(stock.getStockId());
	 * 
	 * availableStock.setMarketName(stock.getMarketName());
	 * availableStock.setStockName(stock.getStockName());
	 * availableStock.setPrice(stock.getPrice());
	 * 
	 * Stock newStock=mapToStock(stock); if (token.contentEquals("ag66543")) {
	 * return stockRepository.save(newStock); } else { return null; }
	 * 
	 * 
	 * }
	 */
	@Override
	public StockDto createStock1(StockDto stock, String token) {
		//Stock newStock = mapToStock(stock);
		Stock newStock= modelMapper.map(stock, Stock.class);
		

		if (token.equals("ag66543")) {
			 Stock stock1 = stockRepository.save(newStock);
			return modelMapper.map(stock1, StockDto.class);

		} else {
			return null;
		}
	}
	
	

	@Override
	public String deleteStock(int stockId) {

		stockRepository.deleteById(stockId);
		return "deleted with id " + stockId;

		/*
		 * for (Stock stock : stocks) { if (stock.getStockId() == stockId) {
		 * stocks.remove(stock); return "Stock deleted with stock id " + stockId; } }
		 * return "Sorry,stock id is not available";
		 */
	}

	@Override
	public StockDto updateStock(int stockId, StockDto stock) {
		
		StockDto stockResponse = getStock(stockId);
		
		
		//Stock stock2 = mapToStock(stockResponse);
		
		Stock stock2= modelMapper.map(stock, Stock.class);
		
		/*if(stock2!=null) {
			stock2.setStockId(stockId);
			stock2.setPrice(stock.getPrice());
			stock2.setStockName(stock.getStockName());
			stock2.setMarketName(stock.getMarketName());
		*/
			Stock stock3 = stockRepository.save(stock2);
			return modelMapper.map(stock3, StockDto.class);
	}

	/*
	 * @Override public String deleteAllStocks() { stockRepository.deleteAll();
	 * return "All stocks are deleted successfullyyyy"; }
	 */
	/*
	 * private Stock mapToDto(StockDto stockRequest) {
	 * 
	 * Stock newStock = new Stock();
	 * 
	 * newStock.setMarketName(stockRequest.getMarketName());
	 * newStock.setStockName(stockRequest.getStockName());
	 * newStock.setPrice(stockRequest.getPrice());
	 * 
	 * return newStock;
	 * 
	 * }
	 * 
	 * private Stock mapToStock(StockDto stockResponse) {
	 * 
	 * Stock newStock = new Stock();
	 * newStock.setStockId(stockResponse.getStockId());
	 * newStock.setMarketName(stockResponse.getMarketName());
	 * newStock.setStockName(stockResponse.getStockName());
	 * newStock.setPrice(stockResponse.getPrice());
	 * 
	 * return newStock;
	 * 
	 * }
	 */
	private StockDto mapToResponse(Stock stock) {

		StockDto stockResponse = new StockDto();

		stockResponse.setStockId(stock.getStockId());

		stockResponse.setPrice(stock.getPrice());

		stockResponse.setStockName(stock.getStockName());

		stockResponse.setMarketName(stock.getMarketName());

		return stockResponse;

	}

	
}