package com.zensar.olxadvertiseapp.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OlxAdverties {
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
