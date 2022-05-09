package com.zensar.olxmasterappplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.olxmasterappplication.dto.OlxMasterDto;
import com.zensar.olxmasterappplication.entity.OlxCategories;
import com.zensar.olxmasterappplication.entity.OlxStatusList;

public interface MasterStatus extends JpaRepository<OlxStatusList, Integer> {
	
	@Query(value="select * from olx_status_list where status=:statusList",nativeQuery=true)
	List<OlxStatusList> findOlxByStatus(@Param("statusList") String statusList);
}
