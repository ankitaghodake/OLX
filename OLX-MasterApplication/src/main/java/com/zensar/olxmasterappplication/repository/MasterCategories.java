package com.zensar.olxmasterappplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.olxmasterappplication.entity.OlxCategories;



public interface MasterCategories extends JpaRepository<OlxCategories, Integer>{

	@Query(value="select * from olx_categories where category=:categ",nativeQuery=true)
	List<OlxCategories> findOlxByCategory(@Param("categ") String categ);
}
