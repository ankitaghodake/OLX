package com.zensar.olxmasterappplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmasterappplication.entity.OlxCategories;
import com.zensar.olxmasterappplication.entity.OlxStatusList;

@RestController
public class OlxMasterController {

	List<OlxCategories> userDetails = new ArrayList<OlxCategories>();

	public OlxMasterController() {
		userDetails.add(new OlxCategories(1, "Furniture"));
		userDetails.add(new OlxCategories(2, "cars"));
		userDetails.add(new OlxCategories(3, "mobiles"));
		userDetails.add(new OlxCategories(4, "real estate"));
		userDetails.add(new OlxCategories(5, "sports"));

	}

	// @GetMapping("/advertise/category")
	@RequestMapping(value = "/advertise/category", method = RequestMethod.GET)
	public List<OlxCategories> getAllAdd() {

		return userDetails;

	}

	
	
	static List<OlxStatusList> userStatus = new ArrayList<OlxStatusList>();
	static {
		userStatus.add(new OlxStatusList(1, "OPEN"));
		userStatus.add(new OlxStatusList(2, "CLOSED"));
		

	}

	@RequestMapping(value = "/advertise/status", method = RequestMethod.GET)
	public List<OlxStatusList> getStatusList() {

		return userStatus;

	}
}
