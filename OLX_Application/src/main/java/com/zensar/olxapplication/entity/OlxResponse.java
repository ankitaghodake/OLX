package com.zensar.olxapplication.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OlxResponse {
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String emialId;
	private long mobileNo;
}
