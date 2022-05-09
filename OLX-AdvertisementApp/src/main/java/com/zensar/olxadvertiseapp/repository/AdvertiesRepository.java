package com.zensar.olxadvertiseapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.olxadvertiseapp.entity.OlxAdverties;


public interface AdvertiesRepository extends JpaRepository<OlxAdverties,Integer> {
	@Query(value="select * from olx_adverties where category=:categ",nativeQuery=true)
	List<OlxAdverties> findOlxByCategory(@Param("categ") String categ);

}
