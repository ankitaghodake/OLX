package com.zensar.olxmasterappplication.masterService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.olxmasterappplication.entity.OlxCategories;
import com.zensar.olxmasterappplication.entity.OlxStatusList;
@Service
public class MasterServiceImpl implements MasterService {
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
	public List<OlxCategories> getAllAdd() {
		
		return userDetails;
	}

	@Override
	public List<OlxStatusList> getStatusList() {
		
		return userStatus;
	}

	
}
