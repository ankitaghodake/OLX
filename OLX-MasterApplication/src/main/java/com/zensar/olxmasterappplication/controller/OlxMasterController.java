package com.zensar.olxmasterappplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmasterappplication.dto.OlxMasterDto;

import com.zensar.olxmasterappplication.masterService.MasterService;

@RestController
public class OlxMasterController {
@Autowired
	private MasterService masterService;

	// @GetMapping("/advertise/category")
	@RequestMapping(value = "/advertise/category", method = RequestMethod.GET)
	public List<OlxMasterDto> getAllAdd(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,

			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

		return masterService.getAllAdd(pageNumber,pageSize);

	}

	@RequestMapping(value = "/advertise/status", method = RequestMethod.GET)
	public List<OlxMasterDto> getStatusList(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,

			@RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {

		return masterService.getStatusList(pageNumber,pageSize);

	}
}
