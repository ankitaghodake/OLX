package com.zensar.olxmasterappplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmasterappplication.entity.OlxCategories;
import com.zensar.olxmasterappplication.entity.OlxStatusList;
import com.zensar.olxmasterappplication.masterService.MasterService;

@RestController
public class OlxMasterController {
@Autowired
	private MasterService masterService;

	// @GetMapping("/advertise/category")
	@RequestMapping(value = "/advertise/category", method = RequestMethod.GET)
	public List<OlxCategories> getAllAdd() {

		return masterService.getAllAdd();

	}

	@RequestMapping(value = "/advertise/status", method = RequestMethod.GET)
	public List<OlxStatusList> getStatusList() {

		return masterService.getStatusList();

	}
}
