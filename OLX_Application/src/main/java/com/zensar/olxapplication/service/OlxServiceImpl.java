package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.olxapplication.entity.Olx;

@Service
public class OlxServiceImpl implements OlxService {
	Olx olx = new Olx();
	static List<Olx> userDetails = new ArrayList<Olx>();

	static {
		userDetails.add(new Olx(1, "Ankita", "Ghodake", "ankitag", "ankita@97", "ankita25897@gmail.com", 9985278789L));
	}

	@Override
	public List<Olx> getAllUser() {
		return userDetails;
	}

	@Override
	public String signInDetails(String userName, String password, String token) {
		olx.setUserName("ankitag");
		olx.setPassword("ankita123");
		if (token.equals("mj66453")) {
			if (olx.getUserName().equals("ankitag") && olx.getPassword().equals("ankita123")) {
				return "Login Successfull!!!";
			} else {
				return "Sorry, Authentication Failed!!!";
			}
		}
		return "Token is not valid";

	}

	@Override
	public Olx createOlxUser(Olx olx, String token) {
		if (token.contentEquals("ag66543")) {
			userDetails.add(olx);
			return olx;
		}
		return null;

	}

	@Override
	public String deleteUser(int userId) {
		for (Olx olx : userDetails) {
			if (olx.getUserId() == userId) {
				userDetails.remove(olx);
				return "user deleted Successfully" + userId;
			}
		}
		return "Sorry user is not available";

	}
}
