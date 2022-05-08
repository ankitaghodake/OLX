package com.zensar.olxadvertiseapp.advertiseService;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxadvertiseapp.dto.OlxAddDto;
import com.zensar.olxadvertiseapp.entity.OlxAdverties;
import com.zensar.olxadvertiseapp.repository.AdvertiesRepository;


@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	@Autowired
	private AdvertiesRepository advertiesRepository;

	private ModelMapper modelMapper = new ModelMapper();

	OlxAdverties olxAdverities = new OlxAdverties();
	/*
	 * static List<OlxAdverties> userAdvertiesDetails = new
	 * ArrayList<OlxAdverties>();
	 * 
	 * static { userAdvertiesDetails.add(new OlxAdverties(1, "Laptop sale", 54000,
	 * "electronics good", "Intel core 3 sony viao", "ankita", 2104, 2104, "Open"));
	 * }
	 */

	@Override
	public OlxAddDto createOlxUser(OlxAddDto olxRequest, String token) {
		OlxAdverties newOlx = modelMapper.map(olxRequest, OlxAdverties.class);

		if (token.equals("ag66543")) {
			OlxAdverties olx1 = advertiesRepository.save(newOlx);
			return modelMapper.map(olx1, OlxAddDto.class);

		} else {
			return null;
		}
	}

	@Override
	public List<OlxAddDto> getAll() {
		List<OlxAdverties> ListOlx = advertiesRepository.findAll();
		//List<OlxAdverties> content = pageOlx.getContent();
		List<OlxAddDto> olxAdvertiseResponses = new ArrayList<>();
		for (OlxAdverties stock : ListOlx) {
			OlxAddDto olx1 = modelMapper.map(stock, OlxAddDto.class);
			olxAdvertiseResponses.add(olx1);
		}
		return olxAdvertiseResponses;
	}

	@Override
	public OlxAddDto getSpecificAdd(int id) {
		/*
		 * OlxAdverties olx = new OlxAdverties(); if (olx.getId() == id) { return olx; }
		 * else { return null; }
		 */
		OlxAdverties olxResponse = advertiesRepository.findById(id).get();
		return modelMapper.map(olxResponse, OlxAddDto.class);
	}

	@Override
	public OlxAddDto updateStock(int id, OlxAddDto olxrequest) {
		/*
		 * OlxAdverties availableAdd = getSpecificAdd(id);
		 * availableAdd.setUserName(olxAdverties.getUserName());
		 * availableAdd.setTitle(olxAdverties.getTitle());
		 * availableAdd.setPrice(olxAdverties.getPrice()); return olxAdverties;
		 */
		OlxAddDto olxResponse = getSpecificAdd(id);

		OlxAdverties olx1 = modelMapper.map(olxrequest, OlxAdverties.class);

		OlxAdverties olx2 = advertiesRepository.save(olx1);
		return modelMapper.map(olx2, OlxAddDto.class);
	}

	@Override
	public String deleteUser(int id) {
		advertiesRepository.deleteById(id);
		return "Deleted by id"+id;
}
}
