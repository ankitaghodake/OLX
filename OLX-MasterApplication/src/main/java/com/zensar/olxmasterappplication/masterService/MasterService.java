package com.zensar.olxmasterappplication.masterService;

import java.util.List;

import com.zensar.olxmasterappplication.entity.OlxCategories;
import com.zensar.olxmasterappplication.entity.OlxResponse;
import com.zensar.olxmasterappplication.entity.OlxStatusList;

public interface MasterService {
	List<OlxResponse> getAllAdd(int pageNumber,int pageSize);
	List<OlxResponse> getStatusList(int pageNumber,int pageSize);
}
