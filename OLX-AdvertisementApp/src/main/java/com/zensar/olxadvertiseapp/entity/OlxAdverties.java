package com.zensar.olxadvertiseapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OlxAdverties {
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
