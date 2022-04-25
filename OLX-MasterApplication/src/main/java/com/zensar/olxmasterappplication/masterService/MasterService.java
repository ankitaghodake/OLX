package com.zensar.olxmasterappplication.masterService;

import java.util.List;

import com.zensar.olxmasterappplication.entity.OlxCategories;
import com.zensar.olxmasterappplication.entity.OlxStatusList;

public interface MasterService {
	List<OlxCategories> getAllAdd();
	List<OlxStatusList> getStatusList();
}
