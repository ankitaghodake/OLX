package com.zensar.olxadvertiseapp.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OlxRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private int price;
	private String category;
	private String description;
	private String userName;
	private int createdDate;
	private int modifiedDate;
	private String status;
}
