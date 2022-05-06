package com.zensar.olxapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olxapplication.entity.Olx;
@Repository
public interface OlxLoginRepository extends JpaRepository<Olx, Integer> {

}
