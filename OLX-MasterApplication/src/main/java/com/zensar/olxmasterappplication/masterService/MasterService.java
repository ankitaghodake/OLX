package com.zensar.olxmasterappplication.masterService;

import java.util.List;

import com.zensar.olxmasterappplication.dto.OlxMasterDto;

public interface MasterService {
	List<OlxMasterDto> getAllAdd(int pageNumber,int pageSize);
	List<OlxMasterDto> getStatusList(int pageNumber,int pageSize);
}
