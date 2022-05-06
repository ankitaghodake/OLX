package com.zensar.olxadvertiseapp.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OlxAddDto {
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
