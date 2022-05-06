package com.zensar.stockapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zensar.stockapplication.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	//@Query("FROM MyStock s where s.stockName=?1")  //jpql
	@Query(value="select * from stock where stock_Name=:name",nativeQuery=true)//sql  //you can try with jpql query also
	List<Stock> findStockByName(@Param("name") String name);

	//@Query("FROM MyStock s where s.stockName=?1 and s.price=?2")
	@Query(value="select * from stock where stock_Name=:name and price=:price",nativeQuery=true)
	List<Stock> findStockByNameAndPrice(@Param("name") String name, @Param("price") int price);
}
