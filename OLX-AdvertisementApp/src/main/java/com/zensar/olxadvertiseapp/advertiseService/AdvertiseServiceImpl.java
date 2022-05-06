package com.zensar.olxadvertiseapp.advertiseService;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zensar.olxadvertiseapp.entity.OlxAdverties;
import com.zensar.olxadvertiseapp.entity.OlxRequest;
import com.zensar.olxadvertiseapp.entity.OlxResponse;
import com.zensar.olxadvertiseapp.repository.AdvertiesRepository;


@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	@Autowired
	private AdvertiesRepository advertiesRepository;

	private ModelMapper modelMapper = new ModelMapper();

	OlxAdverties olxAdverities = new OlxAdverties();
	static List<OlxAdverties> userAdvertiesDetails = new ArrayList<OlxAdverties>();

	static {
		userAdvertiesDetails.add(new OlxAdverties(1, "Laptop sale", 54000, "electronics good", "Intel core 3 sony viao",
				"ankita", 2104, 2104, "Open"));
	}

	@Override
	public OlxResponse createOlxUser(OlxRequest olxRequest, String token) {
		OlxAdverties newOlx = modelMapper.map(olxRequest, OlxAdverties.class);

		if (token.equals("ag66543")) {
			OlxAdverties olx1 = advertiesRepository.save(newOlx);
			return modelMapper.map(olx1, OlxResponse.class);

		} else {
			return null;
		}
	}

	@Override
	public List<OlxResponse> getAll(int pageNumber, int pageSize) {
		Page<OlxAdverties> pageOlx = advertiesRepository.findAll(PageRequest.of(pageNumber, pageSize));
		List<OlxAdverties> content = pageOlx.getContent();
		List<OlxResponse> olxAdvertiseResponses = new ArrayList<>();
		for (OlxAdverties stock : content) {
			OlxResponse olx1 = modelMapper.map(pageOlx, OlxResponse.class);
			olxAdvertiseResponses.add(olx1);
		}
		return olxAdvertiseResponses;
	}

	@Override
	public OlxResponse getSpecificAdd(int id) {
		/*
		 * OlxAdverties olx = new OlxAdverties(); if (olx.getId() == id) { return olx; }
		 * else { return null; }
		 */
		OlxAdverties olxResponse = advertiesRepository.findById(id).get();
		return modelMapper.map(olxResponse, OlxResponse.class);
	}

	@Override
	public OlxResponse updateStock(int id, OlxRequest olxrequest) {
		/*
		 * OlxAdverties availableAdd = getSpecificAdd(id);
		 * availableAdd.setUserName(olxAdverties.getUserName());
		 * availableAdd.setTitle(olxAdverties.getTitle());
		 * availableAdd.setPrice(olxAdverties.getPrice()); return olxAdverties;
		 */
		OlxResponse olxResponse = getSpecificAdd(id);

		OlxAdverties olx1 = modelMapper.map(olxrequest, OlxAdverties.class);

		OlxAdverties olx2 = advertiesRepository.save(olx1);
		return modelMapper.map(olx2, OlxResponse.class);
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
