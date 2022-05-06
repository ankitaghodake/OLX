package com.zensar.olxmasterappplication.entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OlxCategories {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String category;
}
