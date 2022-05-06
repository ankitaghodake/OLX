package com.zensar.olxmasterappplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxmasterappplication.entity.OlxCategories;
import com.zensar.olxmasterappplication.entity.OlxStatusList;

public interface MasterStatus extends JpaRepository<OlxStatusList, Integer> {

}
