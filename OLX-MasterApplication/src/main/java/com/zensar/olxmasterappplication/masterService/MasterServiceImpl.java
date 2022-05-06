package com.zensar.olxmasterappplication.masterService;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.zensar.olxmasterappplication.entity.OlxCategories;
import com.zensar.olxmasterappplication.entity.OlxRequest;
import com.zensar.olxmasterappplication.entity.OlxResponse;
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

	static {
		userDetails.add(new OlxCategories(1, "Furniture"));
		userDetails.add(new OlxCategories(2, "cars"));
		userDetails.add(new OlxCategories(3, "mobiles"));
		userDetails.add(new OlxCategories(4, "real estate"));
		userDetails.add(new OlxCategories(5, "sports"));
	}
	
	static List<OlxStatusList> userStatus = new ArrayList<OlxStatusList>();
	
	static {
		userStatus.add(new OlxStatusList(1, "OPEN"));
		userStatus.add(new OlxStatusList(2, "CLOSED"));
		

	}

	@Override
	public List<OlxResponse> getAllAdd(int pageNumber, int pageSize) {
		Page<OlxCategories> pageOlx = masterCategories.findAll(PageRequest.of(pageNumber, pageSize));
		List<OlxCategories> page = pageOlx.getContent();

		List<OlxResponse> olxResponses = new ArrayList<>();

		for (OlxCategories olx : page) {
			//OlxResponse mapToResponse = mapToResponse(olx);
			OlxResponse response=modelMapper.map(pageOlx, OlxResponse.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	@Override
	public List<OlxResponse> getStatusList(int pageNumber, int pageSize) {
		
		Page<OlxCategories> pageOlx = masterCategories.findAll(PageRequest.of(pageNumber, pageSize));
		List<OlxCategories> page = pageOlx.getContent();

		List<OlxResponse> olxResponses = new ArrayList<>();

		for (OlxCategories olx : page) {
			//OlxResponse mapToResponse = mapToResponse(olx);
			OlxResponse response=modelMapper.map(pageOlx, OlxResponse.class);
			olxResponses.add(response);
		}
		return olxResponses;
	}

	
	private OlxCategories mapToOlxCategories(OlxRequest olxRequest) {

		OlxCategories newOlx = new OlxCategories();
		newOlx.setId(olxRequest.getId());

		newOlx.setCategory(olxRequest.getCategory());

		return newOlx;
	}

	private OlxCategories mapToOlxCategories(OlxResponse olx) {

		OlxCategories newOlx = new OlxCategories();

		newOlx.setId(olx.getId());

		newOlx.setCategory(olx.getCategory());

		

		return newOlx;

	}

	private OlxResponse mapToResponse(OlxCategories olx) {

		OlxResponse olxResponse = new OlxResponse();

		olxResponse.setId(olx.getId());

		olxResponse.setCategory(olx.getCategory());

		
		return olxResponse;

	}

	

	private OlxStatusList mapToOlxStatus(OlxRequest olxRequest) {

		OlxStatusList newOlx = new OlxStatusList();
		newOlx.setStatusId(olxRequest.getStatusId());

		newOlx.setStatus(olxRequest.getStatus());

		return newOlx;
	}

	private OlxStatusList mapToOlxStatus(OlxResponse olx) {

		OlxStatusList newOlx = new OlxStatusList();

		newOlx.setStatusId(olx.getStatusId());

		newOlx.setStatus(olx.getStatus());


		

		return newOlx;

	}

	private OlxResponse mapToResponse(OlxStatusList olx) {

		OlxResponse olxResponse = new OlxResponse();

		olxResponse.setStatusId(olx.getStatusId());

		olxResponse.setStatus(olx.getStatus());


		
		return olxResponse;

	}

	
}
