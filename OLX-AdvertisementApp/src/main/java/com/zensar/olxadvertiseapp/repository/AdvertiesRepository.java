package com.zensar.olxadvertiseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxadvertiseapp.entity.OlxAdverties;

public interface AdvertiesRepository extends JpaRepository<OlxAdverties,Integer> {

}
