package com.zensar.olxapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zensar.olxapplication.entity.Olx;

@Repository
public interface OlxLoginRepository extends JpaRepository<Olx, Integer> {

	@Query(value="select * from olx where first_Name=:name",nativeQuery=true)
	List<Olx> findOlxByName(@Param("name") String name);

	
}
