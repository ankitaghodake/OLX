package com.zensar.stockapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.stockapplication.dto.StockDto;
import com.zensar.stockapplication.service.StockService;

/*import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;*/

@RestController
//@CrossOrigin("http:localhost:4200") // port number 4200 can access the application
//by default url//http://localhost:2009/stocks

@RequestMapping(value = "/stocks")
//@ApiIgnore
public class StockController {
	@Autowired
	private StockService stockService;

//custom query
	//http://localhost:4000/stocks/RIL  -> get
	@GetMapping("/name/{stockName}")
public List<StockDto> getStockByName( @PathVariable("stockName") String stockName){
	return stockService.getStockByName(stockName);
	
}
	
	@GetMapping("/name/{stockName}/price/{price}")
	public List<StockDto> getStockByNameAndPrice( @PathVariable("stockName") String stockName,@PathVariable("price") int price){
		return stockService.getStockByNameAndPrice(stockName,price);
		
	}
	
	
	
//http://localhost:2009/stocks/test
	@RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
	public void test() {
		System.out.println("Inside test method");
	}

	//@ApiOperation("Creating stock for user")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<StockDto> createStock1(@RequestBody StockDto stock,
			@RequestHeader("auth-token") String token) {
		StockDto stockEntity = stockService.createStock1(stock, token);
		if (stockEntity == null) {
			return new ResponseEntity<StockDto>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<StockDto>(HttpStatus.CREATED);
		}

	}

//Read all stocks
// http://localhost:2009/stocks
	// @GetMapping // Handler Method
	@RequestMapping(method = RequestMethod.GET)
	public List<StockDto> getAllStocks(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

		return stockService.getAllStocks(pageNumber, pageSize);
	}

//http://localhost:2009/stocks/2 //@PathVariable
//Reading a specific stock
	/*
	 * @GetMapping("/{stockId}")
	 *
	 * @RequestMapping(value = "/{stockId}", method = RequestMethod.GET) public
	 * Stock getStock(@PathVariable("stockId") int id) { for (Stock stock : stocks)
	 * { if (stock.getStockId() == id) { return stock; } } return null; }
	 * 
	 */
	@GetMapping("/{stockId}")
	// @RequestMapping(value = "/{stockId}", method = RequestMethod.GET)
	public StockDto getStock( @PathVariable("stockId") int stockId) {
		return stockService.getStock(stockId);
	}

	/*
	 * @GetMapping("/stocks") public Stock
	 * getStockByRequestParam(@RequestParam(required=false, value="id", defaultValue
	 * ="100") int id ) { for(Stock stock:stocks) { if(stock.getStockId()==id) {
	 * return stock; } } return null; }
	 */
//Creating a stock
	/*
	 * @PostMapping
	 * 
	 * @RequestMapping(value = "/stocks", method = RequestMethod.POST) public Stock
	 * createStock(@RequestBody Stock stock) { stocks.add(stock); return stock; }
	 */

//http://localhost:2009/stocks/200
//Deleting a stock

	@DeleteMapping("/{stockId}")
	public String deleteStock(@PathVariable("stockId") int stockId) {
		return stockService.deleteStock(stockId);
	}

	/*
	 * @DeleteMapping("/{stockId}") public String
	 * deleteStock(@PathVariable("stockId") long stockId) { List dstock=
	 * stocks.stream().filter(stock->stock.getStockId()==stockId).collect(Collectors
	 * .toList()); return "deleted stock is "+dstock; }
	 */

	/*
	 * Updating a stock
	 * 
	 * @PutMapping("/stocks/{stockId}") public String
	 * updateStock(@PathVariable("stockId")long stockId) { for(Stock stock:stocks) {
	 * if(stock.getStockId()==stockId) { stock.setPrice(576.0); return
	 * "Updated stock with stockId: "+stockId;
	 *
	 * } } return null;
	 *
	 * }
	 */
//Updating a Stock
	@PutMapping("/{stockId}")
	public StockDto updateStock(@PathVariable("stockId") int stockId, @RequestBody StockDto stock) {
		return stockService.updateStock(stockId, stock);

	}
//Delete All stocks
//http://localhots:2009/stocks - delete

	/*
	 * @DeleteMapping public ResponseEntity<String> deleteAllStocks(){
	 *
	 * stocks.removeAll(stocks);
	 *
	 * return new
	 * ResponseEntity<String>("All stocks deleted successfully",HttpStatus.OK); }
	 */

}
