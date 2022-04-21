package com.zensar.olxapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.entity.Olx;


@RestController
public class OlxController {

	List<Olx> userDetails = new ArrayList<Olx>();

	public OlxController() {
		userDetails.add(new Olx(1, "Ankita", "Ghodake", "ankitag", "ankita@97", "ankita25897@gmail.com", 9985278789L));

	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Olx> createOlxUser(@RequestBody Olx olx, @RequestHeader("auth-token") String token) {
		if (token.contentEquals("ag66543")) {
			userDetails.add(olx);

		} else {
			return new ResponseEntity<Olx>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Olx>(olx, HttpStatus.CREATED);
	}

	@GetMapping("/user")
	
	public List<Olx> getAllUser() {

		return userDetails;

	}

	
	
	
	// @PostMapping
	@RequestMapping(value ="/user/authenticate", method = RequestMethod.POST)
	public String signInDetails(@RequestBody(required=false) String userName, @RequestBody(required=false) String password ,@RequestHeader("auth-token") String token) {
		
		Olx olx=new Olx();
		olx.setUserName("ankitag");
		olx.setPassword("ankita123");
		
		if(token.equals("ag66543")) {
			if(olx.getUserName().equals("ankitag") && olx.getPassword().equals("ankita123"));
			return "Sign in Successfull!!!";
		}
		return "Sign in Failed";
		
	}
	
	
	
	
	
	
	@DeleteMapping("/user/logout/{userId}")
	public String deleteUser(@PathVariable int userId) {
		for (Olx olx: userDetails) {
			if (olx.getUserId() == userId) {
				userDetails.remove(olx);
				return "user deleted Successfully" + userId;
			}
		}
		return "Sorry user is not available";
		
	}
	
	

}
