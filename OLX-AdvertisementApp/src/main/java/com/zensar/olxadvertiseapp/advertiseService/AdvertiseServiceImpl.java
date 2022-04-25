package com.zensar.olxadvertiseapp.advertiseService;

import java.util.ArrayList;
import java.util.List;

import com.zensar.olxadvertiseapp.entity.OlxAdverties;

public class AdvertiseServiceImpl implements AdvertiseService {

	OlxAdverties olxAdverities = new OlxAdverties();
	static List<OlxAdverties> userAdvertiesDetails = new ArrayList<OlxAdverties>();

	static {
		userAdvertiesDetails.add(new OlxAdverties(1, "Laptop sale", 54000, "electronics good", "Intel core 3 sony viao",
				"ankita", 2104, 2104, "Open"));
	}

	@Override
	public OlxAdverties createOlxUser(OlxAdverties olx, String token) {
		if (token.contentEquals("ag66543")) {
			userAdvertiesDetails.add(olx);
			return olx;
		}
		return null;

	}

	@Override
	public List<OlxAdverties> getAll() {

		return userAdvertiesDetails;
	}

	@Override
	public OlxAdverties getSpecificAdd(int id) {
		OlxAdverties olx = new OlxAdverties();
		if (olx.getId() == id) {
			return olx;
		} else {
			return null;
		}
	}

	@Override
	public OlxAdverties updateStock(int id, OlxAdverties olxAdverties) {
		OlxAdverties availableAdd = getSpecificAdd(id);
		availableAdd.setUserName(olxAdverties.getUserName());
		availableAdd.setTitle(olxAdverties.getTitle());
		availableAdd.setPrice(olxAdverties.getPrice());
		return olxAdverties;
	}

	@Override
	public String deleteUser(int id) {
		for (OlxAdverties olx : userAdvertiesDetails) {
			if (olx.getId() == id) {
				userAdvertiesDetails.remove(olx);
				return "Deleted successfully!!";
			}
		}
		return "Deletion failed";
	}
}
