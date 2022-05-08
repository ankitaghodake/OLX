package com.zensar.olxmasterappplication.masterService;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxmasterappplication.dto.OlxMasterDto;
import com.zensar.olxmasterappplication.entity.OlxCategories;
import com.zensar.olxmasterappplication.entity.OlxStatusList;
import com.zensar.olxmasterappplication.repository.MasterCategories;
import com.zensar.olxmasterappplication.repository.MasterStatus;
@Service
public class MasterServiceImpl implements MasterService {
	
	@Autowired
	private MasterCategories masterCategories;
	@Autowired
	private MasterStatus masterStatus;
	
	private ModelMapper modelMapper=new ModelMapper();
	

	  static List<OlxCategories> userDetails = new ArrayList<OlxCategories>();
	  
	  static { userDetails.add(new OlxCategories(1, "Furniture"));
	  userDetails.add(new OlxCategories(2, "cars")); userDetails.add(new
	  OlxCategories(3, "mobiles")); userDetails.add(new OlxCategories(4,
	  "real estate")); userDetails.add(new OlxCategories(5, "sports")); }
	  
	  static List<OlxStatusList> userStatus = new ArrayList<OlxStatusList>();
	  
	  static { userStatus.add(new OlxStatusList(1, "OPEN")); userStatus.add(new
	  OlxStatusList(2, "CLOSED"));
	  
	  
	  }
	 

	@Override
	public List<OlxMasterDto> getAllAdd(int pageNumber,int pageSize) {
		List<OlxCategories> ListOlx = masterCategories.findAll();
		
		List<OlxMasterDto> olxResponses = new ArrayList<>();

		for (OlxCategories olx : userDetails) {
			//OlxResponse mapToResponse = mapToResponse(olx);
			OlxMasterDto response=modelMapper.map(olx, OlxMasterDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	@Override
	public List<OlxMasterDto> getStatusList(int pageNumber,int pageSize) {
		
		List<OlxStatusList> ListStatus = masterStatus.findAll();
	

		List<OlxMasterDto> olxResponses = new ArrayList<>();

		for (OlxStatusList olx : userStatus) {
			//OlxResponse mapToResponse = mapToResponse(olx);
			OlxMasterDto response=modelMapper.map(olx, OlxMasterDto.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	
	/*
	 * private OlxCategories mapToOlxCategories(OlxMasterDto olxRequest) {
	 * 
	 * OlxCategories newOlx = new OlxCategories(); newOlx.setId(olxRequest.getId());
	 * 
	 * newOlx.setCategory(olxRequest.getCategory());
	 * 
	 * return newOlx; }
	 * 
	 * private OlxCategories mapToOlxCategories1(OlxMasterDto olx) {
	 * 
	 * OlxCategories newOlx = new OlxCategories();
	 * 
	 * newOlx.setId(olx.getId());
	 * 
	 * newOlx.setCategory(olx.getCategory());
	 * 
	 * 
	 * 
	 * return newOlx;
	 * 
	 * }
	 */

	private OlxMasterDto mapToResponse(OlxCategories olx) {

		OlxMasterDto olxResponse = new OlxMasterDto();

		olxResponse.setId(olx.getId());

		olxResponse.setCategory(olx.getCategory());

		
		return olxResponse;

	}

	

	/*
	 * private OlxStatusList mapToOlxStatus(OlxMasterDto olxRequest) {
	 * 
	 * OlxStatusList newOlx = new OlxStatusList();
	 * newOlx.setStatusId(olxRequest.getStatusId());
	 * 
	 * newOlx.setStatus(olxRequest.getStatus());
	 * 
	 * return newOlx; }
	 * 
	 * private OlxStatusList mapToOlxStatus(OlxMasterDto olx) {
	 * 
	 * OlxStatusList newOlx = new OlxStatusList();
	 * 
	 * newOlx.setStatusId(olx.getStatusId());
	 * 
	 * newOlx.setStatus(olx.getStatus());
	 * 
	 * 
	 * 
	 * 
	 * return newOlx;
	 * 
	 * }
	 */

	private OlxMasterDto mapToResponse(OlxStatusList olx) {

		OlxMasterDto olxResponse = new OlxMasterDto();

		olxResponse.setStatusId(olx.getStatusId());

		olxResponse.setStatus(olx.getStatus());


		
		return olxResponse;

	}

	
}
